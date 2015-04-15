<?php
 
/**
 *
 * TWITTER FEED PARSER
 * Copyrights 2013 Rascals Labs
 *
*/


// Get settings
require_once('config.php');

// Cache file
$cache_file = '../cache/tweets.txt';

// Time that the cache was last filled.
$cache_file_created = ((@file_exists($cache_file))) ? @filemtime($cache_file) : 0;

// A flag so we know if the feed was successfully parsed.
$tweet_found = false;

// If keys are empty
if ( $username == '' || $consumer_key == '' || $consumer_secret == '' || $access_token == '' || $access_token_secret == '' ) {

	$tweet_found = false;

// Show file from cache if still valid.
} else if (time() - $twitter_cachetime < $cache_file_created) {

	$tweet_found = true;

	// Display tweets from the cache.
	@readfile($cache_file);	

} else {

	// variables
	$url = "https://api.twitter.com/1.1/statuses/user_timeline.json";
	$count = 1;

	// Replies
  	if (!$ignore_replies) {
  		$exclude_replies = 'false';
  		$replies = '&exclude_replies=false';
  	} else {
  		$exclude_replies = 'true';
  		$replies = '&exclude_replies=true';
  	}

  	$oauth = array(
		'exclude_replies' => $exclude_replies,
		'screen_name' => $username,
      'count' => 20,
		'oauth_consumer_key' => $consumer_key,
		'oauth_nonce' => time(),
		'oauth_signature_method' => 'HMAC-SHA1',
		'oauth_token' => $access_token,
		'oauth_timestamp' => time(),
		'oauth_version' => '1.0'
	);

	$base_info = buildBaseString($url, 'GET', $oauth);
	$composite_key = rawurlencode($consumer_secret) . '&' . rawurlencode($access_token_secret);
	$oauth_signature = base64_encode(hash_hmac('sha1', $base_info, $composite_key, true));
	$oauth['oauth_signature'] = $oauth_signature;

	// Make Requests
	$header = array(buildAuthorizationHeader($oauth), 'Expect:');
	$options = array( 
		CURLOPT_HTTPHEADER => $header,
      //CURLOPT_POSTFIELDS => $postfields,
      CURLOPT_HEADER => false,
      CURLOPT_URL => $url . "?screen_name=$username$replies&count=20",
      CURLOPT_RETURNTRANSFER => true,
      CURLOPT_SSL_VERIFYPEER => false,
      CURLOPT_TIMEOUT => 100,
      CURLOPT_CONNECTTIMEOUT => 10
 	);

	// Initiate the curl session
	$feed = curl_init();

	// Get tweets via CURL
	$feed = curl_init();
	curl_setopt_array($feed, $options);
	$json = curl_exec($feed);
	curl_close($feed);

	// Parse the RSS feed to an JSON object.
	$json = json_decode($json);

	if (isset($json) && !empty($json)){

		/* If feed has error */
		if (is_object($json) && $json->error) {
			echo '<li>' . $json->error . '</li>';
			return;
		}

		// Start output buffering.
		ob_start();

		// Open the twitter wrapping element.
		$tweets = "";
		$tweet_found = true;


		// Iterate over tweets.
		foreach ($json as $tweet) {

			$tweet_text = $tweet->text;

			// check if any entites exist and if so, replace then with hyperlinked versions
			$tweet_text = preg_replace("/((http:\/\/|https:\/\/)[^ )]+)/e", "'<a href=\"$1\" title=\"$1\"  >'. ((strlen('$1')>=250 ? substr('$1',0,250).'...':'$1')).'</a>'", $tweet_text);

			// convert @ to follow
			$tweet_text = preg_replace("/(@([_a-z0-9\-]+))/i","<a href=\"http://twitter.com/$2\" title=\"Follow $2\" >$1</a>",$tweet_text);

 			// convert # to search
			$tweet_text = preg_replace("/(#([_a-z0-9\-]+))/i","<a href=\"https://twitter.com/search?q=%23$2&amp;src=hash\" title=\"Search $1\" >$1</a>",$tweet_text);


			// Convert Tweet display time to a UNIX timestamp. Twitter timestamps are in UTC/GMT time.
			$tweet_time = strtotime($tweet->created_at);	

			if ($twitter_style_dates){

				// Current UNIX timestamp.
				$current_time = time();
				$time_diff = abs($current_time - $tweet_time);

				switch ($time_diff) {
					case ($time_diff < 60):
						$display_time = "$time_diff seconds ago";
					break;
					case ($time_diff >= 60 && $time_diff < 3600):
						$min = floor($time_diff/60);
						$display_time = "$min minute";
						if ($min > 1) $display_time .= "s";
						$display_time .= " ago";
					break;
					case ($time_diff >= 3600 && $time_diff < 86400):
						$hour = floor($time_diff/3600);
						$display_time = "about $hour hour";
						if ($hour > 1) $display_time .= "s";
						$display_time .= " ago";
					break;
					case ($time_diff >= 86400 && $time_diff < 604800):
						$day = floor($time_diff/86400);
						$display_time = "about $day day";
						if ($day > 1) $display_time .= "s";
						$display_time .= " ago";
					break;
					case ($time_diff >= 604800 && $time_diff < 2592000):
						$week = floor($time_diff/604800);
						$display_time = "about $week week";
						if ($week > 1) $display_time .= "s";
						$display_time .= " ago";
					break;
					case ($time_diff >= 2592000 && $time_diff < 31536000):
						$month = floor($time_diff/2592000);
						$display_time = "about $month month";
						if ($month > 1) $display_time .= "s";
						$display_time .= " ago";
					break;
					case ($time_diff > 31536000):
						$display_time = "more than a year ago";
					break;

					default:
						$display_time = date($date_format, $tweet_time);
					break;
				}

			} else {

				$display_time = date($date_format, $tweet_time);

			}

			// Render the tweet.
			$tweets .= "<li>$tweet_text<span class='date'><a href='https://twitter.com/$username/statuses/$tweet->id_str'>$display_time</a></span></li>\n";

		}

		// Close the twitter wrapping element.
		echo $tweets;

		// Generate a new cache file.
		$file = @fopen($cache_file, 'w');

		// Save the contents of output buffer to the file, and flush the buffer. 
		@fwrite($file, ob_get_contents()); 
		@fclose($file); 
		ob_end_flush();

		
	}
}

// In case the RSS feed did not parse or load correctly, show a link to the Twitter account.
if (!$tweet_found){
	echo $tweets = "<li>Oops, our Twitter feed is unavailable at the moment - <a href='http://twitter.com/$username/'>Follow us on Twitter!</a></li>";
}

// Helper twitter functions
function buildBaseString($baseURI, $method, $params) {
	$r = array();
	ksort($params);
	foreach($params as $key=>$value){
		$r[] = "$key=" . rawurlencode($value);
	}
	return $method."&" . rawurlencode($baseURI) . '&' . rawurlencode(implode('&', $r));
}

function buildAuthorizationHeader($oauth) {
	$r = 'Authorization: OAuth ';
	$values = array();
	foreach($oauth as $key=>$value) {
		$values[] = "$key=\"" . rawurlencode($value) . "\"";
	}
	$r .= implode(', ', $values);
	return $r;
}
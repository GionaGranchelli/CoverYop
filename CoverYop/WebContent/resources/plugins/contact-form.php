<?php

// Get email address
require_once 'config.php';

// Ensures no one loads page and does simple spam check
if(isset($_POST['name']) && empty($_POST['spam-check'])) {
	
	// Declare our $errors variable we will be using later to store any errors
	$error = '';
	
	// Setup our basic variables
	$input_name = strip_tags($_POST['name']);
	$input_email = strip_tags($_POST['email']);
	$input_subject = strip_tags($_POST['subject']);
	$input_message = strip_tags($_POST['message']);
	
	// We'll check and see if any of the required fields are empty
	if(strlen($input_name) < 2) $error['name'] = 'Please enter your name.';
	if(strlen($input_message) < 5) $error['message'] = 'Please leave a message.';

	// Make sure the email is valid
	if(!filter_var($input_email, FILTER_VALIDATE_EMAIL) ) $error['email'] = 'Please enter a valid email address.';

	// Set a subject & check if custom subject exist
	$subject = "Message from $input_name";
	if($input_subject ) $subject .= ": $input_subject";
	
	$message = "$input_message\n";
	$message .= "\n---\nThis email was sent by contact form.";

	// Now check to see if there are any errors 
	if(!$error) {

		// No errors, send mail using conditional to ensure it was sent
		if(mail($your_email_address, $subject, $message, "From: $input_email")) {
			echo '<p class="success">Your email has been sent!</p>';
		} else {
			echo '<p class="error">There was a problem sending your email!</p>';
		}
		
	} else {
		
		// Errors were found, output all errors to the user
		$response = (isset($error['name'])) ? $error['name'] . "<br /> \n" : null;
		$response .= (isset($error['email'])) ? $error['email'] . "<br /> \n" : null;
		$response .= (isset($error['message'])) ? $error['message'] . "<br /> \n" : null;

		echo "<p class='warning'>$response</p>";
		
	}
	
} else {

	die('Direct access to this page is not allowed.');

}
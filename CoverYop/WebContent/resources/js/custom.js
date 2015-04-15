// If JavaScript is enabled remove 'no-js' class and give 'js' class
jQuery('html').removeClass('no-js').addClass('js');


// When DOM is fully loaded
jQuery(document).ready(function($) {


	/* Main Settings
	 ---------------------------------------------------------------------- */
	var settings = {
		// Navigation height 
		nav_height: $('#main-nav').css('height').replace('px', ''),

		// Text intro
		text_pause_time : 3000, // Pause between next text
		one_loop : true, // Play only one

		// Navigation
		auto_response : true, // Auto create responsive menu based on main navigation

		// Ajax Loader
		animation_content : false,  // Shows an animation when the content is loaded
		homepage : 'index/',  // Real Path to your homepage
		document_title : document.title // Default document title

	};

	// Configure preloader
	NProgress.configure({ showSpinner: false });

	// Global Variables
	var 
		scamp_player = null,
		revo;

	/* Detect Touch Device */
	if (Modernizr != 'undefined') {

		if (Modernizr.touch) {

			$('body').addClass('touch-device');

		}
	}



	/* Navigation
	 ---------------------------------------------------------------------- */
	(function() {


		/* Main navigation
	 	 ------------------------- */
		var 
			$nav = $( '#nav' ).children( 'ul' );
		
		// Create main navigation
		$( 'li', $nav ).on( 'mouseenter', function() {
			var 
				$this = $( this ),
				$sub  = $this.children( 'ul' );
			if ( $sub.length ) $this.addClass( 'active' );
			$sub.stop( true, true ).addClass( 'show-list' );
		}).on( 'mouseleave', function() {
			$( this ).removeClass( 'active' ).children( 'ul' ).stop( true, true ).removeClass( 'show-list' );
		});


		/* Responsive navigation
	 	 ------------------------- */

		// Auto create responsive menu based on main navigation
		if ( settings.auto_response ) {

			var 
				$responsive = $( '#nav' ).clone();

			// Add class
			$( 'ul:not(:first-child)', $responsive ).addClass( 'dl-submenu' );
			$( '> ul', $responsive ).addClass( 'dl-menu' );

			// Remove main nav container 
			$responsive = $responsive.children( 'ul' );

			// Put menu in nav container
			$( '#dl-menu' ).append( $responsive );

		}

		// Init dlmenu() plugin
		if ( $.fn.dlmenu ) $( '#dl-menu' ).dlmenu();

		// Overflow fix on mobile devices
		$( '#dl-menu ul' ).css( 'max-height', ( $(window).height()-settings.nav_height ) + "px" );
		$(window).resize(function(){
			//var $height = $(window).height()-$("#main-nav").height();
			$( '#dl-menu ul' ).css( 'max-height', ( $(window).height()-settings.nav_height ) + "px" );
		});


		/* Search
	 	 ------------------------- */
		$( '#nav-search, #close-search' ).on( 'click', function(e){
			$( '#search-wrap' ).toggleClass( 'show-search' );
			e.preventDefault();
		});

		
	})();


	/* Dynamic scripts
	 Scripts to be loaded also by ajax.
	 ---------------------------------------------------------------------- */
	function after_page_load(container) {

		/* UPDATE Scamp player content and events
		 ---------------------------------------------------------------------- */
		if ( scamp_player != null ) {
			scamp_player.update_content();
			scamp_player.update_events( 'body' );
		}


		/* Resize Intro
	 	 ---------------------------------------------------------------------- */

	 	if ( $( '.intro-resize' ).length > 0 ) {

			var intro = function(){
				var 
				 	intro = $( '.intro-resize' ),
					win_width = $( window ).width(),
					win_height = $( window ).height(),
					intro_height = win_height;

				intro.css({
					height: intro_height+'px'
				});

				// Center content
				var container = $( '.container', intro ),
					container_height = container.height(),
					intro_h = intro.height(),
					margin = ( intro_h - container_height ) / 2;

				container.css({
					'margin-top' : margin+'px'
				});
			}

			// Init intro
			intro();

			$(window).on( 'resize', intro );

			// Ticker
			function tick(){
				$( '#ticker li:first' ).slideUp({
					duration: 600, 
	    			easing: 'easeOutSine', 
	    			complete: function(){
						$( this ).appendTo( $( '#ticker' ) ).slideDown();
					}
				});
			}
			
			setInterval( function(){ tick() }, 4000);
			

			// Scroll arrow
			function scroll_arrows() {
				$( '#scroll-arrows' ).find('img').stop()
				.animate({
					marginTop: '15px'
				}, 1000, 'easeOutSine', function(){
				    $( '#scroll-arrows' ).find('img').stop().animate({
				        marginTop: '-5px'
				    }, 1000, 'easeInOutSine', function(){
			        	scroll_arrows();
			    	});
			    });
			}
			
			scroll_arrows();
		}


		/* Tweets
	 	 ---------------------------------------------------------------------- */
//		$('.tweets', container).each( function(){
//
//			var 
//				$this = $( this ),
//				$count = $this.data( 'tweets-count' ),
//				$php_url = '/resources/plugins/tweets.php';
//
//			if ( $count == undefined || $count == '' ) $count = 1;
//
//			$this.html( 'Please wait...' );
//
//			$.ajax({
//				url: $php_url,
//				dataType: 'html',
//				timeout: 10000,
//				type: 'GET',
//				error:
//					function(xhr, status, error) {
//						$this.html( 'An error occured: ' + error );
//					},
//				success:
//					function( data, status, xhr ) {
//						$this.html( data ).hide();
//						$( 'li:nth-child(' + $count + ' ) ~ li', $this ).remove();
//						$( 'li:first-child', $this ).addClass( 'first-item' );
//						$this.show();
//					}
//			});
//
//		});


		/* Toggle content
	 	 ---------------------------------------------------------------------- */

	 	if ( $( '.toggle' ).length > 0 ) {
			$( '.toggle' ).each(function() {		  
				
				/* Init */
				$( '.active-toggle', this ).next().show();

				/* List variables */
				var toggle = $( this );
				
				/* Click on Toggle Heading */
				$( '.toggle-title', this ).click(function () {
					if ( $( this ).is( '.active-toggle' ) ) {
						$( this ).removeClass( 'active-toggle' );
						$( '.toggle-content', toggle ).slideUp( 400 );
					} else {
						$( this ).addClass( 'active-toggle' );
						$( '.toggle-content', toggle ).slideDown( 400 );
					}
					return false;
				});
				
			});
		}


		/* Tabs
	 	 ---------------------------------------------------------------------- */

	 	if ( $( '.tabs-wrap' ).length > 0 ) {
			$( '.tabs-wrap' ).each(function() {		  
				
				/* List variables */
				var tabs = $(this);
				
				/* Init */
				$( '.tab-content', this ).hide();
				$( '.tab-content:first', this ).css( 'display', 'block' );
				$( 'ul.tabs li:first a', this ).addClass( 'active-tab' );
				
				/* Click on Tab */
				$( 'ul.tabs li', this ).click( function () {
					if ( ! $( this ).is( 'tab-active' ) ) {
						var current_id = $( this ).find( 'a' ).attr( 'href' );
						$( 'ul.tabs li a', tabs ).removeClass( 'active-tab' );
						$( 'a', this ).addClass('active-tab' );
						$( '.tab-content:not(:eq(' + current_id + '))', tabs ).css( 'display', 'none' );
						$( current_id, tabs ).css( 'display', 'block' );
					}
					return false;
				});
				
			});
		}


		/* Resonsive videos
	 	 ---------------------------------------------------------------------- */
		if ( $.fn.ResVid ) {
			$( container ).ResVid();
		}


		/* Fancybox (lightbox)
	 	 ---------------------------------------------------------------------- */
	 	function formatTitle( title, currentArray, currentIndex, currentOpts ) {
    		return '<div id="fancybox-title">' + ( title && title.length ? title : '' ) + '<span>(' + ( currentIndex + 1 ) + ' / ' + currentArray.length + ')</span></div>';
		}

	 	// Add Fancybox only for images
		$( '.imagebox', container ).fancybox({
			overlayOpacity : .9,
			overlayColor: '#000',
			padding: 0,
			titleFormat: formatTitle
		});

		// Add Fancybox only for media
		$('.mediabox', container ).fancybox({
			type: 'iframe',
			centerOnScroll : true,
			autoScale : true,
			overlayOpacity : .9,
			padding: 0,
			overlayColor: '#000',
			titleFormat: formatTitle,
		
			onStart : function(e) {
				var 
					$el = $(e);

				if ( $el.data( 'width' ) != 'auto' )
					this.width = $el.data( 'width' );
				if ( $el.data( 'height' ) != 'auto' )
					this.height = $el.data( 'height' );
        	}
		});


		/* Thumb slider
	 	 ---------------------------------------------------------------------- */

 	 	if ( ! Modernizr.touch && $.fn.thumbSlider ) {

			// Disable Thumb slide effect on touch devices
			if ( $( '.thumb-slide' ).length > 0 ) {

				// Init thumb slider
				$( '.thumb-slide' ).thumbSlider();
			}
		}



		/* TopTip - Tooltip
	 	 ---------------------------------------------------------------------- */

		// Disable TopTip effect on touch devices
		if ( ! Modernizr.touch && $.fn.topTip ) {

			// Init thumb Tooltip
			$( '.tip', container ).topTip();
		}


		/* Countdown
	 	 ---------------------------------------------------------------------- */
		if ( $.fn.countdown ) {

			$( '.countdown-wrap', container ).each( function(e) {
				var date = $( this ).data( 'event-date' );

		        $( this ).countdown( date, function( event ) {
		            var $this = $( this );

		            switch( event.type ) {
		                case "seconds":
		                case "minutes":
		                case "hours":
		                case "days":
		                case "weeks":
		                case "daysLeft":
		                    $this.find( '.' + event.type ).html( event.value );
		                    break;

		                case "finished":
		              
		                    break;
		            }
		        });
		    });
	    }


	    /* Revoslider
	 	 ---------------------------------------------------------------------- */

	 	if ( $('.fullwidthbanner' ).length > 0 ) {

	 		// Remove iframe fullvideo on touch devices
	 		if ( $( '.fullwidthbanner .iframe-fullscreen-video' ).length > 0  && Modernizr.touch ) {
	 			$( '.fullwidthbanner .iframe-fullscreen-video' ).remove();
	 		}

		 	if ( $.fn.cssOriginal != undefined )
	    		$.fn.css = $.fn.cssOriginal;
		    revo = $( '.fullwidthbanner', container ).revolution( {	
				delay: 9000,												
				startwidth: 1170,
				startheight: 620,
				onHoverStop: 'on',						// Stop Banner Timet at Hover on Slide on/off
				thumbWidth: 100,						// Thumb With and Height and Amount (only if navigation Tyope set to thumb !)
				thumbHeight: 50,
				thumbAmount: 4,
				hideThumbs: 200,
				navigationType: 'both',					// Bullet, thumb, none, both	 (No Shadow in Fullwidth Version !)
				navigationArrows: 'verticalcentered',	// Nexttobullets, verticalcentered, none
				navigationStyle: 'round',				// Round,square,navbar
				touchenabled: 'on',						// Enable Swipe Function : on/off
				navOffsetHorizontal: 0,
				navOffsetVertical: 20,
				fullWidth: 'on',
				shadow: 0								//0 = no Shadow, 1,2,3 = 3 Different Art of Shadows -  (No Shadow in Fullwidth Version !)
			});
		}


	    /* Nice Select
	 	 ---------------------------------------------------------------------- */
	  	$( '.nice-select', container ).niceselect();


	    /* Masonry
	 	 ---------------------------------------------------------------------- */
		$( '.masonry', container ).isotope({
			portfolioelector : '.item',
			hiddenStyle: /msie [1-8]./.test(navigator.userAgent.toLowerCase()) ? { opacity: 0, top: -400 } : { opacity: 0, scale: 0.001 },
			transformsEnabled: /msie [10]./.test(navigator.userAgent.toLowerCase()) ? false : true
		});

		setTimeout( function(){ $( '.masonry', container ).isotope( 'reLayout' ) }, 1000);


		/* Masonry Filters
		 ------------------------- */

		// Grab all filters
		if ( $( '.filters', container ).length ) {

			$( '.filters', container ).each(function() {
				var 
					ID = $( this ).data( 'id' );

					if ( ID == undefined ) return;

				$( '.filters .filter', container ).each(function(){

					var 
						filter = $( this ).find( 'input' ).attr( 'name' );

					if ( filter == undefined ) return;
					
					$( '#'+ ID +' .item' ).each(function(){
						var 
							$this = $( this );
							$this.addClass( $this.data( filter ) );
					});

					$( this ).addClass( 'ready-filter' ).attr( 'data-id', ID ).attr( 'data-filter', filter );

				});
			});

		}


		/* Carousel and slider
	 	 ---------------------------------------------------------------------- */
		$( '.carousel', container ).each( function(){

			var id = $( this ).attr( 'id' );

			if ( id == undefined ) return;

			$( '#' + id ).owlCarousel({
		 
			    // Most important owl features
			    items : 4,
			    itemsCustom : false,
			    itemsDesktop : [1199,4],
			    itemsDesktopSmall : [980,4],
			    itemsTablet: [768,2],
			    itemsTabletSmall: [600,2],
			    itemsMobile : [479,1],
			    singleItem : false,
			    itemsScaleUp : false,
			 
			    //Basic Speeds
			    slideSpeed : 200,
			    paginationSpeed : 800,
			    rewindSpeed : 1000,
			 
			    //Autoplay
			    autoPlay : false,
			    stopOnHover : false,
			 
			    // Navigation
			    navigation : false,
			    navigationText : ["prev","next"],
			    rewindNav : true,
			    scrollPerPage : false,
			 
			    //Pagination
			    pagination : true,
			    paginationNumbers: false,
			 
			    // Responsive 
			    responsive: true,
			    responsiveRefreshRate : 200,
			    responsiveBaseWidth: window,
			 
			    // CSS Styles
			    baseClass : "owl-carousel",
			    theme : "owl-theme",
			 
			    //Lazy load
			    lazyLoad : false,
			    lazyFollow : true,
			    lazyEffect : "fade",
			 
			    //Auto height
			    autoHeight : false,
			 
			    //JSON 
			    jsonPath : false, 
			    jsonSuccess : false,
			 
			    //Mouse Events
			    dragBeforeAnimFinish : true,
			    mouseDrag : true,
			    touchDrag : true,
			 
			    //Transitions
			    transitionStyle : false,
			 
			    // Other
			    addClassActive : false,
			 
			});

		});
		
		// Carousel slider
		$( '.carousel-slider', container ).each( function(){

			var id = $( this ).attr( 'id' ),
				effect = $( this ).data( 'effect' ),
				nav = $( this ).data( 'nav' ),
				pagination = $( this ).data( 'pagination' );

			if ( id == undefined ) return;
			
			$( '#' + id ).owlCarousel({
			    navigation : nav,
			    pagination : pagination,
			    navigationText: [
			      "<i class='icon icon-chevron-left'></i>",
			      "<i class='icon icon-chevron-right'></i>"
			    ],
			    singleItem : true,
			    transitionStyle : effect
	  		});
	  	});


	  	/* Google maps
	 	 ---------------------------------------------------------------------- */
		if ($.fn.gMap && $( '.gmap' ).length ) {

			$('.gmap', container).each(function(){
				var 
					$gmap = $(this),
					$address = $gmap.data('address'), // Google map address e.g 'Level 13, 2 Elizabeth St, Melbourne Victoria 3000 Australia'
					$zoom = $gmap.data('zoom'),// Map zoom value. Default: 16
					$zoom_control = $gmap.data('zoom_control'), // Use map zoom. Default: true
					$scrollwheel = $gmap.data('scrollwheel'); // Enable mouse scroll whell for map zooming: Default: false

				$gmap.gMap({
					address: $address,
					zoom: $zoom,
					zoomControl: $zoom_control,
					scrollwheel: $scrollwheel,
					markers: [
						{ 'address' : $address }
					],
					icon: {
				    	image: '../resources/img/map-marker.png',
				    	iconsize: [48,56],
				    	iconanchor: [20,56]
				    }
				});

			});
		}

	}

	// Init scripts
	after_page_load( 'body' );


	/* Remove old plugins after page loaded
	 ---------------------------------------------------------------------- */
	
	function remove_plugins() {

		// OWL
		$( '#ajax-container .carousel, #ajax-container .carousel-slider').each( function(){

			var id = $( this ).attr( 'id' );

			if ( id == undefined ) return;

			// Destroy carousel if exists
			if ( $( '#' + id ).data( 'owlCarousel') != undefined ) {
				$( '#' + id ).data( 'owlCarousel' ).destroy();
			}
		});

		// Isotope
		$( '#ajax-container .masonry' ).isotope( 'destroy' );

		// Revoslider
		if ( revo != undefined || revo != null ) {
			revo.revpause();
			revo = null;
		}

	}


	/* Scamp Player
	 ---------------------------------------------------------------------- */

	(function() {
	
		scamp_player = new $.ScampPlayer( $( '#scamp_player' ), {

			// Default Scamp Player options
			volume : 40, // Start volume level
			autoplay : false, // Autoplay track
			no_track_image : 'js/scamp_player/img/no-track-image.png', // Placeholder image for track cover
			loop : false, // Loop tracklist
			random : false, // Random playing
			titlebar : true, // Replace browser title on track title
			check_files : false, // Checks whether a track file exists
			client_id : "23f5c38e0aa354cdd0e1a6b4286f6aa4", // Soundcloud Client ID
			onReady : function() {
				// Callback function
				
			},

			// Soundmanager2 options
			sm_options : { 
				url: 'js/scamp_player/js/swf/', 
				flashVersion: 9, 
				preferFlash: false, 
				useHTML5Audio: true, 
				allowScriptAccess: 'always', 
				debugMode: false, 
				debugFlash: false, 
				useConsole: false 
			}
			
		});
	})();


	/* Small Functions
	 ---------------------------------------------------------------------- */
	(function() {

		/* Smooth Scroll
	 	 ------------------------- */
		$( 'body' ).on( 'click', '.smooth-scroll',  function(e){
			var
				$id = $( this ).attr( 'href' );

			// If element exists
			if ( $( $id ).length ) {
				$.scrollTo( $id, 750, {
					easing: 'swing',
					offset: { top:-settings.nav_height, left:0 }
				});
			}
			e.preventDefault();
		});


		/* Thumb Glitch effect
		 ------------------------- */

		// Disable Thumb slide effect on touch devices
		if ( ! Modernizr.touch && $.fn.thumbGlitch ) {

			// Init glitch thumb effect
			$( 'body' ).thumbGlitch();
		}


		/* Masonry Filters
		 ------------------------- */
		$( 'body' ).on( 'change', '.ready-filter', function(){
			var 
				ID = $( this ).data( 'id' ),
				query = '';

			if ( ID == undefined ) return false;

			// Select all filters
			$( '.filters [data-id="' + ID + '"]').each(function(){
				var
					option = $( this ).find( '.value_wrapper > .active input' ).val();

				if ( option != undefined ) {
					if ( option != '*' ) {
						option = option.replace( option, '.' + option );
						query += option;
					}
				}

			});
			if ( query == '' ) query = '*';

			$( '#'+ID ).isotope({ filter : query });

			setTimeout( function(){ $( '#'+ID ).isotope( 'reLayout' ) }, 500);

		});


		/* Masonry reLayout
		 ------------------------- */
		$(window).on( 'resize', function(){
    		setTimeout( function(){ $( '.masonry' ).isotope( 'reLayout' ) }, 500);
		});


	})();


	/* Ajax HashBang! Loader
	 ---------------------------------------------------------------------- */
	(function() {

		var 
			is_index = false,
			link = null,
			url = null;


		var init_ajax = function(event) {
			var link_url = $(event.currentTarget).attr( 'href' );

			link = $(event.currentTarget);

			if ( link_url == 'javascript:;' ) return false;

			if ( link.hasClass( 'selected' ) )
				return false;

			var path_array = link_url.split( '/' );
		
			if ( path_array.length == 1 && path_array[0] == '#!' )  {
		
				window.location.hash = '#!/home';
				
			} else if ( path_array.length == 2 && path_array[1].indexOf( 'index' ) >= 0 ) {

				window.location.hash = '#!/home';
				
			} else {
				window.location.hash = link_url;
			}

			event.preventDefault;
			return false;
		}

		$( 'body' ).on( 'click', 'a[href$="#!"]', init_ajax);


		function check_hash() {
    		
        	// Compare hash link
			var hash = window.location.hash,
				path_array = hash.replace( '#!/', '' );
				path_array = path_array.split( '/' );

			if ( path_array.length == 1 ) {
				// Load home
				if ( hash == '' || hash == '#!/' || hash == "#!/index"  || hash == "#!/home") {
					is_index = true;
					url = settings.homepage;
					load_content();
					return;
				} else {
					if ( hash.indexOf( '#!' ) === -1 ) return false;
					hash = hash.replace( '#!/','' );
					hash += '.html';
					url = hash;
					load_content();
					return;
				}

			} else {
				if ( hash.indexOf( '#!' ) === -1 ) return false;
				var temp_url = path_array.join( '/' );
				
				temp_url = temp_url + '.html';
				url = temp_url;
				
				load_content();
				return;
			}
			
			return;
        }

        $( window ).bind( 'hashchange', check_hash );

        check_hash();

		function load_content() {

			// Loading layer
			$( 'body' ).append( '<div id="loading-layer"></div>' );

			// Show loader
			NProgress.start();

			$.ajax({
		        type: 'POST',
		        url: url,
		        timeout: 5000,
		        data: null,	
		        dataType: 'html',	//expect html to be returned
		        success: function( response ){

		            if ( parseInt( response ) != 0 ) {

		            	var content = $( response );

		            	// If content has images
		            	if ( $( 'img', content ).length > 0 ) {
		            		load_images( content );
		            	} else {
		            		show_content( content );
		            	}
					
		            	return false;


		            } else {

						// Hide preloader
						NProgress.done();
						// Loading
						$( '#loading-layer' ).remove();

						return false;
		            }
		        },
		        error: function (xhr, ajaxOptions, thrownError){
			        console.log(xhr.status);
			        console.log(xhr.statusText);
			        console.log(xhr.responseText);

			        // Hide preloader
					NProgress.done();
					// Loading
					$( '#loading-layer' ).remove();

					return false;
			    }

		    });

		}

		function load_images( content ) {

			/* Check images are loaded */
			var 
				image_count = $( 'img', content ).length,
				images_loaded = 0;
	
			$( 'img', content ).load(function() {
				images_loaded++;

				if ( images_loaded >= image_count ) {
					show_content( content );
					return false;
				}
			})
			.error(function() {
				image_count--;
				if ( images_loaded >= image_count ) {
					show_content( content );
					return false;
				}
			});
		}

		function show_content( content ){
			
			remove_plugins();

			// Navigation class
			var hash = window.location.hash;
			$( '#main-nav-wrapper a.selected' ).removeClass( 'selected' );
			$( '#main-nav-wrapper a[href="' + hash + '"]' ).addClass( 'selected' );

			// Add selected class to the first main menu element
			var selected = $( '#nav a[href="' + hash + '"]' ).addClass( 'selected' );
			
			if ( selected.parents( 'li.submenu' ).length > 0 ) {
				selected.parents('li.submenu').children('a:eq(0)').addClass( 'selected' );
			}

			// Jump
			window.scrollTo(0, 0);

			$( '#ajax-container' ).removeClass( 'loaded' );
			$( '#ajax-container' ).empty();

			pag_content = content;
			
			$( '#ajax-container' ).append( content );

			after_page_load( content );

			if ( settings.animation_content ) 
				$( '#ajax-container' ).addClass( 'loaded animation' );
			else
				$( '#ajax-container' ).addClass( 'loaded' );

			// Replace document title
			var new_title = $('#page').data('title');

			if ( new_title == undefined || new_title == '' )
				document.title = settings.document_title;
			else
				document.title = new_title

			// Hide preloader
			NProgress.done();

			is_index = false;

			// Loading
			$( '#loading-layer' ).remove();
		}



	})();

});


/* Small Plugins
 ---------------------------------------------------------------------- */

// HTML5 Placeholder support for non compliant browsers using jQuery.
(function($) {
  // @todo Document this.
  $.extend($,{ placeholder: {
      browser_supported: function() {
        return this._supported !== undefined ?
          this._supported :
          ( this._supported = !!('placeholder' in $('<input type="text">')[0]) );
      },
      shim: function(opts) {
        var config = {
          color: '#888',
          cls: 'placeholder',
          selector: 'input[placeholder], textarea[placeholder]'
        };
        $.extend(config,opts);
        return !this.browser_supported() && $(config.selector)._placeholder_shim(config);
      }
  }});

  $.extend($.fn,{
    _placeholder_shim: function(config) {
      function calcPositionCss(target)
      {
        var op = $(target).offsetParent().offset();
        var ot = $(target).offset();

        return {
          top: ot.top - op.top,
          left: ot.left - op.left,
          width: $(target).width()
        };
      }
      function adjustToResizing(label) {
      	var $target = label.data('target');
      	if(typeof $target !== "undefined") {
          label.css(calcPositionCss($target));
          $(window).one("resize", function () { adjustToResizing(label); });
        }
      }
      return this.each(function() {
        var $this = $(this);

        if( $this.is(':visible') ) {

          if( $this.data('placeholder') ) {
            var $ol = $this.data('placeholder');
            $ol.css(calcPositionCss($this));
            return true;
          }

          var possible_line_height = {};
          if( !$this.is('textarea') && $this.css('height') != 'auto') {
            possible_line_height = { lineHeight: $this.css('height'), whiteSpace: 'nowrap' };
          }

          var ol = $('<label />')
            .text($this.attr('placeholder'))
            .addClass(config.cls)
            .css($.extend({
              position:'absolute',
              display: 'inline',
              'float':'none',
              overflow:'hidden',
              textAlign: 'left',
              color: config.color,
              cursor: 'text',
              paddingTop: 0,
              paddingRight: $this.css('padding-right'),
              paddingBottom: 0,
              paddingLeft: $this.css('padding-left'),
              fontSize: $this.css('font-size'),
              fontFamily: $this.css('font-family'),
              fontStyle: $this.css('font-style'),
              fontWeight: $this.css('font-weight'),
              textTransform: $this.css('text-transform'),
              backgroundColor: 'transparent',
              zIndex: 99
            }, possible_line_height))
            .css(calcPositionCss(this))
            .attr('for', this.id)
            .data('target',$this)
            .click(function(){
              $(this).data('target').focus();
            })
            .insertBefore(this);
          $this
            .data('placeholder',ol)
            .focus(function(){
              ol.hide();
            }).blur(function() {
              ol[$this.val().length ? 'hide' : 'show']();
            }).triggerHandler('blur');
          $(window).one("resize", function () { adjustToResizing(ol); });
        }
      });
    }
  });
})(jQuery);

jQuery(document).add(window).bind('ready load', function() {
  if (jQuery.placeholder) {
    jQuery.placeholder.shim();
  }
});
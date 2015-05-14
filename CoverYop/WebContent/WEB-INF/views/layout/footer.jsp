<%@page import="java.util.Calendar"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<script>
$(document).ready(function(){
		$("li#accedi").click(function(){
			$("div.login-sovra").css("display", "block");
		});
		
		
		
		
});
</script>
<footer id="footer">
	<!-- container -->
	<div class="container footer-widgets">
		<div class="col-1-2">
			<div class="widget text-widget">
				<h3>Chi Siamo</h3>
				<p>CoverYop nasce come luogo d'incontro per <strong>gruppi e locali</strong> </p>
				
				<p> Su Yop le giovani Band Nascono e si pubblicizzano </p>
				
				<p> Su Yop i Locali vengono trovati e aiutati per le loro serate </p>
			</div>
		</div>

<!-- 		<div class="col-1-4"> -->
<!-- 			<div class="widget widget_recent_entries"> -->
<!-- 				<h3>Latest Posts</h3> -->
<!-- 				<ul> -->
<!-- 					<li> -->
<%-- 						<a href="${pageContext.request.contextPath}/resources/javascript:;">Post with Slider.</a> --%>
<!-- 					</li> -->
<!-- 					<li> -->
<%-- 						<a href="${pageContext.request.contextPath}/resources/javascript:;">Music Post.</a> --%>
<!-- 					</li> -->
<!-- 					<li> -->
<%-- 						<a href="${pageContext.request.contextPath}/resources/javascript:;">Wide Post.</a> --%>
<!-- 					</li> -->
<!-- 					<li> -->
<%-- 						<a href="${pageContext.request.contextPath}/resources/javascript:;">Vimeo video.</a> --%>
<!-- 					</li> -->
<!-- 					<li> -->
<%-- 						<a href="${pageContext.request.contextPath}/resources/javascript:;">Post with Quote.</a> --%>
<!-- 					</li> -->
<!-- 				</ul> -->
<!-- 			</div> -->

<!-- 		</div> -->

		<div class="col-1-2 last">
			            <a class="twitter-timeline"  href="https://twitter.com/CoverYop" data-widget-id="590459636567908352">Tweet di @CoverYop</a>
            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
          
		</div>

<!-- 		<div class="col-1-4 last"> -->
			
<!-- 			<div class="widget widget_recent_gallery"> -->
<!-- 				<h3>Latest Gallery Albums</h3> -->
<!-- 				<div class="gallery-3-col"> -->
<%-- 					<a href="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb01.jpg" class="gallery-item imagebox thumb-icon" title="Image Title" data-group="group1"> --%>
<%--                         <img src="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb01.jpg" alt="Image Title"> --%>
<!--                         <span class="icon-wrap"> -->
<!--                             icon from icomoon -->
<!--                             <span class="icon icon-search"></span> -->
<!--                         </span> -->
<!--                     </a> -->
<%--                     <a href="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb02.jpg" class="gallery-item imagebox thumb-icon" title="Image Title" data-group="group1"> --%>
<%--                         <img src="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb02.jpg" alt="Image Title"> --%>
<!--                         <span class="icon-wrap"> -->
<!--                             icon from icomoon -->
<!--                             <span class="icon icon-search"></span> -->
<!--                         </span> -->
<!--                     </a> -->
<%--                     <a href="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb03.jpg" class="gallery-item imagebox thumb-icon" title="Image Title" data-group="group1"> --%>
<%--                         <img src="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb03.jpg" alt="Image Title"> --%>
<!--                         <span class="icon-wrap"> -->
<!--                             icon from icomoon -->
<!--                             <span class="icon icon-search"></span> -->
<!--                         </span> -->
<!--                     </a> -->
<%--                     <a href="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb04.jpg" class="gallery-item imagebox thumb-icon" title="Image Title" data-group="group1"> --%>
<%--                         <img src="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb04.jpg" alt="Image Title"> --%>
<!--                         <span class="icon-wrap"> -->
<!--                             icon from icomoon -->
<!--                             <span class="icon icon-search"></span> -->
<!--                         </span> -->
<!--                     </a> -->
<%--                     <a href="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb05.jpg" class="gallery-item imagebox thumb-icon" title="Image Title" data-group="group1"> --%>
<%--                         <img src="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb05.jpg" alt="Image Title"> --%>
<!--                         <span class="icon-wrap"> -->
<!--                             icon from icomoon -->
<!--                             <span class="icon icon-search"></span> -->
<!--                         </span> -->
<!--                     </a> -->
<%--                     <a href="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb06.jpg" class="gallery-item imagebox thumb-icon" title="Image Title" data-group="group1"> --%>
<%--                         <img src="${pageContext.request.contextPath}/resources/placeholders/gallery-thumb06.jpg" alt="Image Title"> --%>
<!--                         <span class="icon-wrap"> -->
<!--                             icon from icomoon -->
<!--                             <span class="icon icon-search"></span> -->
<!--                         </span> -->
<!--                     </a> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</div>
	<!-- /container -->

	<!-- Footer social -->
	<div id="footer-social">
		<!-- Container -->
		<div class="container">
			<!-- Footer socials icons -->
			<a class="social-icon" href="${pageContext.request.contextPath}/resources/javascript:;"><i class="icon icon-twitter"></i></a>
			<a class="social-icon" href="${pageContext.request.contextPath}/resources/javascript:;"><i class="icon icon-facebook"></i></a>
			<a class="social-icon" href="${pageContext.request.contextPath}/resources/javascript:;"><i class="icon icon-soundcloud"></i></a>
			<a class="social-icon" href="${pageContext.request.contextPath}/resources/javascript:;"><i class="icon icon-vimeo"></i></a>
			<a class="social-icon" href="${pageContext.request.contextPath}/resources/javascript:;"><i class="icon icon-youtube"></i></a>
			<a class="social-icon" href="${pageContext.request.contextPath}/resources/javascript:;"><i class="icon icon-flickr"></i></a>
		</div>
		<!-- /container -->
	</div>
	<!-- /footer social -->

	<!-- Footer Bottom -->
	<div id="footer-bottom" class="container">
		<!-- Footer logo -->
		<div class="footer-logo col-1-2">
			<img src="${pageContext.request.contextPath}/resources/placeholders/logo.png" alt="Logo">
		</div>
		<!-- /footer logo -->

		<!-- Footer copyrights -->
		<div class="footer-copyrights col-1-2 last">
			Copyright &copy; 2013-2014 - Squadra Genew Porchetta Team Club. All rights reserved.
		</div>
		<!-- /footer copyrights -->
	</div>
	<!-- /footer bottom -->
</footer>
<!-- /footer -->

<!-- ############################# Scamp Player ############################# -->
<!-- Special classes: sp-show-player sp-show-list -->
<div id="scamp_player" class="sp-show-player">
	  <a href="${pageContext.request.contextPath}/resources/placeholders/mp3/adg3com_bustedchump.mp3" data-cover="${pageContext.request.contextPath}/resources/placeholders/release-image01.jpg">ADG3 Studios - Busted Chump</a>
</div>

<!-- ############################# javascripts ############################# -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.easing-1.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.small.plugins.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.dlmenu.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/smoothscroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.isotope.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/nprogress.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.countdown.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/nice_select.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fancybox-1.3.4.pack.js"></script>
<!-- Google Maps -->
<script src="https://maps.google.com/maps/api/js?sensor=false"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.gmap.min.js"></script>
<!-- /Google Maps -->
<!-- jQuery REVOLUTION Slider  -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
<!-- Scamp Player -->
<script src="https://connect.soundcloud.com/sdk.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scamp_player/js/soundmanager2-jsmin.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scamp_player/js/iscroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scamp_player/jquery.scamp.player.min.js"></script>
<!-- /Scamp Player -->
<!-- custom scripts -->
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>

<!-- JQUery FIle Upload -->
<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
<script src="//blueimp.github.io/JavaScript-Load-Image/js/load-image.all.min.js"></script>
<!-- The Canvas to Blob plugin is included for image resizing functionality -->
<script src="//blueimp.github.io/JavaScript-Canvas-to-Blob/js/canvas-to-blob.min.js"></script>
<!-- Bootstrap JS is not required, but included for the responsive demo navigation -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<%-- <script src="${pageContext.request.contextPath}/resources/upload-file/js/jquery.iframe-transport.js"></script> --%>
<!-- The basic File Upload plugin -->
<%-- <script src="${pageContext.request.contextPath}/resources/upload-file/js/jquery.fileupload.js"></script> --%>
<!-- <!-- The File Upload processing plugin --> -->
<%-- <script src="${pageContext.request.contextPath}/resources/upload-file/js/jquery.fileupload-process.js"></script> --%>
<!-- <!-- The File Upload image preview & resize plugin --> -->
<%-- <script src="${pageContext.request.contextPath}/resources/upload-file/js/jquery.fileupload-image.js"></script> --%>
<!-- <!-- The File Upload audio preview plugin --> -->
<%-- <script src="${pageContext.request.contextPath}/resources/upload-file/js/jquery.fileupload-audio.js"></script> --%>
<!-- <!-- The File Upload video preview plugin --> -->
<%-- <script src="${pageContext.request.contextPath}/resources/upload-file/js/jquery.fileupload-video.js"></script> --%>
<!-- <!-- The File Upload validation plugin --> -->
<%-- <script src="${pageContext.request.contextPath}/resources/upload-file/js/jquery.fileupload-validate.js"></script> --%>
<script type="text/javascript">
	$(document).ready(function(){
		$('li.submenu a').click(function(){
			$('ul#sottomenu').show();
			
		});
	});
</script>
</body>
</html>
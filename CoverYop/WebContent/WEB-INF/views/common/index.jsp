<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- ############################# Ajax Page Container ############################# -->
<section id="page" data-title="Noisa - Ultimate Music Theme Home ver 2">

	<!-- ############################# Sections ############################# -->

	<!-- ############################# Intro ############################# -->
	<section class="revoslider section border-bottom">

		<div class="fullwidthbanner">
			<ul>
				<!-- Slide 01 -->
				<li data-transition="fade" data-slotamount="0"
					data-masterspeed="300">
					<!-- Image --> <img
					src="${pageContext.request.contextPath}/resources/placeholders/revoslider/slide01-bg.jpg">
					<!-- Layers -->
					<div class="tp-caption lfl" data-x="-40" data-y="20"
						data-speed="2000" data-start="1200" data-easing="easeOutExpo">
						<img
							src="${pageContext.request.contextPath}/resources/placeholders/revoslider/slide01-dj-left.png" />
					</div>
					<div class="tp-caption lfr" data-x="700" data-y="30"
						data-speed="2000" data-start="1200" data-easing="easeOutExpo">
						<img
							src="${pageContext.request.contextPath}/resources/placeholders/revoslider/slide01-dj-right.png" />
					</div>
					<div class="tp-caption lfb" data-x="280" data-y="20"
						data-speed="2000" data-start="2200" data-easing="easeOutExpo">
						<img
							src="${pageContext.request.contextPath}/resources/placeholders/revoslider/slide01-dj-center.png" />
					</div>
					<div class="tp-caption lfb small-text caps" data-x="480"
						data-y="360" data-speed="800" data-start="3600"
						data-easing="easeOutExpo">il social di sereNA</div>
					<div class="tp-caption lfb very-large-text" data-x="480"
						data-y="400" data-speed="800" data-start="3000"
						data-easing="easeOutExpo">
						Yop<span class="color">!</span>
					</div>

				</li>
				<!-- Slide 02 -->
				<li data-transition="fade" data-slotamount="0"
					data-masterspeed="300">
					<!-- Image --> <img
					src="${pageContext.request.contextPath}/resources/placeholders/revoslider/slide02-bg.jpg">
					<!-- Layers -->
					<div class="tp-caption lfl" data-x="720" data-y="290"
						data-speed="1800" data-start="1200" data-easing="easeOutExpo">
						<img
							src="${pageContext.request.contextPath}/resources/placeholders/revoslider/slide02-vinyl.png" />
					</div>
					<div class="tp-caption lfl" data-x="540" data-y="335"
						data-speed="2000" data-start="1200" data-easing="easeOutExpo">
						<img
							src="${pageContext.request.contextPath}/resources/placeholders/revoslider/slide02-vinyl-cover.png" />
					</div>

					<div class="tp-caption lfb" data-x="-40" data-y="20"
						data-speed="2000" data-start="3200" data-easing="easeOutExpo">
						<img
							src="${pageContext.request.contextPath}/resources/placeholders/revoslider/slide01-dj-left.png" />
					</div>

					<div class="tp-caption lft large-text" data-x="520" data-y="140"
						data-speed="800" data-start="3000" data-easing="easeOutExpo">Gestisci
						un Locale?</div>
					<div class="tp-caption lft large-text" data-x="520" data-y="190"
						data-speed="800" data-start="3600" data-easing="easeOutExpo"
						style="font-size: 30px;">
						<span class="color">Qu&iacute; puoi trovare il miglior
							gruppo per il tuo evento</span>
					</div>
				</li>
			</ul>
		</div>
	</section>
	<!-- /intro -->

	<!-- ############################# Countdown ############################# 
	<section class="countdown section">
		<div class="container">
			<h5 class="countdown-title">Heineken Music Hall, Warsaw, PL</h5>
			<!-- countdown 
			<div class="countdown-wrap" data-event-date="2014/12/18 20:20:00">
				<div class="days" data-label="Days">000</div>
				<div class="hours" data-label="Hours">00</div>
				<div class="minutes" data-label="Minutes">00</div>
				<div class="seconds" data-label="Seconds">00</div>
			</div>
			/countdown 
		</div>
	</section>
	 /countdown -->

	<!-- ############################# Featured Releases ############################# -->
	<section id="featured-section"
		class="featured-releases section border-top border-bottom"
		style="background-image: url(${pageContext.request.contextPath}/resources/placeholders/featured-releases-bg.jpg)">
		<div class="container">
			<header class="section-header">
				<h2 class="section-title">Ultime Tracce</h2>
				<h5 class="section-sub-title">Non Puoi non Ascoltarle!</h5>
			</header>

			<!-- Releases -->
			<div id="featured-releases"
				class="owl-carousel carousel featured-releases-list">
				<c:forEach items="${song}" var="song" varStatus="status">
					<!-- Release -->
					<div class="col-1-4 carousel-item featured-release">
						<!-- Thumbnail -->
						<a class="thumb-glitch release tip sp-play-track"
							href="${pageContext.request.contextPath}/resources/${song.url}"
							data-thumbicon="plus"> 
							<span class="hoverlayer"></span> 
							<span class="release-badge">${song.titolo}</span>
							<span class="img"> 
							<img src="${pageContext.request.contextPath}/Group/image.html?id=${song.getAlbum().getGruppo().getId()}" alt="Release Image" />
						</span> <!-- tooltip -->
							<div class="tip-content hidden">
								<span>Ascolta l'ultima tracci di <strong style="color:#ea4233;">${song.getAlbum().getGruppo().getNomeGruppo()}</strong> dal titolo </span> 
								<strong style="color:#ea4233;">${song.titolo}</strong> 
								<span>ed entra nel loro profilo per saperne  di più </span>
							</div> <!-- /tooltip -->
						</a>
						<!-- /Thumbnail -->
						<!-- Release footer -->
						<div class="release-footer">
							<h2 class="release-title">
								<a class="track sp-play-track"
									href="${pageContext.request.contextPath}/resources/${song.url}">Album: ${song.getAlbum().nome}</a>
							</h2>
							<span class="release-artists">
								Gruppo: ${song.getAlbum().getGruppo().getNomeGruppo()}</span>
						</div>
						<!-- /release footer -->
						<!-- Release social 
						<div class="release-social">
							<a href="${pageContext.request.contextPath}/javascript:;"
								class="facebook-share"><i class="icon icon-facebook"></i></a> <a
								href="${pageContext.request.contextPath}/javascript:;"
								class="twitter-share"><i class="icon icon-twitter"></i></a> <a
								href="${pageContext.request.contextPath}/javascript:;"
								class="googleplus-share"><i class="icon icon-googleplus"></i></a>
							<a href="${pageContext.request.contextPath}/javascript:;"
								class="googleplus-share floatright"><i
								class="icon icon-download"></i></a>
						</div>
						<!-- /release social -->
					</div>
					<!-- /release -->
				</c:forEach>


			</div>
			<!-- /releases -->

		</div>
		<!-- /container -->
	</section>
	<!-- /featured releases -->
	<!-- Qui parte la visualizzazione degli artisti -->
	<!-- ############################# Ajax Page Container ############################# -->
	<section id="featured-section"
		class="featured-releases section border-top border-bottom"
		data-title="Ultimi - Artisti">
		<!-- ############################# Content ############################# -->
		<section class="content section">
			<!-- container -->
			<div class="container">
				<header class="section-header">
					<h2 class="section-title">Ultimi Artisti</h2>
					<h5 class="section-sub-title">Anche Band e Cover Band
						Naturalmente!!</h5>
				</header>
				<!-- Filters -->
				<div class="row clearfix filters" data-id="artists">

					<!-- Genres -->
					<select class='nice-select filter' name="genres">
						<option value="placeholder">All Genres</option>
						<option value="*">All Genres</option>
						<c:forEach items="${generiGruppi}" var="generi" varStatus="status">
							<option value="${generi.getGenere()}">${generi.getGenere()}</option>
						</c:forEach>

					</select>

				</div>
				<!-- /filters -->
				<!-- Artists Grid -->

				<!-- Artists -->
				<div id="artists" class="masonry clearfix">


					<c:forEach items="${gruppi}" var="gruppi" varStatus="status">
						<!-- Artist -->
						<div class="col-1-4 item"
							data-genres=<c:forEach  items="${gruppi.getGeneri()}" var="generi">
															"${generi.genere}"
															</c:forEach>>
							<!-- Thumbnail -->
							<a href="${pageContext.request.contextPath}/Group/${gruppi.id}"
								class="thumb-glitch artist" data-thumbicon="plus"> <span
								class="hoverlayer"></span> <span class="img"> <img
									src="${pageContext.request.contextPath}/Group/image.html?id=${gruppi.id}"
									alt="Artist Image" />
							</span>
							</a>
							<!-- /Thumbnail -->
							<!-- Artist footer -->
							<div class="artist-footer">
								<h2 class="artist-title">
									<a href="${pageContext.request.contextPath}/Group/${gruppi.id}">${gruppi.nomeGruppo}</a>
								</h2>
								<span class="artist-genres"> </span>
							</div>
							<!-- /artist footer -->
							<!-- Artist social -->
							<div class="artist-social">
								<a href="${gruppi.canale.facebook}"	class="facebook-share"><i class="icon icon-facebook"></i></a>
							<a href="${gruppi.canale.twitter}" class="twitter-share"><i class="icon icon-twitter"></i></a>
							<a href="${gruppi.canale.googlePlus}" class="googleplus-share"><i class="icon icon-googleplus"></i></a>
							<a href="${gruppi.canale.youtube}" class="googleplus-share floatright"><i class="icon icon-download"></i></a>
						</div>
							<!-- /artist social -->
						</div>
						<!-- /artist -->
					</c:forEach>

					<!-- row -->




				</div>
				<!-- /artists -->


			</div><br/>
			<!-- /container -->
			<div class="text-center">
				<a href="${pageContext.request.contextPath}/Groups" class="by-ajax btn">Scopri Altri Gruppi!</a>
			</div>
		</section>
		<!-- /Content -->

	</section>
	<!-- /page -->
	<!--  FINE NUOVI ARTISTI -->
	<section id="featured-section"
		class="featured-releases section border-top border-bottom"
		style="background-image: url(${pageContext.request.contextPath}/resources/placeholders/featured-releases-bg.jpg)">
		<div class="container">
			<header class="section-header">
				<h2 class="section-title">Ultimi Locali</h2>
				<h5 class="section-sub-title">Dove Fare Serata</h5>
			</header>

			<!-- Releases -->
			<div id="featured-releases"
				class="owl-carousel carousel featured-releases-list">

				<c:forEach items="${locali}" var="locali" varStatus="status">

					<!-- Release -->
					<div class="col-1-4 carousel-item featured-release">
						<!-- Thumbnail -->
						<a href="${pageContext.request.contextPath}/Local/${locali.id}" class="thumb-glitch release tip"
							data-thumbicon="plus"> <span class="hoverlayer"></span> <span
							class="release-badge">${locali.getCategoria().nomeCat} </span> <span
							class="img"> <img
								src="${pageContext.request.contextPath}/Local/image.html?id=${locali.id}"
								alt="Release Image" />
						</span> <!-- tooltip -->
							<div class="tip-content hidden">
								<span>
								Orario A: ${locali.orarioApertura} </br>
								Orario C:${locali.orarioChiusura}
								</span>
								Noi: ${locali.descrizione.substring(0,20).concat("...")}
							</div> <!-- /tooltip -->
						</a>
						<!-- /Thumbnail -->
						<!-- Release footer -->
						<div class="release-footer">
							<h2 class="release-title">
								<a href="${pageContext.request.contextPath}/Local/${locali.id}">${locali.nomeLocale}</a>
							</h2>
							<span class="release-artists">${locali.indirizzo}</span>
						</div>
						<!-- /release footer -->
						<!-- Release social -->
						<div class="release-social">
							<a href="${locali.canale.facebook}"	class="facebook-share"><i class="icon icon-facebook"></i></a>
							<a href="${locali.canale.twitter}" class="twitter-share"><i class="icon icon-twitter"></i></a>
							<a href="${locali.canale.googlePlus}" class="googleplus-share"><i class="icon icon-googleplus"></i></a>
							<a href="${locali.canale.youtube}" class="googleplus-share floatright"><i class="icon icon-download"></i></a>
						</div>
						<!-- /release social -->
					</div>
					<!-- /release -->
				</c:forEach>



			</div>
			<!-- /releases -->

		</div>
		<br/>
		<!-- /container -->
		<div class="text-center">
			<a href="${pageContext.request.contextPath}/Groups" class="by-ajax btn">Scopri Altri Locali</a>
		</div>
	</section>
	<!-- ############################# Homepage about ############################# -->
<!-- 	<section class="homepage-about section border-top" -->
<%-- 		style="background-image: url(${pageContext.request.contextPath}/resources/placeholders/homepage-footer-bg.jpg)"> --%>
<!-- 		<!-- container -->
<!-- 		<div class="container"> -->

<!-- 			<div class="col-1-2"> -->
<!-- 				<h1 class="heading-xl">Yop!</h1> -->
<!-- 				<p class="intro-text caps">Il Social CoverBand</p> -->
<!-- 				<p class="intro-text">Join The Community</p> -->
<!-- 				<a class="stamp-button" -->
<%-- 					href="${pageContext.request.contextPath}/ContactUs">More!</a> --%>

<!-- 			</div> -->

<!-- 		</div> -->
<!-- 		<!-- /container -->
<!-- 	</section> -->
	<!-- /section -->

	<!-- ############################# Newsletter ############################# -->
	<!-- 	<section id="newsletter"> -->
	<!-- 		<!-- container -->
	<!-- 		<div class="container"> -->
	<!-- 			<div class="newsletter-left"> -->
	<!-- 				<span class="newsletter-icon"></span> <span class="newsletter-title">Newsletter</span> -->
	<!-- 			</div> -->
	<!-- 			<div class="newsletter-right"> -->
	<!-- 				subscribe form -->
	<!-- 				<form action="#post" method="post" id="subscribe-form"> -->
	<!-- 					<input type="email" name="subscribe_email" value="" -->
	<!-- 						id="subscribe-email" placeholder="Enter your email..." required> -->
	<!-- 					<input type="submit" value="+" class="large" id="subscribe-submit"> -->
	<!-- 				</form> -->
	<!-- 				/subscribe form -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 		<!-- /container -->
	<!-- 	</section> -->
	<!-- /newsletter -->

</section>
<!-- /page -->
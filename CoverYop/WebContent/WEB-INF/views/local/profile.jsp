<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!-- ############################# Ajax Page Container ############################# -->
<section id="page" data-title="Locale - ${locale.nomeLocale}">

	<!-- ############################# Intro ############################# -->
	<%-- <section  class="intro-title section border-bottom" style="background-image: url(${pageContext.request.contextPath}/${back.url}); background-size: auto auto; "> --%>
	<section class="intro-title section border-bottom"
		style="background-image: url(${pageContext.request.contextPath}/Local/image.html?id=${locale.id}); background-size: cover; ">
		<%-- <img src="${pageContext.request.contextPath}/Local/image.html?id=${locali.id}"  alt="Artist Image"> --%>
		<h2 class="heading-l event-heading"
			style="color: red; text-shadow: 3px 2px white; z-index: 2;">${locale.nomeLocale}</h2>
		<!-- Overlay -->
		<!-- <span class="overlay dots"></span> -->
	</section>
	<!-- /intro -->

	<!-- ############################# Content ############################# -->
	<section class="content section">
		<!-- container -->
		<div class="container">

			<!-- ############################# Single Release ############################# -->
			<!-- Sidebar -->
			<div class="sidebar main-left main-medium">
				<!-- Widgets -->
				<!-- Details widget -->
				<div class="widget details-widget">


					<div class="tabs-wrap">
						<!-- tabs navigation -->
						<ul class="tabs">
							<li><a href="#details-meta" class="active-tab">Info</a></li>
							<security:authorize access="isAuthenticated()">
								<li><a href="#tab-contatta">Contatta</a></li>
							</security:authorize>
						</ul>



						<div class="details-meta tab-content" id="details-meta">
							<!-- Details list -->
							<ul class="details-list">
								<li><span class="label">Nome Locale</span>
									<div class="data">
										<b>${locale.nomeLocale}</b>
									</div></li>
								<li><span class="label">Generi</span>
									<div class="data">${locale.categoria.nomeCat}</div></li>
								<li><span class="label">Address</span>
									<div class="data">${locale.indirizzo}</div></li>
								<!-- start here -->
						</div>
						<security:authorize access="isAuthenticated()">
							<div class="details-meta tab-content" id="tab-contatta">
								<form method="post" id="formContatta" class="form response-form"
									action="${pageContext.request.contextPath}/messages/addconversation/">
									<input type="hidden" name="id" value="${locale.id}" />



									<div class="row clearfix">
										<div class="col-1-1">
											<label for="response-comment"><strong>Titolo</strong></label>
											<input name="titolo" id="titolo"></input>
										</div>
										<div class="col-1-1">
											<label for="response-comment"><strong>Messaggio</strong></label>
											<textarea name="corpo" id="corpo"></textarea>
										</div>
									</div>
									<div class="clear"></div>
									<input type="submit" class="action-button" value="Submit" />
								</form>


							</div>
						</security:authorize>
					</div>
					<!-- Details Share -->
					<div class="details-social-box">
						<a href="${canali.facebook}" class="facebook-share"><i
							class="icon icon-facebook"></i></a> <a href="${canali.twitter}"
							class="twitter-share"><i class="icon icon-twitter"></i></a> <a
							href="${canali.googlePlus}" class="googleplus-share"><i
							class="icon icon-googleplus"></i></a> <a href="${canali.soundCloud}"
							class="soundcloud-share"><i class="icon icon-soundcloud"></i></a>
						<a href="${canali.youtube}" class="youtube-share"><i
							class="icon icon-youtube"></i></a>
					</div>
					<div class="details-meta">
						<h3>Service</h3>

						<ul class="details-list">
							<li><span class="label">Mixer</span>
								<div class="data">
									<b> <c:choose>
											<c:when test="${locale.service.mixer > 0}">Disponibile</c:when>
											<c:otherwise> Non Disponibile</c:otherwise>

										</c:choose>
									</b>
								</div></li>
							<li><span class="label">Amplificatore</span>
								<div class="data">
									<b> <c:choose>
											<c:when test="${locale.service.amplificatore}">Disponibile</c:when>
											<c:otherwise>Non Disponibile</c:otherwise>
										</c:choose>
									</b>
								</div></li>
							<li><span class="label">Casse</span>
								<div class="data">
									<b> <c:choose>
											<c:when test="${locale.service.casse > 0}"> Disponibili</c:when>
											<c:otherwise>Non Disponibili</c:otherwise>
										</c:choose>
									</b>
								</div></li>
							<li><span class="label">Luci</span>
								<div class="data">
									<b> <c:choose>
											<c:when test="${locale.service.luci}"> Disponibili</c:when>
											<c:otherwise>Non Disponibili</c:otherwise>
										</c:choose>
									</b>
								</div></li>
							<li><span class="label">Microfono</span>
								<div class="data">
									<b> <c:choose>
											<c:when test="${locale.service.microfono}">Disponibile</c:when>
											<c:otherwise>Non Disponibile</c:otherwise>
										</c:choose>
									</b>
								</div></li>

						</ul>
					</div>
					<div class="details-social-box"></div>
					<div class="details-meta">
						<h3>VideoGallery</h3>

						<!-- Carousel slider -->
						<div id="blog-slider02" class="carousel-slider"
							data-effect="fadeUp" data-pagination="true" data-nav="true">
							<!-- Slide -->
							<c:forEach items="${video}" var="video">
								<%-- <h4>${video.titolo}</h4> --%>
								<div class="slide">${video.url}</div>
							</c:forEach>

							<!-- /slide -->

						</div>
						<!-- /Carousel slider -->

					</div>

					<!-- stop here -->
					</ul>


				</div>



			</div>
			<!-- /sidebar -->

			<!-- Main -->
			<div id="main" class="release main-left main-medium">

				<!-- Article -->
				<article>
					<!-- Carousel slider -->
					<div id="blog-slider01" class="carousel-slider"
						data-effect="fadeUp" data-pagination="true" data-nav="true">
						
						<!-- Slide  con blob-->
						<c:forEach items="${slideshow}" var="slideshow">
							<div class="slide">

								<img src="${pageContext.request.contextPath}/LocalSlide/image.html?id=${slideshow.id}" alt="Event Image">
							</div>
						</c:forEach>

						<!-- /slide con blob-->

					</div>
					<!-- /Carousel slider -->
					<br>
					<h2>Bio</h2>
					<p>${locale.descrizione}</p>

					<br>
					<h2>Prossimi Eventi</h2>
					<ul class="lineup">
						<c:forEach items="${eventi}" var="eventi">
							<li>
								<div class="lineup-time">${eventi.data}</div>
								<div class="lineup-artist">
									<a href="${pageContext.request.contextPath}/Event/${eventi.id}">${eventi.nome}</a>
									<c:forEach items="${eventi.gruppo}" var="gruppo">
										<a class="gruppo"
											href="${pageContext.request.contextPath}/Group/${gruppo.id}/">&nbsp;/&nbsp;${gruppo.nomeGruppo}</a>
									</c:forEach>
								</div>
							</li>
						</c:forEach>


					</ul>

					<br>

					<h2>Dove</h2>
					<div id="location-map" class="gmap map"
						data-address="${locale.indirizzo},${locale.citta} " data-zoom="18"
						data-zoom_control="true" data-scrollwheel="true"></div>
				</article>
				<!-- /article -->


			</div>
			<!-- /main -->
		</div>
		<!-- /container -->
	</section>
	<!-- /Content -->



</section>
<!-- /page -->
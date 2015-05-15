<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- ############################# Ajax Page Container ############################# -->
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
						data-easing="easeOutExpo">Il social di Cover Band</div>
					<div class="tp-caption lfb very-large-text" data-x="480"
						data-y="400" data-speed="800" data-start="3000"
						data-easing="easeOutExpo">
						Yop<span class="color">!</span>
					</div>

				</li>
				<!-- Slide 02 -->
				<li data-transition="fade" data-slotamount="0"d
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
	
	
	
<!-- 	<section class="countdown section"> -->
<!-- 		<div class="container"> -->


<!-- <h4 class="response-title">Cerchi Il Tuo Gruppo Preferito?</h4> -->
<!-- <h5>Let Us Help You</h5> -->
<!-- 			<!-- response form -->
<%-- 	        <form  method="get" action="${pageContext.request.contextPath}/Groups" class="form response-form"> --%>
<!-- 	        	<div class="row clearfix"> -->
<!-- 	 				<div class="col-1-3"> -->
<!-- 	 					<label for="response-name"><strong>Per Nome</strong></label> -->
<!-- 						<input type="text" name="nome" value="" id="response-name" > -->
<!-- 	 				</div> -->
<!-- 	 				<div class="col-1-3"> -->
<!-- 	 					<label for="response-email"><strong>Per Genere</strong></label> -->
<!-- 						<input type="text" name="genere" value="" id="response-email" > -->
<!-- 	 				</div> -->
<!-- 	 				<div class="col-1-3 last"> -->
<!-- 	 					<label for="response-www"><strong>Per Città</strong></label> -->
<!-- 						<input type="text" name="citta" value="" id="response-www"> -->
<!-- 	 				</div> -->
<!-- 	        	</div> -->
<!-- 				<input type="submit" value="Submit Comment" class="large invert"> -->
<!-- 				<div class="clear"></div> -->
<!-- 	        </form> -->
<!-- 			<!-- /countdown --> 
<!-- 		</div> -->
<!-- 	</section> -->
	
	
	
	
<section id="featured-section" class="featured-releases section border-top border-bottom" data-title="Ultimi - Artisti">
	<!-- ############################# Content ############################# -->
	<section class="content section">
		<!-- container -->
		<div class="container">

			<!-- Filters -->
			<div class="row clearfix filters" data-id="artists">

			
<!-- 				Genres -->
<!-- 				<select class='nice-select filter' name="genres"> -->
<!-- 					<option value="placeholder">All Genres</option> -->
<!-- 					<option value="*">All Genres</option> -->
<%-- 					<c:forEach items="${generi}" var="generi"> --%>
<%-- 						<option value="${generi.genere}">${generi.genere}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
			
				

			</div>
			<!-- /filters -->
			<!-- Artists Grid -->

			<!-- Artists -->
			<div id="artists" class="masonry clearfix">
				<div class="col-1-1">
				<h1>Gruppi</h1> </br>
				<c:if test="${empty gruppi}">
				<h3>Non ci sono Gruppi che contengano quel nome</h3>
				</c:if>	   
				</div>
				<div class="col-1-1">
					<c:forEach  items="${gruppi}" var="gruppi" varStatus="status">
					<!-- Artist -->
					<div class="col-1-4 item" data-genres=<c:forEach  items="${gruppi.getGeneri()}" var="generi">
															"${generi.genere}"
															</c:forEach>
															>
						<!-- Thumbnail -->
						<a href="${pageContext.request.contextPath}/Group/${gruppi.id}" class="thumb-glitch artist" data-thumbicon="plus">
							<span class="hoverlayer"></span>
							<span class="img">
								<img src="${pageContext.request.contextPath}/Group/image.html?id=${gruppi.id}" alt="Artist Image" />
							</span>
						</a>
						<!-- /Thumbnail -->
						<!-- Artist footer -->
						<div class="artist-footer">
							<h2 class="artist-title"><a href="${pageContext.request.contextPath}/Group/${gruppi.id}">${gruppi.nomeGruppo} </a></h2>
							<span class="artist-genres"></span>
						</div>
						<!-- /artist footer -->
						<!-- Artist social -->
						<div class="artist-social">
							<a href="${gruppi.canale.facebook}" class="facebook-share"><i class="icon icon-facebook"></i></a>
							<a href="${gruppi.canale.twitter}" class="twitter-share"><i class="icon icon-twitter"></i></a>
							<a href="${gruppi.canale.googlePlus}" class="googleplus-share"><i class="icon icon-googleplus"></i></a>
						</div>
						<!-- /artist social -->
					</div>
					<!-- /artist -->
				</c:forEach>
				</div>
				


			</div>
			<!-- /artists -->
		 <!-- Artists -->
			<div id="artists" class="masonry clearfix">
			<div class="col-1-1">
			<h1>Locali</h1></br>
				<c:if test="${empty locali}">
				<h3>Non ci sono Locali che contengano quel nome</h3>
				</c:if>	 
			</div>
			<div class="col-1-1">
				<c:forEach  items="${locali}" var="locali" varStatus="status">
					<!-- Artist -->
					<div class="col-1-4 item" data-genres="${locali.categoria.nomeCat}">
						<!-- Thumbnail -->
						<a href="${pageContext.request.contextPath}/Local/${locali.id}" class="thumb-glitch artist" data-thumbicon="plus">
							<span class="hoverlayer"></span>
							<span class="img">
								<img src="${pageContext.request.contextPath}/Local/image.html?id=${gruppi.id}" alt="Artist Image" />
							</span>
						</a>
						<!-- /Thumbnail -->
						<!-- Artist footer -->
						<div class="artist-footer">
							<h2 class="artist-title"><a href="${pageContext.request.contextPath}/Local/${locali.id}">${locali.nomeLocale}</a></h2>
							<span class="artist-genres">Pub / Sagra</span>
						</div>
						<!-- /artist footer -->
						<!-- Artist social -->
						<div class="artist-social">
							<a href="${locali.canale.facebook}" class="facebook-share"><i class="icon icon-facebook"></i></a>
							<a href="${locali.canale.twitter}" class="twitter-share"><i class="icon icon-twitter"></i></a>
							<a href="${locali.canale.googlePlus}" class="googleplus-share"><i class="icon icon-googleplus"></i></a>
						</div>
						<!-- /artist social -->
					</div>
					<!-- /artist -->
				</c:forEach>
			</div>
			</div>
			<!-- /artists -->
		 <!-- Events -->
			<div id="events" class="masonry events-grid clearfix">
			<div class="col-1-1">
			<h1>Eventi</h1></br>
				<c:if test="${empty eventi}">
				<h3>Non ci sono Eventi che contengano quel nome</h3>
				</c:if>	 
			</div>
			<div class="col-1-1">
				<c:forEach  items="${eventi}" var="evento" varStatus="status">
										
									
					<div class="col-1-4 item event" data-genres="${evento.tipologia_Eventi.nome}"
													<%-- data-artists="<c:forEach  items="${evento.getGruppo()}" var="gruppi">${gruppi.nomeGruppo} </c:forEach>"
													data-locations="${evento.luogo}" --%>								
													>
														
						<a href="${pageContext.request.contextPath}/Events/${evento.id}">
							<span class="event-meta">
								<span class="event-location"><span class="color">@ ${evento.locale.nomeLocale}</span> / ${evento.luogo}</span>
								<span class="event-date">${evento.data}</span>
								<span class="event-title">${evento.nome}</span>
								<c:forEach  items="${evento.gruppo}" var="gruppi" varStatus="status">
									<span class="event-artists">${gruppi.nomeGruppo}</span>
								</c:forEach>
							</span>
							<img src="${pageContext.request.contextPath}/resources/img/events/${evento.id}/${evento.locandina}"  alt="Event Background">
						</a>
					</div>
				
					<c:if test="${!status.last}"></c:if>
				</c:forEach>
			</div>


			</div>
			<!-- /Events -->

		</div>
		<!-- /container -->
	</section>
	<!-- /Content -->

</section>
<!-- /page -->
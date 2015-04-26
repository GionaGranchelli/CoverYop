<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:declaration></jsp:declaration><%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!-- ############################# Ajax Page Container ############################# -->
<section id="page" data-title="Single Artist Page">

	<!-- ############################# Intro ############################# -->
	<section class="intro-title section border-bottom" style="background-image: url(${pageContext.request.contextPath}/resources/placeholders/blog-grid-bg.jpg)">
		
		<h2 class="heading-l">${titolo_page_1} <span class="color">${titolo_page_2}</span></h2>
		<br>
		<!-- Overlay -->
		<span class="overlay grids"></span>
	</section>
	<!-- /intro -->

	<!-- ############################# Content ############################# -->
	<section class="content section">
		<!-- container -->
		<div class="container">

			<!-- ############################# Single Artist ############################# -->
			<!-- Sidebar -->
			<div class="sidebar main-left main-medium">
				<!-- Widgets -->
				<!-- Details widget -->
				<div class="widget details-widget">
					<!-- Thumbnail -->
					<a href="${pageContext.request.contextPath}/${foto_profilo.url}" class="thumb-glitch imagebox details-widget-img" data-thumbicon="view" title="${gruppo.nomeGruppo}">
						<span class="hoverlayer"></span>
						<span class="img">
							<%-- <img src="${pageContext.request.contextPath}/${foto_profilo.url}" alt="${gruppo.nomeGruppo}" /> --%>
							<img src="${pageContext.request.contextPath}/Group/image.html?id=${gruppo.id}"  alt="Artist Image">
						</span>
					</a>
					<!-- /Thumbnail -->
					
					
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
							<li>
								<span class="label">Nome Gruppo</span>
								<div class="data"><b>${gruppo.nomeGruppo}</b></div>
							</li>
							<li>
								<span class="label">Generi</span>
								<div class="data">
								<c:forEach  items="${generi}" var="generi" varStatus="status">
								${generi.genere} <c:if test="${!status.last}">/</c:if>
								</c:forEach>
								
								</div>
							</li>
							<li>
								<span class="label">Luogo</span>
								<div class="data">${gruppo.citta}</div>
							</li>
							<li>
								<span class="label">Nascita</span>
								<div class="data">${gruppo.data}</div>
							</li>
							<li>
								<span class="label">Gruppi di Riferimento</span>
								<div class="data">
								<c:forEach  items="${gruppidiriferimento}" var="grf" varStatus="status">
								${grf.nome} <c:if test="${!status.last}">/</c:if>
								</c:forEach>
								
								</div>
							</li>
						</ul>
						
						
						
					</div>
					
			<!-- -tab contatta -->	
			<security:authorize access="isAuthenticated()">		
				<div class="details-meta tab-content" id="tab-contatta">	
					<form method="post"
					   id="formContatta"
	        		   class="form response-form" 
	        		   action="${pageContext.request.contextPath}/messages/addconversation/">
	        	<input type="hidden" name="id" value="${gruppo.id}"/>
	        	
	        	
	        	
	        	<div class="row clearfix">
	        	<div class="col-1-1">
	        			<label for="response-comment"><strong>Titolo</strong></label>
						<input   name="titolo"  id="titolo"></input>
					</div>
	        		<div class="col-1-1">
	        			<label for="response-comment"><strong>Messaggio</strong></label>
						<textarea name="corpo" id="corpo"></textarea>
					</div>
	        	</div>
			<div class="clear"></div>
			<input type="submit"  class="action-button" value="Invia" />
	        </form>
					
					</div>
				<!-- fine tab contatta -->	
					</security:authorize>
					</div>
					
					<!-- Details Share -->
					<div class="details-social-box">
						<a href="${canali.facebook}" class="facebook-share"><i class="icon icon-facebook"></i></a>
						<a href="${canali.twitter}" class="twitter-share"><i class="icon icon-twitter"></i></a>
						<a href="${canali.googlePlus}" class="googleplus-share"><i class="icon icon-googleplus"></i></a>
						<a href="${canali.soundCloud}" class="soundcloud-share"><i class="icon icon-soundcloud"></i></a>
						<a href="${canali.youtube}" class="youtube-share"><i class="icon icon-youtube"></i></a>
					</div>
					<div class="details-meta">
						<h3>Service</h3>
						
						<ul class="details-list">
							<li>
								<span class="label">Mixer</span>
								<div class="data">
								<b>
								<c:choose>
								<c:when  test="${gruppo.service.mixer > 0}"> Canali : ${gruppo.service.mixer}</c:when>
								<c:otherwise> Non Disponibile</c:otherwise>
								
								</c:choose>
								</b>
								</div>
							</li>
							<li>
								<span class="label">Amplificatore</span>
								<div class="data">
								<b>
								<c:choose>
									<c:when test="${gruppo.service.amplificatore}">Disponibile</c:when>
									<c:otherwise>Non Disponibile</c:otherwise>
								</c:choose>
								</b>
								</div>
							</li>
							<li>
								<span class="label">Casse</span>
								<div class="data">
								<b>
								<c:choose>
									<c:when test="${gruppo.service.casse > 0}"> Disponibili - ${gruppo.service.casse} Watt</c:when>
									<c:otherwise>Non Disponibili</c:otherwise>
								</c:choose>
								</b>
								</div>
							</li>
							<li>
								<span class="label">Luci</span>
								<div class="data">
								<b>
								<c:choose>
									<c:when test="${gruppo.service.luci}"> Disponibili</c:when>
									<c:otherwise>Non Disponibili</c:otherwise>
								</c:choose>
								</b>
								</div>
							</li>
							<li>
								<span class="label">Microfono</span>
								<div class="data">
								<b>
								<c:choose>
									<c:when test="${gruppo.service.microfono}">Disponibile</c:when>
									<c:otherwise>Non Disponibile</c:otherwise>
								</c:choose>
								</b>
								</div>
							</li>
							
						</ul>
					</div>
					<div class="details-social-box">
					<h3>Cachet</h3>
					<ul  class="details-list">
						<li>
								<span class="label">Costo Indicativo</span>
								<div class="data">
								<b>
								<c:choose>
									<c:when test="${gruppo.cachet.prezzo > 0}">${gruppo.cachet.prezzo} &#128;</c:when>
									<c:otherwise>Non Disponibile</c:otherwise>
								</c:choose>
								</b>
								</div>
						</li>
						<li>
								<span class="label">Consumazioni</span>
								<div class="data">
								<b>
								<c:choose>
									<c:when test="${gruppo.cachet.consumazioni}">Richiesta</c:when>
									<c:otherwise>Non Richiesta</c:otherwise>
								</c:choose>
								</b>
								</div>
						</li>
						<li>
								<span class="label">Rimborso Spese</span>
								<div class="data">
								<b>
								<c:choose>
									<c:when test="${gruppo.cachet.rimborsoSpese}">Richiesto</c:when>
									<c:otherwise>Non Richiesto</c:otherwise>
								</c:choose>
								</b>
								</div>
						</li>
					</ul>
							
					</div>
				</div>

				<!-- Text Widget -->
				<!-- <div class="widget text-widget">
					Buttons list
					<ul class="buttons-list">
						<li>
							<a class="btn small invert" href="javascript:;" ><i class="icon icon-download"></i> Download Recent Podcast</a>
						</li>
						<li>
							<a class="btn small dark" href="javascript:;" ><i class="icon icon-download"></i> Download My Bio</a>
						</li>

					</ul>
				</div> -->
			
			</div>
			<!-- /sidebar -->

			<!-- Main -->
			<div id="main" class="release main-left main-medium">

				<!-- Article -->
				<article>

					 <!-- tabs -->
                    <div class="tabs-wrap">
                        <!-- tabs navigation -->
                        <ul class="tabs">
                            <li><a href="#tab-bio" class="active-tab">Bio</a></li>
                            <li><a href="#tab-releases">Discografia</a></li>
                            <li><a href="#tab-podcasts">Video e SoundCloud</a></li>
                            <li><a href="#tab-gallery">Galleria</a></li>
                            <li><a href="#tab-events">Eventi</a></li>
                        </ul>
                        <!-- /tabs navigation -->
                        <!-- tab content -->
                        <div id="tab-bio" class="tab-content">
                        	<h2>Biografia</h2>
                        	<security:authorize access="!isAuthenticated()">
                        	<p class="intro-text caps">${gruppo.nomeGruppo} </p>
                        	</security:authorize>
                        	<security:authorize access="isAuthenticated()">
                        	<p class="intro-text caps">${gruppo.nomeGruppo}</p>
                        	</security:authorize>

                            <p class="biografia" id="bio">
								${gruppo.biografia}
								</p>
							
							<br>
							<h3>My Videos</h3>
							${video.url}
							<!-- <iframe width="560" height="315" src="//" frameborder="0" allowfullscreen></iframe> -->
							<!-- <p>
								Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget tellus vitae lacus vestibulum sagittis. Nullam sed risus blandit, pretium magna id, varius lectus. Praesent a condimentum est. Pellentesque rutrum consectetur metus. Curabitur scelerisque, tortor quis ullamcorper semper, lacus metus placerat tellus, et aliquam libero tortor et lectus. Maecenas rhoncus, sem a pellentesque convallis, dolor nulla semper dolor, vestibulum luctus sapien lectus in quam. Nunc accumsan consequat est a porttitor. Proin vitae dolor mauris. Aliquam erat volutpat. Quisque quis tincidunt mi.
							</p> -->
							<div id="location-map" class="gmap map" data-address="${gruppo.citta}" data-zoom="18" data-zoom_control="true" data-scrollwheel="true"></div>
                        </div>
                        <!-- /tab content -->
                        <!-- tab content -->
                        <div id="tab-releases" class="tab-content">
                        	<h2>Scaletta</h2>
                            <p> Qui puoi ascoltare la nostra scaletta preferita</p>
							
                            		<ol id="release-list" class="tracklist">
                            		<p style="text-align: center; margin: 0px; padding: 0px; border-bottom: 1px solid rgb(68, 68, 68);"> Scaletta</p>
			                            <c:forEach items="${scaletta}" var="songs" varStatus="status">
			                            <li>
												<div class="track-details">
													
													<a class="track sp-play-track" href="${pageContext.request.contextPath}/resources/${songs.url}" data-cover="${pageContext.request.contextPath}/resources/placeholders/release-image02.jpg">
														<!-- cover -->
														<img class="track-cover" src="${pageContext.request.contextPath}/resources/img/cover.png" alt="Traccia Durata">
														<!-- Title -->
														<span class="track-title">${songs.titolo}</span>
														<!-- Artists -->
														<span class="track-artists">${songs.durata}</span>
													</a>
			
													<div class="track-buttons">
														<a href="javascript:;" class="googleplus-share"><i class="icon icon-soundcloud"></i></a>
														<!-- <a href="javascript:;" class="googleplus-share"><i class="icon icon-download"></i></a> -->
													</div>
												</div>
			
											</li>
										</c:forEach>
									</ol>
							
                        
                        
                        	<h2>Discografia</h2>
                            <p> All'intero di quest'area potete ascoltare la nostra musica</p>
							<c:forEach items="${album}" var="album" varStatus="status">
                            		<ol id="release-list" class="tracklist">
                            		<p style="text-align: center; margin: 0px; padding: 0px; border-bottom: 1px solid rgb(68, 68, 68);"> ${album.nome}</p>
			                            <c:forEach items="${album.canzoni}" var="songs" varStatus="status">
			                            <li>
												<div class="track-details">
													
													<a class="track sp-play-track" href="${pageContext.request.contextPath}/resources/${songs.url}" data-cover="${pageContext.request.contextPath}/resources/placeholders/release-image02.jpg">
														<!-- cover -->
														<img class="track-cover" src="${pageContext.request.contextPath}/resources/img/cover.png" alt="Traccia Durata">
														<!-- Title -->
														<span class="track-title">${songs.titolo}</span>
														<!-- Artists -->
														<span class="track-artists">${songs.durata}</span>
													</a>
			
													<div class="track-buttons">
														<a href="javascript:;" class="googleplus-share"><i class="icon icon-soundcloud"></i></a>
														<!-- <a href="javascript:;" class="googleplus-share"><i class="icon icon-download"></i></a> -->
													</div>
												</div>
			
											</li>
										</c:forEach>
									</ol>
							</c:forEach>
							<p>
								<a href="javascript:;" class="btn invert sp-play-list" data-id="release-list">Play All Tracks</a>
								<a href="javascript:;" class="btn sp-add-list" data-id="release-list">Add All Tracks</a>
							</p>

                            <!-- <p>Suspendisse quis aliquam justo. Maecenas tristique imperdiet magna eu fermentum. Donec non enim purus, vel lobortis lacus. Nulla facilisi. Donec consectetur, turpis ac consequat mollis, odio leo pellentesque ipsum, sed mattis mauris elit ut elit. Ut dictum bibendum tortor, ut auctor nisl congue id. In mattis facilisis leo eget semper. Nullam mollis felis sed arcu fermentum luctus eget at velit.
                            </p> -->
                           
                        </div>
                        <!-- /tab content -->
                        <!-- tab content -->
                        <div id="tab-podcasts" class="tab-content">
                        	<h2>Video e Canzoni su SoundCloud</h2>
                           <!--  <p>Suspendisse quis aliquam justo. Maecenas tristique imperdiet magna eu fermentum. Donec non enim purus, vel lobortis lacus. Nulla facilisi. Donec consectetur, turpis ac consequat mollis, odio leo pellentesque ipsum, sed mattis mauris elit ut elit. Ut dictum bibendum tortor, ut auctor nisl congue id. In mattis facilisis leo eget semper. Nullam mollis felis sed arcu fermentum luctus eget at velit.
                            </p> -->
                            
							<c:forEach items="${soundcloud}" var="soundcloud">
								${soundcloud.url}
							</c:forEach>
                        </div>
                        <!-- /tab content -->
                        <!-- tab content -->
                        <div id="tab-gallery" class="tab-content">
                        	<h2>Galleria Foto</h2>
                            <div class="gallery-3-col gallery-join">
                            <c:forEach items="${album_foto}" var="album_foto" varStatus="status" >
                            	<c:forEach items="${album_foto.foto}" var="foto" varStatus="status" >
                            	
                            	
                            	<a href="${pageContext.request.contextPath}/${foto.url}" class="gallery-item imagebox thumb-icon" title="Image Title" data-group="group1">
			                        <img src="${pageContext.request.contextPath}/${foto.url}" alt="Image Title">
			                        <span class="icon-wrap">
			                            <!-- icon from icomoon -->
			                            <span class="icon icon-search"></span>
			                        </span>
			                    </a>
			                    </c:forEach>
                            </c:forEach>
								
			                    
							</div>
                        </div>
                        <!-- /tab content -->
                        <!-- tab content -->
                        <div id="tab-events" class="tab-content">
                        	<h2>Concerti e Eventi</h2>
                            <!-- Events table -->
				            <table class="layout display responsive-table">
				                <thead>
				                    <tr>
				                        <th>Date</th>
				                        <th colspan="2">Evento</th>
				                    </tr>
				                </thead>
				                <tbody>
				                <c:forEach items="${eventi}" var="eventi">
				                	<tr>
				                        <td class="table-date">${eventi.data}</td>
				                        <td class="table-name">${eventi.locale.nomeLocale}<a href="#!/pages/event-single-disqus" class="event-location">${eventi.luogo}</a></td>
				                        <td class="actions">
				                            <a href="${pageContext.request.contextPath}/Events/${eventi.id}" class="buy-tickets" title="Buy Tickets">More Info</a>
				                        </td>
				                    </tr>
				                </c:forEach>
				                    
				                </tbody>
				            </table>
				            <!-- /events table --> 
                        </div>
                        <!-- /tab content -->
                    </div>
                    <!-- /tabs -->
					
					
				</article>
				<!-- /article -->

				<!-- Page navigation -->
				<!-- <div class="page-nav">
					<a href="javascript:;" class="prev"><span class="icon icon-arrow-left"></span> Previous</a><a href="javascript:;" class="next">Next <span class="icon icon-arrow-right"></span></a>
				</div> -->
			</div>
			<!-- /main -->
		</div>
		<!-- /container -->
	</section>
	<!-- /Content -->

</section>
<!-- /page -->
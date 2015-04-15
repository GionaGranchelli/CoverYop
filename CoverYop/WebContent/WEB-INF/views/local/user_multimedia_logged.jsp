<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:declaration></jsp:declaration><%@taglib
	uri="http://www.springframework.org/security/tags" prefix="security"%>
<!-- ############################# Ajax Page Container ############################# -->
<section id="page" data-title="Single Artist Page">

	<!-- ############################# Intro ############################# -->
	<section class="intro-title section border-bottom"
		style="background-image: url(${pageContext.request.contextPath}/resources/placeholders/blog-grid-bg.jpg)">

		<h2 class="heading-l">${titolo_page_1}
			<span class="color">${titolo_page_2}</span>
		</h2>
		<br>
		<!-- Overlay -->
		<span class="overlay grids"></span>
	</section>
	<!-- /intro -->

	<!-- ############################# Content ############################# -->
	<section class="content section">
		<!-- container -->

		<div class="container">
			<h1 class="entry-title">Modifica Multimedia</h1>
			<!-- ############################# Single Artist ############################# -->
			<!-- Sidebar -->
			<div class="sidebar main-left main-medium">
				<!-- Widgets -->
				<!-- Details widget -->
				<div class="widget details-widget">

					<div class="details-meta">
						<!-- Details list -->
						<a class="btn small dark" href="${pageContext.request.contextPath}/Privee/">
							<i class="icon icon-music"></i> 
							Profilo Locale
						</a>
						<a class="btn small dark"  href="${pageContext.request.contextPath}/Privee/Utente">
							<i class="icon icon-user"></i> 
							Profilo Utente
						</a>
						<a class="btn small dark" id="attuale" href="${pageContext.request.contextPath}/Privee/Multimedia">
							<i class="icon icon-images"></i>
							
							Foto e Video
							
						</a>
<%-- 						<a class="btn small dark" href="${pageContext.request.contextPath}/BackStage/Tour"> --%>
<!-- 							<i class="icon icon-yelp"></i>  -->
<!-- 							Crea Tour -->
<!-- 						</a> -->
						<a class="btn small dark" href="${pageContext.request.contextPath}/Privee/Eventi">
							<i class="icon icon-dribbble"></i> 
							Gestione Eventi
						</a>
					</div>
					
					<!-- <div class="details-social-box">
						
					</div>
					 -->
				</div>

			</div>
			<!-- /sidebar -->

			<!-- Main -->
			<div id="main" class="release main-left main-medium">

				<!-- Article -->
				<article>

					<div class="tabs-wrap">
						<!-- tabs navigation -->
						<ul class="tabs">
							<li><a href="#tab-photo">Foto</a></li>
<!-- 							<li><a href="#tab-music">Musica</a></li> -->
							<li><a href="#tab-video">Video</a></li>
							

						</ul>
						<!-- /tabs navigation -->


						
								   
							
							<div class="tab-content" id="tab-photo">
							<form:form action="${pageContext.request.contextPath}/Privee/updateMultimedia" 
								   method="POST" 
								   class="form contact-form"
								   commandName="formFotoProfilo"
								   enctype="multipart/form-data">
								<h2>Album Fotografici</h2>
								<div class="comandi">
								<form:input path="photoFileProfilo" type="file"  multiple="multiple"/>
								
								
								</div>
								<div class="gallery-3-col gallery-join">
									<c:forEach items="${albums}" var="albums" varStatus="status">
										<div class="photoAlbums" id="${albums.id}">
											<p>${albums.titolo}</p>
											<c:forEach items="${albums.foto}" var="foto" varStatus="status">
												<div class="photos">
													<img src="${pageContext.request.contextPath}/${foto.url}" alt="Image Title" class="immaginiModifica">
						                        	<span class="icon-wrap" style="float:left;">
						                            <a href="${pageContext.request.contextPath}/BackStage/deletePhoto/${foto.id}">
							                            Cancella
							                            <span class="icon icon-cancel-circle"></span>
						                            </a>
						                            
						                        	</span>
												</div>
						                    </c:forEach>
										</div>
									</c:forEach>
								</div>
								<input type="submit" value="Yop!"/>
								</form:form>
								
							</div>
							
<!-- 							<div class="tab-content" id="tab-music"> -->
<%-- 							<form:form action="${pageContext.request.contextPath}/BackStage/updateMultimedia"  --%>
<%-- 								   method="POST"  --%>
<%-- 								   class="form contact-form" --%>
<%-- 								   commandName="formMusica" --%>
<%-- 								   enctype="multipart/form-data"> --%>
<!-- 								<h2>La tua Musica</h2> -->
<!-- 								<div class="comandi"> -->
<%-- 								<form:input path="musicFile" type="file"  multiple="multiple"/> --%>
<!-- 								<button type="button" id="addAlbum">Aggiungi Album</button> -->
<!-- 								<script> -->
<!-- // 								$('#addAlbum').click(function(){ -->
<!-- // 									$('div.albumsView').first().before('<div class="albumsView" style="margin-top:5%;margin-bottom:5%;"></div>'); -->
<!-- // 									$('div.albumsView').first().append('<span>Inserisci Il Nome dell&#96;Album</span>'); -->
<!-- // 									$('div.albumsView').first().append('<input type="text" name="albumTitle" id="albumTitle" placeholder="Nome Album" />'); -->
<!-- // 									$('div.albumsView').first().append('<span>Inserisci le Canzoni</span>'); -->
<!-- // 									$('div.albumsView').first().append(''); -->
<!-- // 									$('#addAlbum').remove(); -->
<!-- // 								}); -->
<!-- 								</script> -->
								
<!-- 								</div> -->
								
<%-- 								<c:forEach items="${albumsMusic}" var="album" varStatus="status"> --%>
<%--                             		<div class="albumsView" id="${album.id}"> --%>
<%--                             		<p style="text-align: center; margin: 0px; padding: 0px; border-bottom: 1px solid rgb(68, 68, 68);"> ${album.nome}</p> --%>
<!-- 	                            		<ol id="release-list" class="tracklist"> -->
<%-- 				                            <c:forEach items="${album.canzoni}" var="songs" varStatus="status"> --%>
<!-- 				                            <li> -->
<!-- 												<div class="track-details"> -->
<%-- 													<a class="track sp-play-track" href="${pageContext.request.contextPath}/resources/${songs.url}" data-cover="${pageContext.request.contextPath}/resources/placeholders/release-image02.jpg"> --%>
<!-- 														cover -->
<%-- 														<img class="track-cover" src="${pageContext.request.contextPath}/resources/img/cover.png" alt="Traccia Durata"> --%>
<!-- 														Title -->
<%-- 														<span class="track-title">${songs.titolo}</span> --%>
<!-- 														Artists -->
<%-- 														<span class="track-artists">${songs.durata}</span> --%>
<!-- 													</a> -->
<!-- 													<div class="track-buttons"> -->
<%-- 															<a href="${pageContext.request.contextPath}/BackStage/deleteSong/${songs.id}"><span class="icon icon-cancel-circle"></span>Cancella</a> --%>
<!-- 															<a href="javascript:;" class="googleplus-share"><i class="icon icon-soundcloud"></i></a> -->
<!-- 															<a href="javascript:;" class="googleplus-share"><i class="icon icon-download"></i></a> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</li> -->
<%-- 											</c:forEach> --%>
<!-- 										</ol> -->
<!-- 									</div> -->
<%-- 								</c:forEach> --%>
<!-- 								<input type="submit" value="Musica - Yop!"/> -->
<%-- 							</form:form> --%>
<!--                             </div> -->
							
							<div class="tab-content" id="tab-video">
							<form:form action="${pageContext.request.contextPath}/Privee/updateMultimedia" 
								   method="POST" 
								   class="form contact-form"
								   commandName="formVideo"
								   >
								<h2>Inserisci un nuovo video</h2>
								<div class="comandi" style="margin-bottom:25px;">
									<span>Titolo Canzone</span>
									<form:input path="titolo" type="text"/>
									<span>Inserisci Iframe</span>
									<form:input path="url" type="text"/>
									<input type="submit" value="Yop - Video" style="margin-top:15px;"/>
								</div>
								<div id="videoCollection">
								<h2>I tuoi video</h2>
								<c:forEach items="${videos}" var="soundcloud">
									<span>${soundcloud.titolo}</span>
									<span style="float:right;"><a href="${pageContext.request.contextPath}/BackStage/deleteVideo/${soundcloud.id}"><span class="icon icon-cancel-circle"></span>Cancella</a></span>
									<div>${soundcloud.url}</div>
								</c:forEach>
								</div>
								
								</form:form>
							</div>
							
							
						
					</div>

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
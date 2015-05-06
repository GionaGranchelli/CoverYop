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
						<a class="btn small dark" href="${pageContext.request.contextPath}/Privee/Eventi">
							<i class="icon icon-dribbble"></i> 
							Gestione Eventi
						</a>
					</div>
					
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
							<form:form action="${pageContext.request.contextPath}/Privee/updateMultimedia/ProfileImage" 
								   method="POST" 
								   class="form contact-form"
								   modelAttribute="formFotoProfilo"
								   enctype="multipart/form-data">
								
								<div class="details-meta comandi">
									<h2>Inserisci Foto Profilo</h2>
									<form:input path="photoFile" type="file"/>
									<input type="submit" value="Yop!"/>
								</div>
							</form:form>
								
							<form:form action="${pageContext.request.contextPath}/Privee/updateMultimedia/AlbumPhoto" 
								   method="POST" 
								   class="form contact-form"
								   modelAttribute="formFoto"
								   enctype="multipart/form-data">
								
								   <div class="details-meta comandi">
								   		<h2>Inserisci un nuovo album</h2>
										<form:input path="photoFile" type="file"  multiple="multiple"/>
										<input type="submit" value="Yop!"/>
								   </div>
								   
							</form:form> 
							</div>
							<div class="tab-content" id="tab-video">
							<form:form action="${pageContext.request.contextPath}/Privee/updateMultimedia/Video" 
								   method="POST" 
								   class="form contact-form"
								   modelAttribute="formVideo">
								
								<div class="details-meta comandi" style="margin-bottom:25px;">
								<h2>Inserisci un nuovo video</h2>
									<span>Titolo Video</span>
									<form:input path="titolo" type="text"/>
									<span>Inserisci Iframe</span>
									<form:input path="url" type="text"/>
									<input type="submit" value="Yop - Video" style="margin-top:15px;"/>
								</div>
								<div class="details-meta" id="videoCollection">
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
				<div class="details-meta gallery-3-col gallery-join">
						<c:forEach items="${albums}" var="albums" varStatus="status">
							<div class="photoAlbums" id="${albums.id}">
							<h2>${albums.titolo}</h2>
							<c:forEach items="${albums.foto}" var="foto" varStatus="status">
								<div class="photos">
									<img src="${pageContext.request.contextPath}/LocalSlide/image.html?id=${foto.id}" alt="Image Title" class="immaginiModifica">
									<span class="icon-wrap" style="float:left;">
										<a href="${pageContext.request.contextPath}/Privee/deletePhoto/${foto.id}">Cancella<span class="icon icon-cancel-circle"></span></a>
									</span>
								</div>
							</c:forEach>
							</div>
						</c:forEach>
			
		   </div>
				</article>
				<!-- /article -->
				<!-- Page navigation -->
			</div>
			<!-- /main -->
		</div>
		<!-- /container -->
	</section>
	<!-- /Content -->

</section>
<!-- /page -->
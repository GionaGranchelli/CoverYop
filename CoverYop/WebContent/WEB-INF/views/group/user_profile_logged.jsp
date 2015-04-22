<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
			<h1 class="entry-title">Modifica Profilo Utente</h1>
			<!-- ############################# Single Artist ############################# -->
			<!-- Sidebar -->
			<div class="sidebar main-left main-medium">
				<!-- Widgets -->
				<!-- Details widget -->
				<div class="widget details-widget">

					<div class="details-meta">
						<!-- Details list -->
						<a class="btn small dark" href="${pageContext.request.contextPath}/BackStage/">
							<i class="icon icon-music"></i> 
							Profilo Band
						</a>
						<a class="btn small dark" id="attuale" href="${pageContext.request.contextPath}/BackStage/Utente">
							<i class="icon icon-user"></i> 
							Profilo Utente
						</a>
						<a class="btn small dark" href="${pageContext.request.contextPath}/BackStage/Multimedia">
							<i class="icon icon-images"></i>
							
							Foto e Video
							
						</a>
						<a class="btn small dark" href="${pageContext.request.contextPath}/BackStage/Tour">
							<i class="icon icon-yelp"></i> 
							Crea Tour
						</a>
						<a class="btn small dark" href="${pageContext.request.contextPath}/BackStage/Eventi">
							<i class="icon icon-dribbble"></i> 
							Gestione Eventi
						</a>
					</div>
					
					<!-- <div class="details-social-box">
						
					</div>
					 -->
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

					<div class="tabs-wrap">
						<!-- tabs navigation -->
						<ul class="tabs">
							<li><a href="#tab-base">Info Base</a></li>
							<li><a href="#tab-login">Login</a></li>
							

						</ul>
						<!-- /tabs navigation -->


						<form:form action="${pageContext.request.contextPath}/BackStage/updateUtente" 
							  method="POST" 
							  modelAttribute="utente" 
							  class="form contact-form">

							<div class="tab-content" id="tab-base">
								<h2>Info Base</h2>
								<label for="nome">Nome Utente</label> 
								<form:input path="nome" 
											id="nome" 
											placeholder="Nome Utente"
											value="${utente.nome}"/>
								
								<label for="cognome">Cognome Utente</label> 
								<form:input path="cognome" 
											id="cognome" 
											placeholder="Cognome Utente"
											value="${utente.cognome}"/>
									
								<label for="telefono">Telefono</label> 
								<form:input path="telefono" 
											id="telefono" 
											placeholder="Telefono"
											value="${utente.telefono}"/>
								
								<label for="citta">Città</label> 
								<form:input path="citta" id="citta" 
									placeholder="Citta" value="${utente.citta}"/>
									
								<label for="indirizzo">Indirizzo</label> 
								<form:input path="indirizzo" 
											id="indirizzo" 
											placeholder="Indirizzo"
											value="${utente.indirizzo}"/>
									
							</div>
							
							<div class="tab-content" id="tab-login">
								<h2>Info Login</h2>
								
								<label for="username">Username</label> 
								<form:input path="username" id="username" 
									placeholder="Username" value="${utente.username}"/>
									
								<label for="email">EMail</label> 
								<form:input path="email" id="email" 
									placeholder="EMail" value="${utente.email}"/>
									
								<label for="password">Password</label> 
								<form:input path="password" id="password" 
									placeholder="Password" value="${utente.password}"/>
								
							</div>
							
								
							
							<input type="submit" value="Invia"/>
						</form:form>
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
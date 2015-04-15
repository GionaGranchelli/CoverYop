<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<a class="btn small dark" href="${pageContext.request.contextPath}/Privee/">
							<i class="icon icon-music"></i> 
							Profilo Locale
						</a>
						<a class="btn small dark" id="attuale" href="${pageContext.request.contextPath}/Privee/Utente">
							<i class="icon icon-user"></i> 
							Profilo Utente
						</a>
						<a class="btn small dark" href="${pageContext.request.contextPath}/Privee/Multimedia">
							<i class="icon icon-images"></i>
							
							Foto e Video
							
						</a>
						<%-- <a class="btn small dark" href="${pageContext.request.contextPath}/Privee/Tour">
							<i class="icon icon-yelp"></i> 
							Crea Tour
						</a> --%>
						<a class="btn small dark" href="${pageContext.request.contextPath}/Privee/Eventi">
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


						<form action="${pageContext.request.contextPath}/Privee/updateUtente" 
								method="POST" 
								class="form contact-form">

							<div class="tab-content" id="tab-base">
								<h2>Info Base</h2>
								<label for="nome">Nome Utente</label> 
								<input type="text"
									id="nome" name="nome" 
									placeholder="Nome Utente" value="${locale.nome}"/>
								
								<label for="cognome">Cognome Utente</label> 
								<input type="text"
									id="cognome" name="cognome" 
									placeholder="Cognome Utente" value="${locale.cognome}"/>
									
								<label for="telefono">Telefono</label> 
								<input type="text"
									id="telefono" name="telefono" 
									placeholder="Telefono" value="${locale.telefono}"/>
									
							</div>
							
							<div class="tab-content" id="tab-login">
								<h2>Info Login</h2>
								
								<label for="username">Username</label> 
								<input type="text"
									id="username" name="username" 
									placeholder="Username" value="${locale.username}"/>
									
								<label for="email">EMail</label> 
								<input type="text"
									id="email" name="email" 
									placeholder="EMail" value="${locale.email}"/>
									
								<label for="password">Password</label> 
								<input type="text"
									id="password" name="password" 
									placeholder="Password" value="${locale.password}"/>
								
							</div>
							
								
							
							<input type="submit" value="Invia"/>
						</form>
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
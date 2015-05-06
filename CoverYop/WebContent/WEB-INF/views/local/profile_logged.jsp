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
			<h1 class="entry-title">Modifica Informazioni Locale</h1>
			<!-- ############################# Single Local ############################# -->
			<!-- Sidebar -->
			<div class="sidebar main-left main-medium">
				<!-- Widgets -->
				<!-- Details widget -->
				<div class="widget details-widget">
					<div class="details-meta">
						<!-- Details list -->
						<a class="btn small dark" id="attuale" href="${pageContext.request.contextPath}/Privee/">
							<i class="icon icon-music"></i> 
							Profilo Locale
						</a>
						<a class="btn small dark" href="${pageContext.request.contextPath}/Privee/Utente">
							<i class="icon icon-user"></i> 
							Profilo Utente
						</a>
						<a class="btn small dark" href="${pageContext.request.contextPath}/Privee/Multimedia">
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
							<li><a href="#tab-biograf">Biografia</a></li>
							<li><a href="#tab-social">Social</a></li>
							<li><a href="#tab-service">Service</a></li>
						</ul>
						<!-- /tabs navigation -->
						<form:form action="${pageContext.request.contextPath}/Privee/updateLocale" 
								   method="POST"
								   modelAttribute="locale" 
								   class="form contact-form">

							<div class="tab-content" id="tab-biograf">
								<h2>Info Base</h2>
							<form:input path="id" id="id" type="hidden" value="${locale.id}"/>
<%-- 							<form:input path="nome" id="nome" type="hidden" value="${locale.nome}"/> --%>
<%-- 							<form:input path="cognome" id="cognome" type="hidden" value="${locale.cognome}"/> --%>
<%-- 							<form:input path="username" id="username" type="hidden" value="${locale.username}"/> --%>
<%-- 							<form:input path="password" id="password" type="hidden" value="${locale.password}"/> --%>
<%-- 							<form:input path="email" id="email" type="hidden" value="${locale.email}"/> --%>
<%-- 							<form:input path="lat" id="lat" type="hidden" value="${locale.lat}"/> --%>
<%-- 							<form:input path="lng" id="lng" type="hidden" value="${locale.lng}"/> --%>
<%-- 							<form:input path="telefono" id="telefono" type="hidden" value="${locale.telefono}"/> --%>
<%-- 							<form:input path="ruolo" id="ruolo" type="hidden" value="${locale.ruolo.id}"/> --%>
<%-- 								 --%>
<%-- 								<form:input path="contatti" id="contatti" type="hidden" value="${locale.contatti}"/> --%>
								
<%-- 								 --%>
<%-- 								 --%>
<%-- 								 --%>
<%-- 								<form:input path="email" id="email" type="hidden" value="${locale.email}"/> --%>
								
<%-- 								<form:input path="lat" id="lat" type="hidden" value="${locale.lat}"/> --%>
<%-- 								<form:input path="lng" id="lng" type="hidden" value="${locale.lng}"/> --%>
<%-- 								 --%>
<%-- <%-- 								<form:input path="scaletta" id="scaletta" type="hidden" value="${gruppo.scaletta.id}"/>  --%>
<%-- 								<form:input path="telefono" id="telefono" type="hidden" value="${locale.telefono}"/>  --%>
								
								<label for="nomeLocale"><strong>Nome Locale</strong></label>
								<form:input path="nomeLocale"
									   id="nomeLocale"
									   placeholder="Nome Locale"
									   value="${locale.nomeLocale}"/>

								<label for="citta"><strong>Luogo</strong></label>
								<form:input path="citta" 
									   id="citta"
									   placeholder="Citta" 
									   value="${locale.citta}"/> 
									   
								<label for="indirizzo">Indirizzo</label> 
								<form:input path="indirizzo" 
											id="indirizzo" 
											placeholder="Indirizzo" 
											value="${locale.indirizzo}"/>	
								
								<label for="orarioApertura"><strong>Orario Apertura</strong></label>
									<form:input path="orarioApertura" 
												id="orarioApertura" 
												value="${locale.orarioApertura} "/>
									
								<label for="orarioChiusura"><strong>Orario Chiusura</strong></label>
									<form:input path="orarioChiusura" 
												id="orarioChiusura" 
												value="${locale.orarioChiusura}"/>
									
								<label for="categoria.nomeCat"><strong>Categoria</strong></label>
								<label>Inserisci Se sei un Bar, Pub, Discoteca.</label>
									<form:input path="categoria.nomeCat" 
												id="categoria.nomeCat" 
												value="${locale.categoria.nomeCat}"/>
									
								<label for="categoria.descrizioneCat"><strong> E qui una piccola definizione di quanto è speciale il tuo locale</strong></label>
									<form:input path="categoria.descrizioneCat" 
												id="categoria.descrizioneCat" 
												value="${locale.categoria.descrizioneCat}"/>
								
								<div class="row clearfix">
									<label for="contact-message"><strong>Biografia</strong>
										(required)</label>
									<form:textarea path="descrizione" 
													cols="88" 
													rows="6" 
													/>
								</div>
								<script>
								$(document).ready(function(){
									$(function() {    
										$('#orarioApertura').timepicker();
										$('#orarioChiusura').timepicker();
									});
								});
								</script>
								
							</div>
							
							<div class="tab-content" id="tab-social">
								<h2>Social</h2>
								<label for="canale.facebook">Facebook</label> 
								<form:input path="canale.facebook" 
											id="canale.facebook" 
											placeholder="Facebook" 
											value="${canali.facebook}"/> 
											
								<label for="canale.twitter">Twitter</label>
								<form:input path="canale.twitter" 
											id="canale.twitter" 
											placeholder="Twitter" 
											value="${canali.twitter}"/> 
											
								<label for="canale.youtube">Youtube</label>
								<form:input path="canale.youtube" 
											id="canale.youtube" 
											placeholder="Youtube" 
											value="${canali.youtube}"/> 
											
								<label for="canale.soundcloud">SoundCloud</label>
								<form:input path="canale.soundCloud" 
											id="canale.soundCloud" 
											placeholder="SoundCloud" 
											value="${canali.soundCloud}"/> 
											
								<label for="canale.googlePlus">Google+</label>
								<form:input path="canale.googlePlus" 
											id="canale.googlePlus" 
											placeholder="Google+" 
											value="${canali.googlePlus}"/>
											
							</div>
							<div class="tab-content" id="tab-service">
								<h2>Service</h2>
								<label for="service.mixer">Mixer - Inserisci Canali</label>
								<form:input path="service.mixer"/>
								
								<label for="service.amplificatore">Amplificatore</label>
								<form:checkbox path="service.amplificatore"/>
								
								<label for="service.casse">Casse- Inserisci i Watt</label>
								<form:input path="service.casse"/>
								
								<label for="service.luci">Luci</label>
								<form:checkbox path="service.luci"/>
								
								<label for="service.microfono">Microfono</label>
								<form:checkbox path="service.microfono"/>
					
							</div>

							<input type="submit" value="Invia"/>
						</form:form>
					</div>

				</article>

			</div>
			<!-- /main -->
		</div>
		<!-- /container -->
	</section>
	<!-- /Content -->

</section>
<!-- /page -->
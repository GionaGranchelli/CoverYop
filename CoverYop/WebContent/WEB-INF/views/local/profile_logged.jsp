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
			<h1 class="entry-title">Modifica Informazioni Locale</h1>
			<!-- ############################# Single Artist ############################# -->
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
						<%-- <a class="btn small dark" href="${pageContext.request.contextPath}/BackStage/Tour">
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
							<li><a href="#tab-biograf">Biografia</a></li>
							<li><a href="#tab-social">Social</a></li>
							<li><a href="#tab-service">Service</a></li>
							

						</ul>
						<!-- /tabs navigation -->


						<form action="${pageContext.request.contextPath}/Privee/updateLocale" method="POST" class="form contact-form">

							<div class="tab-content" id="tab-biograf">
								<h2>Info Base</h2>
								<input name="id" id="id" type="hidden" value="${locale.id}"/>
								<input name="nome" id="nome" type="hidden" value="${locale.nome}"/>
								<input name="password" id="password" type="hidden" value="${locale.password}"/>
								<input name="cognome" id="cognome" type="hidden" value="${locale.cognome}"/>
								<input name="email" id="email" type="hidden" value="${locale.email}"/>
								
								<input name="lat" id="lat" type="hidden" value="${locale.lat}"/>
								<input name="lng" id="lng" type="hidden" value="${locale.lng}"/>
								<input name="username" id="username" type="hidden" value="${locale.username}"/>
<%-- 								<input name="scaletta" id="scaletta" type="hidden" value="${gruppo.scaletta.id}"/> --%>
<%-- 								<input name="ruolo" id="ruolo" type="hidden" value="${gruppo.ruolo.id}"/> --%>
								<input name="telefono" id="telefono" type="hidden" value="${locale.telefono}"/>
								
								
								<label for="nomeLocale"><strong>Nome Locale</strong></label> <input type="text"
									id="nomeLocale" name="nomeLocale" placeholder="Nome Gruppo" value="${locale.nomeLocale}"/>

								<label for="luogo"><strong>Luogo</strong></label> <input type="text" id="citta"
									name="citta" placeholder="Luogo" value="${locale.citta}"/> 
								<label for="indirizzo">Indirizzo</label> 
								<input type="text" id="indirizzo" name="indirizzo" placeholder="Indirizzo" value="${locale.indirizzo}"/>	
								<label for="locale.orarioApertura"><strong>Orario Apertura</strong></label>
									<input type="text" name="orarioApertura" id="orarioApertura" value="${locale.orarioApertura} "/>
									
								<label for="locale.orarioChiusura"><strong>Orario Chiusura</strong></label>
									<input type="text" name="orarioChiusura" id="orarioChiusura" value="${locale.orarioChiusura}"/>
									
								<label for="genere"><strong>Categoria</strong></label>
								<label>Inserisci Se sei un Bar, Pub, Discoteca.</label>
									<input type="text" id="categoria.nomeCat" name="categoria.nomeCat" value="${locale.categoria.nomeCat}"/>
									
								<label for="categoria.descrizioneCat"><strong> E qui una piccola definizione di quanto è speciale il tuo locale</strong></label>
									<input type="text" id="categoria.descrizioneCat" name="categoria.descrizioneCat" value="${locale.categoria.descrizioneCat}"/>
								
								<div class="row clearfix">
									<label for="contact-message"><strong>Biografia</strong>
										(required)</label>
									<textarea name="descrizione" id="descrizione" cols="88"
										rows="6" required="">${locale.descrizione}</textarea>
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
							
								<label for="facebook">Facebook</label> 
								<input type="text" id="canale.facebook" name="canale.facebook" placeholder="Facebook" value="${canali.facebook}"/> 
								<label for="twitter">Twitter</label>
								<input type="text" id="canale.twitter"	name="canale.twitter" placeholder="Twitter" value="${canali.twitter}"/> 
								<label for="youtube">Youtube</label>
								<input type="text" id="canale.youtube" name="canale.youtube" placeholder="Youtube" value="${canali.youtube}"/> 
								<label for="soundcloud">SoundCloud</label>
								<input type="text" id="canale.soundCloud" name="canale.soundCloud" placeholder="SoundCloud" value="${canali.soundCloud}"/> 
								<label for="googlep">Google+</label>
								<input type="text" id="canale.googlePlus" name="canale.googlePlus" placeholder="Google+" value="${canali.googlePlus}"/>
								
								
								
							</div>
							
							<div class="tab-content" id="tab-service">
							
								<h2>Service</h2>
						
								
								<label for="mixer">Mixer</label> 
								<c:choose>
									<c:when  test="${locale.service.mixer > 0}">
										Presente <input style="width: 10%;" type="radio" id="service.mixer" name="service.mixer" value="1" checked="checked"/>
										Non Presente <input style="width: 10%;" type="radio" id="service.mixer" name="service.mixer" value="0" />
									</c:when>
									<c:otherwise>
										Presente <input style="width: 10%;" type="radio" id="service.mixer" name="service.mixer" value="1" />
										Non Presente <input style="width: 10%;" type="radio" id="service.mixer" name="service.mixer" value="0" checked="checked"/>
									</c:otherwise>
								</c:choose>
								
								<label for="amplificatore">Amplificatore</label>
								<c:choose>
									<c:when test="${locale.service.amplificatore}">
										Presente <input style="width: 10%;" type="radio" id="service.amplificatore" name="service.amplificatore" value="1" checked="checked"/>
										Non Presente <input style="width: 10%;" type="radio" id="service.amplificatore" name="service.amplificatore" value="0" />
									</c:when>
									<c:otherwise>
										Presente <input style="width: 10%;" type="radio" id="service.amplificatore" name="service.amplificatore" value="1" />
										Non Presente <input style="width: 10%;" type="radio" id="service.amplificatore" name="service.amplificatore" value="0" checked="checked"/>
									</c:otherwise>
								</c:choose>
								
								<label for="casse">Casse</label>
								<c:choose>
									<c:when test="${locale.service.casse > 0}">
									Presente <input style="width: 10%;" type="radio" id="service.casse" name="service.casse" value="1" checked="checked"/>
									Non Presente <input style="width: 10%;" type="radio" id="service.casse" name="service.casse" value="0" />
									</c:when>
									<c:otherwise>
									Presente <input style="width: 10%;" type="radio" id="service.casse" name="service.casse" value="1" />
									Non Presente <input style="width: 10%;" type="radio" id="service.casse" name="service.casse" value="0" checked="checked"/>
									</c:otherwise>
								</c:choose>
								
								<label for="luci">Luci</label>
								<c:choose>
									<c:when test="${locale.service.luci}">
									Presente <input style="width: 10%;" type="radio" id="service.luci" name="service.luci" value="1" checked="checked"/>
									Non Presente <input style="width: 10%;" type="radio" id="service.luci" name="service.luci" value="0" />
									</c:when>
									<c:otherwise>
									Presente <input style="width: 10%;" type="radio" id="service.luci" name="service.luci" value="1" />
									Non Presente <input style="width: 10%;" type="radio" id="service.luci" name="service.luci" value="0" checked="checked"/>
									</c:otherwise>
								</c:choose>
								
								<label for="mic">Microfono</label>
								<c:choose>
									<c:when test="${locale.service.microfono}">
									Presente <input style="width: 10%;" type="radio" id="service.microfono" name="service.microfono" value="1" checked="checked"/>
									Non Presente <input style="width: 10%;" type="radio" id="service.microfono" name="service.microfono" value="0" />
									</c:when>
									<c:otherwise>
									Presente <input style="width: 10%;" type="radio" id="service.microfono" name="service.microfono" value="1" />
									Non Presente <input style="width: 10%;" type="radio" id="service.microfono" name="service.microfono" value="0" checked="checked"/>
									</c:otherwise>
								</c:choose>
								
								<button type="button" id="serviceinfo">Modifica</button>
							
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
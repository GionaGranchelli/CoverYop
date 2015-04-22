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
			<h1 class="entry-title">Modifica Informazioni Band</h1>
			<!-- ############################# Single Artist ############################# -->
			<!-- Sidebar -->
			<div class="sidebar main-left main-medium">
				<!-- Widgets -->
				<!-- Details widget -->
				<div class="widget details-widget">

					<div class="details-meta">
						<!-- Details list -->
						<a class="btn small dark" id="attuale" href="${pageContext.request.contextPath}/BackStage/">
							<i class="icon icon-music"></i> 
							Profilo Band
						</a>
						<a class="btn small dark" href="${pageContext.request.contextPath}/BackStage/Utente">
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
							<li><a href="#tab-biograf">Biografia</a></li>
							<li><a href="#tab-social">Social</a></li>
							<li><a href="#tab-service">Service</a></li>
							<li><a href="#tab-cachet">Cachet</a></li>

						</ul>
						<!-- /tabs navigation -->


						<form:form action="${pageContext.request.contextPath}/BackStage/updateGruppo" 	
									method="POST"  
									modelAttribute="gruppo" 
									class="form contact-form">

							<div class="tab-content" id="tab-biograf">
								<h2>Info Base</h2>
<%-- 								<form:hidden path="id"/> --%>
<%-- 								<form:hidden path="nome"/> --%>
<%-- 								<form:hidden path="password"/> --%>
<%-- 								<form:hidden path="cognome"/> --%>
<%-- 								<form:hidden path="email"/> --%>
<%-- 								<form:hidden path="indirizzo"/> --%>
<%-- 								<form:hidden path="lat" id="lat"/> --%>
<%-- 								<form:hidden path="lng" id="lng"/> --%>
<%-- 								<form:hidden path="username"/> --%>
<%--  								<form:hidden path="scaletta"/> --%>
<%--  								<form:hidden path="ruolo"/> --%>
<%-- 								<form:hidden path="telefono"/>  --%>
<%-- 								<form:hidden path="conversationMitt"/> --%>
<%-- 								<form:hidden path="conversationDest"/> --%>
<%-- 								<form:hidden path="messaggi"/> --%>
<%-- 								<form:hidden path="service.palco"/> --%>
<%-- 								<form:hidden path="video"/>  --%>
<%-- 								<form:hidden path="albumFotografico"/>   --%>
<%-- 								<form:hidden path="albums"/>  --%>
<%-- 								<form:hidden path="componente"/>  --%>
<%-- 								<form:hidden path="eventi"/>  --%>
<%-- 								<form:hidden path="tour"/>  --%>
								
								<label for="nomeGruppo">Nome Gruppo</label>
								 <form:input path="nomeGruppo"
								 			 id="nomeGruppo" 
								 			 placeholder="Nome Gruppo" 
								 			 value="${gruppo.nomeGruppo}"/>

								<label for="citta">Luogo</label>
								<form:input path="citta" 
											id="citta" 
											placeholder="Luogo" 
											value="${gruppo.citta}"/> 
								<div class="col-1-1">
									<label for="genere">Generi</label>
									<div class="col-1-3">
										<h3>Scegli Generi</h3>
<%-- 										<form:checkboxes path="generi" items="${generi}" /> --%>
										<form:select multiple="true" path="generi">
										    <form:options items="${generi}" itemValue="id" itemLabel="genere"/>
										</form:select>
									</div>
									<div class="col-1-4">
									<h3>Generi Scelti</h3>
									<ul>
									
									<c:forEach var="genere" items="${generi_scelti}">
										<li>${genere.genere}</li>
									</c:forEach>
									</ul>
										   
									
									</div>
								</div>	
								
								
								<label for="gruppirif">Gruppi Di Riferimento</label>
<%-- 								<form:checkboxes path="gruppi_rif" items="${gruppirif}" /> --%>
									<div class="col-1-3">
									<h3>Scegli Gruppi di Riferimento</h3>

										<form:select multiple="true" path="gruppi_rif">
										    <form:options items="${gruppirif}" itemValue="id" itemLabel="nome"/>
										</form:select>
									</div>
									<div class="col-1-4">
									<h3>Generi Scelti</h3>
									<ul>
									
									<c:forEach var="gruppirif" items="${gruppirif_scelti}">
										<li>${gruppirif.nome}</li>
									</c:forEach>
									</ul>
									</div>
								<div class="row clearfix">
									<label for="contact-message"><strong>Biografia</strong>
										(required)</label>
									<form:textarea path="biografia" 
 									cols="88" rows="6" placeholder="${gruppo.biografia}" 
 									/> 
								</div>
								
								
							</div>
							
							<div class="tab-content" id="tab-social">
								<h2>Social</h2>
							
								<label for="canale.facebook">Facebook</label> 
								<form:input path="canale.facebook" id="canale.facebook" placeholder="Facebook" value="${canali.facebook}"/> 
								<label for="canale.twitter">Twitter</label>
								<form:input path="canale.twitter"	id="canale.twitter" placeholder="Twitter" value="${canali.twitter}"/> 
								<label for="canale.youtube">Youtube</label>
								<form:input path="canale.youtube" id="canale.youtube" placeholder="Youtube" value="${canali.youtube}"/> 
								<label for="canale.soundcloud">SoundCloud</label>
								<form:input path="canale.soundCloud" id="canale.soundCloud" placeholder="SoundCloud" value="${canali.soundCloud}"/> 
								<label for="canale.googlep">Google+</label>
								<form:input path="canale.googlePlus" id="canale.googlePlus" placeholder="Google+" value="${canali.googlePlus}"/>
								
								
								
							</div>
							
							<div class="tab-content" id="tab-service">
							
								<h2>Service</h2>
						
								
								<label for="mixer">Mixer - Inserisci Canali Mixer</label> 
								<form:input path="service.mixer"/>
<%-- 								<c:choose> --%>
<%-- 									<c:when  test="${gruppo.service.mixer > 0}"> --%>
<!-- 										Presente <input style="width: 10%;" type="radio" id="service.mixer" name="service.mixer" value="1" checked="checked"/> -->
<!-- 										Non Presente <input style="width: 10%;" type="radio" id="service.mixer" name="service.mixer" value="0" /> -->
<%-- 									</c:when> --%>
<%-- 									<c:otherwise> --%>
<!-- 										Presente <input style="width: 10%;" type="radio" id="service.mixer" name="service.mixer" value="1" /> -->
<!-- 										Non Presente <input style="width: 10%;" type="radio" id="service.mixer" name="service.mixer" value="0" checked="checked"/> -->
<%-- 									</c:otherwise> --%>
<%-- 								</c:choose> --%>
								
								<label for="amplificatore">Amplificatore </label>
								<form:checkbox path="service.amplificatore"/>
<%-- 								<c:choose> --%>
<%-- 									<c:when test="${gruppo.service.amplificatore}"> --%>
<!-- 										Presente <input style="width: 10%;" type="radio" id="service.amplificatore" name="service.amplificatore" value="1" checked="checked"/> -->
<!-- 										Non Presente <input style="width: 10%;" type="radio" id="service.amplificatore" name="service.amplificatore" value="0" /> -->
<%-- 									</c:when> --%>
<%-- 									<c:otherwise> --%>
<!-- 										Presente <input style="width: 10%;" type="radio" id="service.amplificatore" name="service.amplificatore" value="1" /> -->
<!-- 										Non Presente <input style="width: 10%;" type="radio" id="service.amplificatore" name="service.amplificatore" value="0" checked="checked"/> -->
<%-- 									</c:otherwise> --%>
<%-- 								</c:choose> --%>
								
								<label for="casse">Casse - Inserisci i Watt</label>
								<form:input path="service.casse"/>
<%-- 								<c:choose> --%>
<%-- 									<c:when test="${gruppo.service.casse > 0}"> --%>
<!-- 									Presente <input style="width: 10%;" type="radio" id="service.casse" name="service.casse" value="1" checked="checked"/> -->
<!-- 									Non Presente <input style="width: 10%;" type="radio" id="service.casse" name="service.casse" value="0" /> -->
<%-- 									</c:when> --%>
<%-- 									<c:otherwise> --%>
<!-- 									Presente <input style="width: 10%;" type="radio" id="service.casse" name="service.casse" value="1" /> -->
<!-- 									Non Presente <input style="width: 10%;" type="radio" id="service.casse" name="service.casse" value="0" checked="checked"/> -->
<%-- 									</c:otherwise> --%>
<%-- 								</c:choose> --%>
								
								<label for="luci">Luci</label>
								<form:checkbox path="service.luci"/>
<%-- 								<c:choose> --%>
<%-- 									<c:when test="${gruppo.service.luci}"> --%>
<!-- 									Presente <input style="width: 10%;" type="radio" id="service.luci" name="service.luci" value="1" checked="checked"/> -->
<!-- 									Non Presente <input style="width: 10%;" type="radio" id="service.luci" name="service.luci" value="0" /> -->
<%-- 									</c:when> --%>
<%-- 									<c:otherwise> --%>
<!-- 									Presente <input style="width: 10%;" type="radio" id="service.luci" name="service.luci" value="1" /> -->
<!-- 									Non Presente <input style="width: 10%;" type="radio" id="service.luci" name="service.luci" value="0" checked="checked"/> -->
<%-- 									</c:otherwise> --%>
<%-- 								</c:choose> --%>
								
								<label for="mic">Microfono</label>
								<form:checkbox path="service.microfono"/>
<%-- 								<c:choose> --%>
<%-- 									<c:when test="${gruppo.service.microfono}"> --%>
<!-- 									Presente <input style="width: 10%;" type="radio" id="service.microfono" name="service.microfono" value="1" checked="checked"/> -->
<!-- 									Non Presente <input style="width: 10%;" type="radio" id="service.microfono" name="service.microfono" value="0" /> -->
<%-- 									</c:when> --%>
<%-- 									<c:otherwise> --%>
<!-- 									Presente <input style="width: 10%;" type="radio" id="service.microfono" name="service.microfono" value="1" /> -->
<!-- 									Non Presente <input style="width: 10%;" type="radio" id="service.microfono" name="service.microfono" value="0" checked="checked"/> -->
<%-- 									</c:otherwise> --%>
<%-- 								</c:choose> --%>
								
								
							
							</div>

							
							<div class="tab-content" id="tab-cachet">
								<h2>Cachet</h2>
							
								<label for="costo">Costo Indicativo</label>
									<form:input path="cachet.prezzo" id="cachet.prezzo" placeholder="costo" value="${gruppo.cachet.prezzo}"/>
									

								<div class="col-1-1">
									<label for="consumazioni">Consumazioni</label>
									<div class="col-1-3" style="margin-bottom: -3%; margin-top: 2%;">
									<form:checkbox path="cachet.consumazioni" value="${gruppo.cachet.consumazioni}"/>
<%-- 									<c:choose> --%>
<%-- 										<c:when test="${gruppo.cachet.consumazioni > 0}"> --%>
<!-- 											Richiesta<input style="width: 10%;" type="radio" id="cachet.consumazioni" name="cachet.consumazioni" placeholder="consumazioni" value="1" checked="checked"/> -->
<!-- 											Non Richiesta <input style="width: 10%;" type="radio" id="cachet.consumazioni" name="cachet.consumazioni" placeholder="consumazioni" value="0" /> -->
<%-- 										</c:when> --%>
<%-- 										<c:otherwise> --%>
<!-- 											Richiesta<input style="width: 10%;" type="radio" id="cachet.consumazioni" name="cachet.consumazioni" placeholder="consumazioni" value="1" /> -->
<!-- 											Non Richiesta <input style="width: 10%;" type="radio" id="cachet.consumazioni" name="cachet.consumazioni" placeholder="consumazioni" value="0" checked="checked"/> -->
<%-- 										</c:otherwise> --%>
<%-- 									</c:choose> --%>
										
									</div>

								</div>
								<div class="col-1-1">
									<label for="rimborsoSpese">Rimborso Spese</label>
									<div class="col-1-3">
									<form:checkbox path="cachet.rimborsoSpese" value="${gruppo.cachet.rimborsoSpese}"/>
<%-- 									<c:choose> --%>
<%-- 										<c:when test="${gruppo.cachet.rimborsoSpese > 0}"> --%>
<!-- 											Richiesta<input style="width: 10%;" type="radio" id="cachet.rimborsoSpese" name="cachet.rimborsoSpese" value="1" checked="checked"/> -->
<!-- 											Non Richiesta <input style="width: 10%;" type="radio" id="rimborsoSpese" name="rimb" value="0" /> -->
<%-- 										</c:when> --%>
<%-- 										<c:otherwise> --%>
<!-- 											Richiesta<input style="width: 10%;" type="radio" id="cachet.rimborsoSpese" name="cachet.rimborsoSpese" value="1" /> -->
<!-- 											Non Richiesta <input style="width: 10%;" type="radio" id="rimborsoSpese" name="rimborsoSpese" value="0" checked="checked"/> -->
<%-- 										</c:otherwise> --%>
<%-- 									</c:choose> --%>
										
									</div>
								</div>
								
								
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
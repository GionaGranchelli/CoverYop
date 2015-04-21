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
									modelAttribute="" 
									class="form contact-form">

							<div class="tab-content" id="tab-biograf">
								<h2>Info Base</h2>
								<%--<input name="id" id="id" type="hidden" value="${gruppo.id}"/>
								<input name="nome" id="nome" type="hidden" value="${gruppo.nome}"/>
								<input name="password" id="password" type="hidden" value="${gruppo.password}"/>
								<input name="cognome" id="cognome" type="hidden" value="${gruppo.cognome}"/>
								<input name="email" id="email" type="hidden" value="${gruppo.email}"/>
								<input name="indirizzo" id="indirizzo" type="hidden" value="${gruppo.indirizzo}"/>
								<input name="lat" id="lat" type="hidden" value="${gruppo.lat}"/>
								<input name="lng" id="lng" type="hidden" value="${gruppo.lng}"/>
								<input name="username" id="username" type="hidden" value="${gruppo.username}"/>
 								<input name="scaletta" id="scaletta" type="hidden" value="${gruppo.scaletta.id}"/>
 								<input name="ruolo" id="ruolo" type="hidden" value="${gruppo.ruolo.id}"/> 
								<input name="telefono" id="telefono" type="hidden" value="${gruppo.telefono}"/> --%>
								
								
								<label for="nomeGruppo">Nome Gruppo</label> <input type="text"
									id="nomeGruppo" name="nomeGruppo" placeholder="Nome Gruppo" value="${gruppo.nomeGruppo}"/>

								<label for="luogo">Luogo</label> <input type="text" id="citta"
									name="citta" placeholder="Luogo" value="${gruppo.citta}"/> 
									
									<label for="genere">Generi</label>
									<c:forEach items="${generi}" var="genere" varStatus="status">
									
									<input type="checkbox" id="generi.genere" name="generi.genere" value="${genere.genere}"/>${genere.genere}
									
									
									</c:forEach>
									
								<label for="gruppirif">Gruppi Di Riferimento</label>
									<c:forEach items="${gruppirif}" var="gruppirif"
										varStatus="status">
										<input type="checkbox" id="gruppi_rif.nome" name="gruppi_rif.nome" value="${gruppirif.nome}">${gruppirif.nome}
									</c:forEach>
								

								<div class="row clearfix">
									<label for="contact-message"><strong>Biografia</strong>
										(required)</label>
									<textarea name="biografia" id="biografia" cols="88"
										rows="6" required="">${gruppo.biografia}</textarea>
								</div>
								
								
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
									<c:when  test="${gruppo.service.mixer > 0}">
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
									<c:when test="${gruppo.service.amplificatore}">
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
									<c:when test="${gruppo.service.casse > 0}">
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
									<c:when test="${gruppo.service.luci}">
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
									<c:when test="${gruppo.service.microfono}">
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

							
							<div class="tab-content" id="tab-cachet">
								<h2>Cachet</h2>
							
								<label for="costo">Costo Indicativo</label>
									<input type="text" id="cachet.prezzo" name="cachet.prezzo" placeholder="costo" value="${gruppo.cachet.prezzo}"/>
									

								<div class="col-1-1">
									<label for="consumazioni">Consumazioni</label>
									<div class="col-1-3" style="margin-bottom: -3%; margin-top: 2%;">
									<c:choose>
										<c:when test="${gruppo.cachet.consumazioni > 0}">
											Richiesta<input style="width: 10%;" type="radio" id="cachet.consumazioni" name="cachet.consumazioni" placeholder="consumazioni" value="1" checked="checked"/>
											Non Richiesta <input style="width: 10%;" type="radio" id="cachet.consumazioni" name="cachet.consumazioni" placeholder="consumazioni" value="0" />
										</c:when>
										<c:otherwise>
											Richiesta<input style="width: 10%;" type="radio" id="cachet.consumazioni" name="cachet.consumazioni" placeholder="consumazioni" value="1" />
											Non Richiesta <input style="width: 10%;" type="radio" id="cachet.consumazioni" name="cachet.consumazioni" placeholder="consumazioni" value="0" checked="checked"/>
										</c:otherwise>
									</c:choose>
										
									</div>

								</div>
								<div class="col-1-1">
									<label for="rimborsoSpese">Rimborso Spese</label>
									<div class="col-1-3">
									<c:choose>
										<c:when test="${gruppo.cachet.rimborsoSpese > 0}">
											Richiesta<input style="width: 10%;" type="radio" id="cachet.rimborsoSpese" name="cachet.rimborsoSpese" value="1" checked="checked"/>
											Non Richiesta <input style="width: 10%;" type="radio" id="rimborsoSpese" name="rimb" value="0" />
										</c:when>
										<c:otherwise>
											Richiesta<input style="width: 10%;" type="radio" id="cachet.rimborsoSpese" name="cachet.rimborsoSpese" value="1" />
											Non Richiesta <input style="width: 10%;" type="radio" id="rimborsoSpese" name="rimborsoSpese" value="0" checked="checked"/>
										</c:otherwise>
									</c:choose>
										
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
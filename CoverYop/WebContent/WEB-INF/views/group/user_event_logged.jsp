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
						<a class="btn small dark"  href="${pageContext.request.contextPath}/BackStage/Utente">
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
						<a class="btn small dark" id="attuale" href="${pageContext.request.contextPath}/BackStage/Eventi">
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
							<li><a href="#tab-base">Aggiungi Evento</a></li>
							<li><a href="#tab-list-eventi">Lista Eventi</a></li>
						</ul>
						
						<c:choose>
						<c:when test="${empty eventoMod}">
							<div class="tab-content" id="tab-base">
							<form:form action="${pageContext.request.contextPath}/BackStage/addEvento" 
								   method="POST" 
								   class="form contact-form"
								   commandName="formEvento"
								   enctype="multipart/form-data">
								<h2>Aggiungi Evento</h2>
								<label for="nome">Nome Evento</label> 
								<form:input path="nome"/>
								
								<label for="locale">Locale</label>
								<form:input path="locale" />
								
								<label for="descrizione">Descrizione</label> 
								<form:textarea path="descrizione"/>
									
								<label for="dataEvento">Data</label> 
								<form:input path="dataEvento"/>
								
								<label for="locandina">Locandina</label> 
								<form:input path="locandina" type="file"  multiple="multiple"/>
									
								<label for="orarioInizio">Ora Inizio</label> 
								<form:input path="orarioInizio"/>
								
								<label for="orarioFine">Ora Fine</label> 
								<form:input path="orarioFine"/>
								
								<label for="prezzo">Prezzo</label> 
								<form:input path="prezzo"/>
								
								<label for="tipologia_Eventi">Tipologia Evento</label>
								<select id="tipologia_Eventi" name="tipologia_Eventi" style="width: 100%;">
								<c:forEach  items="${tipologia}" var="tipoEvento" varStatus="status">
									<option value="${tipoEvento.id}">${tipoEvento.nome}</option>
								</c:forEach>
								</select>
							<input type="submit" value="Invia"/>
							</form:form>	
							</div>
						</c:when>
						<c:otherwise>
							<div class="tab-content" id="tab-base">
							<form:form action="${pageContext.request.contextPath}/BackStage/updateEvento" 
								   method="POST" 
								   class="form contact-form"
								   commandName="eventoMod">
								   <a href="${pageContext.request.contextPath}/BackStage/newEvent" class="btn small">Aggiungi Nuovo Evento</a>
								<h2>Modifica Evento</h2>
								<label for="nome">Nome Evento</label> 
								<form:input path="nome" value="${eventoMod.nome }"/>
								
								<label for="locale">Locale</label>
								<form:input path="locale" value="${eventoMod.locale}"/>
								
								<label for="descrizione">Descrizione</label> 
								<form:textarea path="descrizione" value="${eventoMod.descrizione}"/>
									
								<label for="dataEvento">Data</label> 
								<form:input path="dataEvento" value="${eventoMod.dataEvento }"/>
								
									
								<label for="orarioInizio">Ora Inizio</label> 
								<form:input path="orarioInizio" value="${eventoMod.orarioInizio }"/>
								
								<label for="orarioFine">Ora Fine</label> 
								<form:input path="orarioFine" value="${eventoMod.orarioFine }"/>
								
								<label for="prezzo">Prezzo</label> 
								<form:input path="prezzo" value="${eventoMod.prezzo }"/>
								
								<select id="tipologia_Eventi" name="tipologia_Eventi" style="width: 100%;">
								<c:forEach  items="${tipologia}" var="tipoEvento" varStatus="status">
									<c:choose>
									<c:when test="${tipoEvento.id == eventoMod.tipologia_Eventi}">
										<option selected="selected" value="${tipoEvento.id}">${tipoEvento.nome}</option>
									</c:when>
									<c:otherwise>
										<option value="${tipoEvento.id}">${tipoEvento.nome}</option>
									</c:otherwise>
									</c:choose>
									
									
								</c:forEach>
								</select>
								<input type="hidden" name="idEvento" id="idEvento" value="${idEvento}"/>
							<input type="submit" value="Invia"/>
							</form:form>	
							</div>
						</c:otherwise>
						</c:choose>
						<!-- /tabs navigation -->
						<script>
						$(document).ready(function(){
							$( "#locale" ).autocomplete({
								source: '${pageContext. request. contextPath}/BackStage/get_locals_list',
								paramName: "term",
								delimiter: ",",
								transformResult: function(response) {
									 
									return {      	
									  //must convert json to javascript object before process
									  suggestions: $.map($.parseJSON(response), function(item) {
							 
									      return { value: item.nomeLocale, data: item.id };
									   })
							 
									 };
							 
							            }
							 
							});
							$(function() {    
								$( "#dataEvento" ).datepicker();
								$('#orarioInizio').timepicker();
								$('#orarioFine').timepicker();
							});
						});
						</script>

							
						
							
							<div class="tab-content" id="tab-list-eventi">
								<h2>I miei Eventi</h2>
								
								<!-- Events table -->
            <table class="layout display responsive-table">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th >Evento</th>
                        <th >Stato</th>
                        <th >Operazioni</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${eventi}" var="evento" varStatus="status">
                	<tr>
                        <td class="table-date">${evento.data}</td>
                        <td class="table-name">
                        ${evento.nome}
                        <p>@<a class="event-location" href="${pageContext.request.contextPath}/Local/${evento.locale.id}">${evento.locale.nomeLocale}</a></p>
                        <p>In<a href="#" class="event-location">${evento.luogo}</a></p></td>
                        <td class="table-date">
                        <c:choose>
                        <c:when test="${evento.status == 11}">
                        Ok
                        </c:when>
                        <c:when test="${evento.status == 12}">
                        Hai Rifiutato la proposta di ${evento.locale.nomeLocale }
                        </c:when>
                        <c:otherwise>
                        <a href="${pageContext.request.contextPath}/messages/">Hai una richiesta di Evento</a></br>
						<a href="${pageContext.request.contextPath}/BackStage/accettaEvento/${evento.id}">Accetta Proposta</a></br>
						<a href="${pageContext.request.contextPath}/BackStage/rifiutaEvento/${evento.id}">Rifiuta Proposta</a>
                        </c:otherwise>
                        </c:choose>
                        </td>
                        <td class="actions">
                        	
                            <a href="${pageContext.request.contextPath}/BackStage/EventoModifica/${evento.id}" class="buy-tickets" title="Buy Tickets">Modifica</a>
                        </td>
                    </tr>
                </c:forEach>
                    
                </tbody>
            </table>
            <!-- /events table --> 
								
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
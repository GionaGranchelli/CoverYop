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
						<a class="btn small dark"
							href="${pageContext.request.contextPath}/Privee/"> <i
							class="icon icon-music"></i> Profilo Locale
						</a> <a class="btn small dark"
							href="${pageContext.request.contextPath}/Privee/Utente"> <i
							class="icon icon-user"></i> Profilo Utente
						</a> <a class="btn small dark"
							href="${pageContext.request.contextPath}/Privee/Multimedia">
							<i class="icon icon-images"></i> Foto e Video
						</a>
						<%-- <a class="btn small dark" href="${pageContext.request.contextPath}/BackStage/Tour">
							<i class="icon icon-yelp"></i> 
							Crea Tour
						</a> --%>
						<a class="btn small dark" id="attuale"
							href="${pageContext.request.contextPath}/Privee/Eventi"> <i
							class="icon icon-dribbble"></i> Gestione Eventi
						</a>
					</div>
				</div>
				<c:if test="${evento.id != 0}">
					<div class="widget details-widget">
						<div class="details-meta">
							<h2>Foto Scelta</h2>
							<img alt="Foto Scelta" src="${pageContext.request.contextPath}/Event/image.html?id=${evento.id}">
					</div>
				</div>
				</c:if>
				
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
						<div class="tab-content" id="tab-base">
							<form:form
								action="${pageContext.request.contextPath}/${requestScope.action}"
								method="POST" class="form contact-form" modelAttribute="evento"
								enctype="multipart/form-data">
								<form:hidden path="status"/>
								<form:hidden path="id"/>
								
								<h2>Aggiungi Evento</h2>
								<label for="nome">Nome Evento</label>
								<form:input path="nome" />

								<label for="luogo">Dove</label>
								<form:input path="luogo" />
								
								
								<label for="nomeGruppo">Gruppo</label>
								<input type="text" id="nomeGruppo" name="nomeGruppo"  value="${nomeGruppo}"/>

								<label for="descrizione">Descrizione</label>
								<form:input path="descrizione" />

								<label for="data">Data</label>
								<form:input path="data" />

								<label for="immagine">Inserisci Locandina</label>
								<input type="file" name="immagine" />

								<label for="orarioInizio">Ora Inizio</label>
								<form:input path="orarioInizio" />

								<label for="orarioFine">Ora Fine</label>
								<form:input path="orarioFine" />

								<label for="prezzo">Prezzo</label>
								<form:input path="prezzo" />

								<label for="tipologia_Eventi">Tipologia Evento</label>
								<form:select path="tipologia_Eventi.id" items="${tipologia}"
									itemLabel="nome" itemValue="id" />

								<input type="submit" value="Invia" />
							</form:form>
						</div>

						<!-- /tabs navigation -->
						<script>
							$(document)
									.ready(
											function() {
												$("#nomeGruppo")
														.autocomplete(
																{
																	source : '${pageContext. request. contextPath}/Privee/get_groups_list',
																	paramName : "term",
																	delimiter : ",",
																	transformResult : function(
																			response) {
																		return {
																			//must convert json to javascript object before process
																			suggestions : $
																					.map(
																							$
																									.parseJSON(response),
																							function(
																									item) {
																								return {
																									value : item.nomeGruppo,
																									data : item.id
																								};
																							})
																		};
																	}
																});
												$(function() {
													$("#data").datepicker();
													$('#orarioInizio')
															.timepicker();
													$('#orarioFine')
															.timepicker();
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
										<th>Evento</th>
										<th>Stato</th>
										<th>Operazioni</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${eventi}" var="evento" varStatus="status">
										<tr>
											<td class="table-date">${evento.data}</td>
											<td class="table-name">${evento.nome}
											<c:forEach items="${evento.gruppo}" var="group" varStatus="status">
													<a class="event-location" href="${pageContext.request.contextPath}/Group/${group.id}">${group.nomeGruppo}</a>
											</c:forEach>
											<td class="table-date">
											<c:choose>
												<c:when test="${evento.status == 11}"> Ok | 
													<a href="${pageContext.request.contextPath}/Privee/cancelEvent/${evento.id}">Annulla</a>
												</c:when>
												<c:otherwise> Attesa |
												<a href="${pageContext.request.contextPath}/Privee/activateEvent/${evento.id}">Attiva</a>
												</c:otherwise>
											</c:choose>
											</td>
											<td class="actions">
											<a href="${pageContext.request.contextPath}/Privee/EventoModifica/${evento.id}" class="buy-tickets" title="Modifica Evento">Modifica</a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
							<!-- /events table -->
					</div>
				</div>

				</article>
				<!-- /article -->
			</div>
			<!-- /main -->
		</div>
		<!-- /container -->
	</section>
	<!-- /Content -->

</section>
<!-- /page -->
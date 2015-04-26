<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<section id="page" data-title="Noisa - Events Grid">

	<!-- ############################# Intro ############################# -->
	<section class="intro-title section border-bottom" style="background-image: url(placeholders/events-bg.jpg)">
		<h1 class="heading-l">Upcoming <span class="color">Events</span></h1>
	</section>
	<!-- /intro -->
	
		<section class="countdown section">
		<div class="container">


<h4 class="response-title">Cerca il tuo Evento</h4>
<h5>Let Us Help You</h5>
			<!-- response form -->
	        <form  method="get" action="${pageContext.request.contextPath}/Events" class="form response-form">
	        	<div class="row clearfix">
	 				<div class="col-1-3">
	 					<label for="response-name"><strong>Per Nome</strong></label>
						<input type="text" name="nome" value="" id="response-name" >
	 				</div>
	 				<div class="col-1-3">
	 					<label for="response-email"><strong>Per Tipologia</strong></label>
						<input type="text" name="tipologia" value="" id="response-email" >
	 				</div>
	 				<div class="col-1-3 last">
	 					<label for="response-www"><strong>Per Città</strong></label>
						<input type="text" name="luogo" value="" id="response-www">
	 				</div>
	        	</div>
				<input type="submit" value="Submit Comment" class="large invert">
				<div class="clear"></div>
	        </form>
			<!-- /countdown -->
		</div>
	</section>

	<!-- ############################# Content ############################# -->
	<section class="content section">
		<!-- container -->
		<div class="container">

			<!-- Filters -->
			<div class="row clearfix filters" data-id="events">
				
				<!-- Genres -->
				<select class='nice-select filter' name="genres">
					<option value="placeholder">All Genres</option>
					<option value="*">All Genres</option>
					<c:forEach items="${tipologia}" var="tipologia">
						<option value="${tipologia.nome}">${tipologia.nome}</option>
					</c:forEach>
				</select>
				
			<%-- <!-- Artists -->
			<select class='nice-select filter' name="artists">
					<option value="placeholder">All Artist</option>
					<option value="*">All Artist</option>
					<c:forEach items="${gruppi}" var="gruppi">
						<option value="${gruppi.nomeGruppo}">${gruppi.nomeGruppo}</option>
					</c:forEach>
				</select>

				<!-- locations -->
				<select class='nice-select filter' name="locations">
					<option value="placeholder">All Locations</option>
					<option value="*">All locations</option>
					<c:forEach items="${gruppi}" var="citta">
						<option value="${citta.getCitta()}">${citta.getCitta()}</option>
					</c:forEach>
				</select> --%>
			</div>
			<!-- /filters -->
			<!-- Events Grid -->

			<!-- Events -->
			<div id="events" class="masonry events-grid clearfix">
				<c:forEach  items="${eventi}" var="evento" varStatus="status">
										
									
					<div class="col-1-4 item event" data-genres="${evento.tipologia_Eventi.nome}"
													<%-- data-artists="<c:forEach  items="${evento.getGruppo()}" var="gruppi">${gruppi.nomeGruppo} </c:forEach>"
													data-locations="${evento.luogo}" --%>								
													>
														
						<a href="${pageContext.request.contextPath}/Events/${evento.id}">
							<span class="event-meta">
								<span class="event-location"><span class="color">@ ${evento.locale.nomeLocale}</span> / ${evento.luogo}</span>
								<span class="event-date">${evento.data}</span>
								<span class="event-title">${evento.nome}</span>
								<c:forEach  items="${evento.gruppo}" var="gruppi" varStatus="status">
									<span class="event-artists">${gruppi.nomeGruppo}</span>
								</c:forEach>
							</span>
							<%-- <img src="${pageContext.request.contextPath}/resources/img/events/${evento.id}/${evento.locandina}" alt="Event Background"> --%>
							<%-- <img src="data:image/jpeg; base64, +${evento.locandinaBlob}+"  alt="Event Background"> --%>
							<img src="${pageContext.request.contextPath}/Event/image.html?id=${evento.id}"  alt="Event Background">
							
							
						</a>
					</div>
				
					<c:if test="${!status.last}"></c:if>
				</c:forEach>
				
				<%-- <div class="col-1-4 item event" data-genres="breakbeat" data-artists="dj-nando" data-locations="london">
					<a href="#!/pages/event-single-disqus">
						<span class="event-meta">
							<span class="event-location"><span class="color">FRI</span> / London, UK</span>
							<span class="event-date">${eventi[1].data}</span>
							<span class="event-title">${eventi[1].nome}</span>
							<span class="event-artists">DJ Nando</span>
						</span>
						<img src="${pageContext.request.contextPath}/resources/img/events/${eventi[1].id}/${eventi[1].locandina}" alt="Event Background">
					</a>
				</div>

				<div class="col-1-4 item event" data-genres="drum-and-bass breakbeat" data-artists="obiekt-zero dj-john-doe general-midi" data-locations="budapest">
					<a href="#!/pages/event-single-disqus">
						<span class="event-meta">
							<span class="event-location"><span class="color">FRI</span> / Budapest, Hungary</span>
							<span class="event-date">03/26</span>
							<span class="event-title">Bacardi Original Bar</span>
							<span class="event-artists">Obiekt ZERO, DJ John Doe, General Midi</span>
						</span>
						<img src="${pageContext.request.contextPath}/resources/placeholders/event03.jpg" alt="Event Background">
					</a>
				</div>

				<div class="col-1-4 item event" data-genres="glitch uk-funky" data-artists="various-artists" data-locations="amsterdam">
					<a href="#!/pages/event-single-disqus">
						<span class="event-meta">
							<span class="event-location"><span class="color">FRI</span> Amsterdam, Netherlands</span>
							<span class="event-date">04/21</span>
							<span class="event-title">Escape</span>
							<span class="event-artists">VA Various Artists</span>
						</span>
						<img src="${pageContext.request.contextPath}/resources/placeholders/event04.jpg" alt="Event Background">
					</a>
				</div>

				<div class="col-1-4 item event" data-genres="uk-funky dubstep" data-artists="dj-john-doe noisa" data-locations="santa-cruz">
					<a href="#!/pages/event-single-disqus">
						<span class="event-meta">
							<span class="event-location"><span class="color">FRI</span> / Santa Cruz De Tenerife, Spain</span>
							<span class="event-date">04/30</span>
							<span class="event-title">Papagayo Beach Club</span>
							<span class="event-artists">NOISA, DJ John Doe</span>
						</span>
						<img src="${pageContext.request.contextPath}/resources/placeholders/event05.jpg" alt="Event Background">
					</a>
				</div>

				<div class="col-1-4 item event" data-genres="drum-and-bass" data-artists="dj-nando obiekt-zero" data-locations="warsaw">
					<a href="#!/pages/event-single-disqus">
						<span class="event-meta">
							<span class="event-location"><span class="color">FRI</span> / Warsaw, PL</span>
							<span class="event-date">05/12</span>
							<span class="event-title">Heineken Music Hall</span>
							<span class="event-artists">DJ Nando, Obiekt ZERO</span>
						</span>
						<img src="${pageContext.request.contextPath}/resources/placeholders/event01.jpg" alt="Event Background">
					</a>
				</div>

				<div class="col-1-4 item event" data-genres="glitch uk-funky" data-artists="obiekt-zero" data-locations="london">
					<a href="#!/pages/event-single-disqus">
						<span class="event-meta">
							<span class="event-location"><span class="color">FRI</span> / London, UK</span>
							<span class="event-date">06/03</span>
							<span class="event-title">Luxorlive</span>
							<span class="event-artists">Obiekt ZERO</span>
						</span>
						<img src="${pageContext.request.contextPath}/resources/placeholders/event02.jpg" alt="Event Background">
					</a>
				</div>

				<div class="col-1-4 item event" data-genres="breakbeat dubstep" data-artists="dj-nando noisa general-midi" data-locations="budapest">
					<a href="#!/pages/event-single-disqus">
						<span class="event-meta">
							<span class="event-location"><span class="color">FRI</span> / Budapest, Hungary</span>
							<span class="event-date">07/27</span>
							<span class="event-title">Bacardi Original Bar</span>
							<span class="event-artists">NOISA, DJ Nando, General Midi</span>
						</span>
						<img src="${pageContext.request.contextPath}/resources/placeholders/event03.jpg" alt="Event Background">
					</a>
				</div> --%>

			</div>
			<!-- /Events -->
		
		</div>
		<!-- /container -->
	</section>
	<!-- /Content -->

</section>
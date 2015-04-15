<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- ############################# Ajax Page Container ############################# -->
<section id="page" data-title="Event - Single">

	<!-- ############################# Intro ############################# -->
	<section class="intro-title section border-bottom" style="background-image: url(${pageContext.request.contextPath}/resources/placeholders/revoslider/slide01-bg.jpg)">
																						
		<h2 class="heading-l event-heading">${evento.nome} <span class="event-date">${evento.data}</span></h2>
		<!-- Overlay -->
		<!-- <span class="overlay dots"></span> -->
	</section>
	<!-- /intro -->

	<!-- ############################# Content ############################# -->
	<section class="content section">
		<!-- container -->
		<div class="container">

			<!-- ############################# Single Release ############################# -->
			<!-- Sidebar -->
			<div class="sidebar main-left main-medium">
				<!-- Widgets -->
				<!-- Details widget -->
				<div class="widget details-widget">
					<!-- Countdown -->
					<div class="details-countdown">
						<!-- countdown -->
						<div class="countdown-wrap" data-event-date="${evento.data} ${evento.orarioInizio}">
							<div class="days" data-label="Days">000</div>
							<div class="hours" data-label="Hours">00</div>
							<div class="minutes" data-label="Minutes">00</div>
							<div class="seconds" data-label="Seconds">00</div>
						</div>
						<!-- /countdown -->
					</div>
					<!-- /countdown -->
					<div class="details-meta">
					
					<h2>Location Map</h2>
					<div id="location-map" class="gmap map" data-address="${evento.luogo}" data-zoom="17" data-zoom_control="true" data-scrollwheel="false"></div>
					
					</div>
					<div class="details-meta">
						<!-- Details list -->
						<ul class="details-list">
							<li>
								<span class="label">Nome Evento</span>
								<div class="data"><b>${evento.nome}</b></div>
							</li>
							<li>
								<span class="label">Luogo</span>
								<div class="data"><b>${evento.locale.nomeLocale}</b></div>
							</li>
							<li>
								<span class="label">Artisti</span>
								<div class="data">
									<c:forEach  items="${gruppi}" var="gruppi" varStatus="status">
										<a href="${pageContext.request.contextPath}/Group/${gruppi.id}"> ${gruppi.nomeGruppo} </a>
									<c:if test="${!status.last}">/</c:if>
									</c:forEach>
								</div>
							</li>
							
							<li>
								<span class="label">Genere</span>
								<div class="data">${evento.tipologia_Eventi.nome}</div>
							</li>
							<li>
								<span class="label">Data</span>
								<div class="data">${evento.data} </div>
							</li>
							<li>
								<span class="label">Orario Inizio</span>
								<div class="data">${evento.orarioInizio}</div>
							</li>
							<li>
								<span class="label">Orario Fine</span>
								<div class="data">${evento.orarioFine}</div>
							</li>
							
							<li>
								<span class="label">Indirizzo</span>
								<div class="data">${evento.luogo}</div>
							</li>
							<li>
								<span class="label">Prezzo</span>
								<div class="data">${evento.prezzo} </div>
							</li>
						</ul>
					</div>
					<!-- Details Share -->
					<div class="details-social-box">
						<a href="javascript:;" class="facebook-share"><i class="icon icon-facebook"></i></a>
						<a href="javascript:;" class="twitter-share"><i class="icon icon-twitter"></i></a>
						<a href="javascript:;" class="googleplus-share"><i class="icon icon-googleplus"></i></a>
					</div>
				</div>

			
			</div>
			<!-- /sidebar -->

			<!-- Main -->
			<div id="main" class="release main-left main-medium">

				<!-- Article -->
				<article>
				<!-- 	<!-- Carousel slider
					<div id="blog-slider01" class="carousel-slider" data-effect="fadeUp" data-pagination="true" data-nav="true">
						Slide
						<div class="slide">
							<img src="placeholders/blog-entry-img04.jpg" alt="Event Image">
						</div>
						/slide
						Slide
						<div class="slide">
							<img src="placeholders/blog-entry-img01.jpg" alt="Event Image">
						</div>
						/slide
						Slide
						<div class="slide">
							<img src="placeholders/blog-entry-img02.jpg" alt="Event Image">
						</div>
						/slide
					</div>
					/Carousel slider -->
					
					<div class="">
					<img src="${pageContext.request.contextPath}/resources/img/events/${evento.id}/${evento.locandina}" alt="Event Image">
					</div>
					<br>
					<h2>Description</h2>
					<p>
						${evento.descrizione}
					</p>
					
					<br>
					<h2>Lineup</h2>
					<ul class="lineup">
					
									
						<c:forEach  items="${gruppi}" var="gruppi" varStatus="status">			
						<li>
							<div class="lineup-time"> </div>
							<div class="lineup-artist"><a href="${pageContext.request.contextPath}/Group/${gruppi.id}"> ${gruppi.nomeGruppo} </a></div>
						</li>
						</c:forEach>

					</ul>

					<br>

				</article>
				<!-- /article -->

			</div>
			<!-- /main -->
		</div>
		<!-- /container -->
	</section>
	<!-- /Content -->

	 <!-- ############################# Comment section ############################# -->
	<!--<section class="comments-section section border-top">
		container
		<div class="container">

			<h4 class="comments-title">Comments:</h4>		
			Comments list

			Comments list
			<ol class="comments-list">

				Comment
				<li class="comment">
					<article>
						<div class="avatar">
							<img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=50" alt="Image">
						</div>
						<div class="comment-meta">
							<h5 class="author"><a href="#">John Themeforest</a></h5>
							<p class="date">October 11, 2012</p>
						</div>
						<div class="comment-body">
							<p>Pellentesque sollicitudin, magna ac ullamcorper interdum, purus urna condimentum ligula, sed volutpat erat felis a lectus. Sed et consectetur nisi. In consectetur turpis in quam rutrum tempor.</p>
						</div>
					</article>
					Children comments
					<ul class="children">
						<li class="comment">
							<article>
								<div class="avatar">
									<img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=50" alt="Image">
								</div>
								<div class="comment-meta">
									<h5 class="author"><a href="#">John Themeforest</a></h5>
									<p class="date">October 11, 2012</p>
								</div>
								<div class="comment-body">
									<p>Pellentesque sollicitudin, magna ac ullamcorper interdum, purus urna condimentum ligula, sed volutpat erat felis a lectus. Sed et consectetur nisi. In consectetur turpis in quam rutrum tempor.</p>
								</div>
							</article>
						</li>
					</ul>
					Children comments
				</li>
				/Comment
				Comment
				<li class="comment">
					<article>
						<div class="avatar">
							<img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=50" alt="Image">
						</div>
						<div class="comment-meta">
							<h5 class="author"><a href="#">John Themeforest</a></h5>
							<p class="date">October 11, 2012</p>
						</div>
						<div class="comment-body">
							<p>Pellentesque sollicitudin, magna ac ullamcorper interdum, purus urna condimentum ligula, sed volutpat erat felis a lectus. Sed et consectetur nisi. In consectetur turpis in quam rutrum tempor.</p>
						</div>
					</article>
				</li>
				/Comment
				Comment
				<li class="comment">
					<article>
						<div class="avatar">
							<img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=50" alt="Image">
						</div>
						<div class="comment-meta">
							<h5 class="author"><a href="#">John Themeforest</a></h5>
							<p class="date">October 11, 2012</p>
						</div>
						<div class="comment-body">
							<p>Pellentesque sollicitudin, magna ac ullamcorper interdum, purus urna condimentum ligula, sed volutpat erat felis a lectus. Sed et consectetur nisi. In consectetur turpis in quam rutrum tempor.</p>
						</div>
					</article>
				</li>
				/Comment
			</ol>
			/Comments list

			
			<h4 class="response-title">Post New Comment:</h4>
			response form
	        <form method="post" class="form response-form">
	        	<div class="row clearfix">
	 				<div class="col-1-3">
	 					<label for="response-name"><strong>Name</strong> (required)</label>
						<input type="text" name="name" value="" id="response-name" required>
	 				</div>
	 				<div class="col-1-3">
	 					<label for="response-email"><strong>Email</strong> (required)</label>
						<input type="email" name="email" value="" id="response-email" required>
	 				</div>
	 				<div class="col-1-3 last">
	 					<label for="response-www"><strong>Webiste</strong> (WWW)</label>
						<input type="text" name="subject" value="" id="response-www">
	 				</div>
	        	</div>
	        	<div class="row clearfix">
	        		<div class="col-1-1">
	        			<label for="response-comment"><strong>Comment</strong> (required)</label>
						<textarea name="comment" id="response-comment" cols="88" rows="6" required></textarea>
					</div>
	        	</div>
				<input type="submit" value="Submit Comment" class="large invert">
				<div class="clear"></div>
	        </form>
	        /response form
		</div>	
		/container
	</section>
	/section

</section> -->
<!-- /page -->
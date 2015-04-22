<jsp:declaration></jsp:declaration><%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="main-nav">

		<!-- ############ search ############ -->
		<div id="search-wrap">
			<div class="container">
				<input type="text" placeholder="Search and hit enter..." name="s" id="search" />
				<span id="close-search"><i class="icon icon-close"></i></span>
			</div>
		</div>
		<!-- /search -->

		<!-- navigation container -->
	   	<div class="container">

		   	<!-- ############ logo ############ -->
		   	<a href="${pageContext.request.contextPath}/" id="logo">
		   		<img src="${pageContext.request.contextPath}/resources/placeholders/logo.png" alt="Logo">
		   	</a>
		   	<!-- /logo -->

		   	<!-- ############ icon navigation ############ -->
			<nav id="icon-nav">
				<ul>
				<security:authorize access="isAuthenticated()">	
							<li><a href="${pageContext.request.contextPath}/messages/"><span class="icon icon-envelope"></span></a></li>
					</security:authorize>
				
					<li><a href="${pageContext.request.contextPath}/Search" id="nav-search" class="external"><span class="icon icon-search"></span></a></li>
<!-- 					<li> -->
<!-- 						<a href="" id="nav-search" class="external"><span class="icon icon-user"> </span></a> -->
<!-- 					</li> -->
				</ul>
			</nav>
			<!-- /icon navigation -->

			<!-- ############ navigation ############  class="submenu"-->
			<nav id="nav">
				<ul>
					<li >
						<a href="${pageContext.request.contextPath}/">Home</a>
						<!-- <ul>
							<li>
								<a href="#!/home">Home 1 (Video)</a>
							</li>
							<li>
								<a href="#!/pages/home-2">Home 2 (Full Image)</a>
							</li>
							<li>
								<a href="#!/pages/home-3">Home 3 (RevoSlider)</a>
							</li>
						</ul> -->
					</li>
					
					<li > 
                		<a href="${pageContext.request.contextPath}/HowitWorks">Come Funziona</a>
                        <!-- <ul>
                        	<li>
                            	<a href="#!/pages/elements">Elements</a>
                            </li>
                        	<li>
                            	<a href="#!/pages/grid">Grid</a>
                            </li>
                            <li>
                            	<a href="#!/pages/about">About US</a>
                            </li>
                            <li>
                            	<a href="#!/pages/gallery">Gallery</a>
                            </li>
                            <li>
                            	<a href="#!/pages/gallery-single">Gallery Single Album</a>
                            </li>
                            <li>
                            	<a href="#!/pages/videos">Videos</a>
                            </li>
                            <li class="submenu">
                            	<a href="javascript:;">Sub Menu</a>
                            	<ul>
                            		<li>
                            			<a href="javascript:;">Level 2.1</a>
                            		</li>
                            		<li>
                            			<a href="javascript:;">Level 2.2</a>
                            		</li>
                            		<li>
                            			<a href="javascript:;">Level 2.3</a>
                            		</li>
                            	</ul>
                            </li>
                        </ul> -->           
                    </li>
                    <li >
						<a href="${pageContext.request.contextPath}/ContactUs">Chi Siamo</a>
						<!-- <ul>
							<li>
								<a href="#!/pages/releases">Releases 4 Columns</a>
							</li>
							<li>
								<a href="#!/pages/releases-3-columns">Releases 3 Columns</a>
							</li>
							<li>
								<a href="#!/pages/releases-fullwidth">Releases Fullwidth</a>
							</li>
							<li>
								<a href="#!/pages/release-single">Single Release</a>
							</li>
						</ul> -->
					</li>
					<li >
						<a href="${pageContext.request.contextPath}/Groups">Gruppi</a>
						<!-- <ul>
							<li>
								<a href="#!/pages/events-grid">Events Grid</a>
							</li>
							<li>
								<a href="#!/pages/events-list">Events List</a>
							</li>
							<li>
								<a href="#!/pages/events-table">Events Table</a>
							</li>
							<li>
								<a href="#!/pages/event-single">Single Event</a>
							</li>
							<li>
								<a href="#!/pages/event-single-disqus">Single Event (DISQUS)</a>

							</li>
							<li>
								<a href="#!/pages/event-single-past">Past Single Event (DISQUS)</a>
							</li>
							<li>
								<a href="#!/pages/event-single-past-2">Past Single Event (DISQUS) 2</a>
							</li>
						</ul> -->
					</li>
					<li >
						<a href="${pageContext.request.contextPath}/Locals">Locali</a>
						<!-- <ul>
							<li>
								<a href="#!/pages/artists">Artists Grid</a>
							</li>
							<li>
								<a href="#!/pages/artist-single">Single Artist</a>
							</li>
						</ul> -->
					</li>
					<li >
						<a href="${pageContext.request.contextPath}/Events">Eventi</a>
						<!-- <ul>
							<li>
								<a href="#!/pages/artists">Artists Grid</a>
							</li>
							<li>
								<a href="#!/pages/artist-single">Single Artist</a>
							</li>
						</ul> -->
					</li>
					<security:authorize access="!isAuthenticated()">
					<li id="accedi" >
						<a id="login-menu" href="${pageContext.request.contextPath}/Login">Login</a>
						
					</li>
					</security:authorize>
					<security:authorize access="isAuthenticated()"> 
					<li> 
							<a href="${pageContext.request.contextPath}/j_spring_security_logout"> Logout </a>
					</li> 
     				</security:authorize>
     				<li>
					<security:authorize access="!isAuthenticated()">	
						<a href="${pageContext.request.contextPath}/Signup">Registrati</a>
					</security:authorize>
					<security:authorize access="hasAnyRole('group')">
						<a href="${pageContext.request.contextPath}/BackStage/ "><strong>BackStage</strong></a>
					</security:authorize>
					<security:authorize access="hasAnyRole('local')">
						<a href="${pageContext.request.contextPath}/Privee/"><strong>Privee</strong></a>
					</security:authorize>	
					</li>
				</ul>
			</nav>
			<!-- /navigation -->

			<!-- responsive navigation -->
			<div id="dl-menu" class="dl-menuwrapper one-page-nav">
				<button class="dl-trigger">Open Menu</button>
				<!-- RESPONSIVE NAVIGATION HERE -->
			</div>
			<!-- /responsive navigation -->
	   	</div>
	   	<!-- /navigation container -->
	</div>
	<!-- /main navigation -->
</section>


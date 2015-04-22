<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- ############################# Ajax Page Container ############################# -->
<section id="page" data-title="Login in Yop!">
	<!-- ############################# Intro ############################# -->
	<section class="intro-title section border-bottom" style="background-image: url(${pageContext.request.contextPath}/resources/placeholders/about-bg.jpg)">
		<h1 class="heading-l">Come Funziona</h1>
		<h2 class="heading-m">Giusto due parole su <span class="color">Yop!</span></h2>
		<!-- Overlay -->
		<span class="overlay dots"></span>
	</section>
	<!-- /intro -->

	<!-- ############################# Content ############################# -->
	<section class="content section">
		<!-- container -->
		<div class="container">

			<!-- ############################# About US ############################# -->

			<!-- Article -->
			<article>
				<div class="col-1-3"></div>
				<div class="col-1-3">
					<h1>Accedi a Yop!</h1>
					<div class="login-sovra" id="login-sovraimpressione">
						<form action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
							<input type="text" name="j_username" placeholder="Username" />
							<input type="password" name="j_password" placeholder="Password" /></br>
							<input type="submit" value="Yop!" />
						</form>
					</div>
				</div>
				<div class="col-1-3"></div>
			</article>
		</div>
	</section>
</section>
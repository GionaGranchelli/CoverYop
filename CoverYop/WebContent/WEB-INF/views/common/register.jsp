<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<section class="comments-section section border-top">
		<section style="background-image: url(/placeholders/blog-bg.jpg)" class="intro-title section border-bottom">
		<h1 class="heading-l">Iscriviti a Yop!</h1>
		<!-- Overlay -->
		<span class="overlay animated-noise"></span>
		</section>
		<div class="container">
			<div class="row">
                
                <div class="info-box">
                    <p class="text-center">Puoi iscriverti come Gruppo Musicale/CoverBand o come Locale.</p>
                    <p class="text-center">
	                    <a class="btn large invert" id="group-singup" href="javascript:;">Gruppo Musicale</a>
	                    <a class="btn large invert" id="local-singup"  href="javascript:;">Locale</a>
                    </p>
                </div>
                <div id="group-form" style="display:none;">
                	<!-- multistep form -->
					 <form:form name="form-gruppi"
								modelAttribute="formGruppi" 
								method="POST" 
								action="${pageContext.request.contextPath}/createGroup/" 
								id="msform">
								
						<!-- progressbar -->
						<ul id="progressbar">
							<li class="active">Gruppo Setup</li>
							<li>Dettagli Gruppo</li>
							<li>Personal Details</li>
						</ul>
						<!-- fieldsets -->
						<fieldset id="gruppi1">
							<h2 class="fs-title">Create il Tuo Account</h2>
							<h3 class="fs-subtitle">Primo Step</h3>
							<form:input path="nome"  placeholder="Nome" />
							<form:errors path="nome" cssClass="errorSignup" element="label"/>
							<form:input  path="cognome"   placeholder="Cognome" />
							<form:errors path="cognome" cssClass="errorSignup" element="label"/>
							<form:input  path="email"    placeholder="Email" />
							<form:errors path="email" cssClass="errorSignup" element="label"/>
							<form:input  path="username"   placeholder="Username" />
							<form:errors path="username" cssClass="errorSignup" element="label"/>
							
							<form:input  path="password"  type="password" placeholder="Password" />
							<form:errors path="password" cssClass="errorSignup" element="label"/>
							<form:input  path="retypePassword"  type="password" placeholder="Password" />
							<form:errors path="retypePassword" cssClass="errorSignup" element="label"/>
							<input type="button" name="next" class="next action-button" value="Next" />
						</fieldset>
						<fieldset id="gruppi2">
							<h2 class="fs-title">Dettagli Gruppo</h2>
							<h3 class="fs-subtitle">Aumenta le tue possibilità di successo</h3>
							<form:input path="nomeGruppo"  placeholder="Nome Del Gruppo" />
							<form:errors path="nomeGruppo" cssClass="errorSignup" element="label"/>
							<form:textarea path="biografia" placeholder="Biografia" />
							<form:errors path="biografia" cssClass="errorSignup" element="label"/>
							<form:input  path="telefono"  placeholder="Telefono" />	
							<form:errors path="telefono" cssClass="errorSignup" element="label"/>						
							<form:input  path="data" type="date" placeholder="Data di Nascita Del Gruppo" />
							<form:errors path="data" cssClass="errorSignup" element="label"/>
							<form:input  path="citta"  placeholder="Città"/>
							<form:errors path="citta" cssClass="errorSignup" element="label"/>
							<form:input  path="indirizzo" placeholder="Address"/>
							<form:errors path="indirizzo" cssClass="errorSignup" element="label"/>
							<!-- <p style="color: black;">Cover Band
 								<input type="checkbox" name="cover" id="cover_Band" placeholder="CoverBand" style="width:35%"/> 
 							<form:select disabled="false" name="coverbandName" path="gruppi_rif" id="coverbandname" items="${gruppiDiRif}" itemLabel="nome" itemValue="nome" />  -->
							<form:hidden path="id" />
							<form:hidden path="lat" />
							<form:hidden path="lng" />
							<form:hidden path="video" />
							<form:hidden path="albumFotografico" />
							<form:hidden path="canale" />
							<form:hidden path="ruolo" />
							<form:hidden path="cover_Band" />
							<form:hidden path="service" />
							<form:hidden path="cachet" />
							<form:hidden path="albums" />
							<form:hidden path="componente" />
							<form:hidden path="eventi" />
							<form:hidden path="generi" />
							<form:hidden path="tour" />
							<form:hidden path="gruppi_rif" />
							<form:hidden path="scaletta" />
							</p> 
							<input type="button" name="previous" class="previous action-button" value="Previous" />
							<input type="button" name="next" class="next action-button" value="Next" />
							
						</fieldset>
						<fieldset id="gruppi3">
							<h2 class="fs-title">Portafolio Social</h2>
							<h3 class="fs-subtitle">Qui tutti i tuoi social network</h3>
	 				<form:input path="canale.twitter"  placeholder="Twitter" />						
							<form:input  path="canale.facebook" placeholder="Facebook" />
							<form:input path="canale.googlePlus"  placeholder="Google Plus" />
							<form:input  path="canale.soundCloud"   placeholder="SoundCloud" />
							<form:input  path="canale.instagram" placeholder="Instagram" /> 
							<input type="button"  class="previous action-button" value="Previous" />
							<input type="submit"  class="action-button" value="Submit" />
						</fieldset>
					</form:form>
					
                </div>
                <div id="local-form" style="display:none;">
                	<!-- multistep form -->
					<form:form name="form-locali"
						  modelAttribute="formLocali" 	
						  method="POST" 
						  action="${pageContext.request.contextPath}/createLocale/" 
						  id="msform">
						<!-- progressbar -->
						<ul id="progressbar">
							<li class="active">Account Setup</li>
							<li>Social Profiles</li>
							<li>Personal Details</li>
						</ul>
						<!-- fieldsets -->
						<fieldset id="locali1">
							<h2 class="fs-title">Create il Tuo Account</h2>
							<h3 class="fs-subtitle">Primo Step</h3>
							<form:input  path="nome"  placeholder="Nome" />
							<form:errors path="nome" cssClass="errorSignup" element="label"/>
							<form:input  path="cognome"  placeholder="Cognome" />
							<form:errors path="cognome" cssClass="errorSignup" element="label"/>
							<form:input  path="username"   placeholder="Username" />
							<form:errors path="username" cssClass="errorSignup" element="label"/>
							<form:input  path="email"  placeholder="Email" />
							<form:errors path="email" cssClass="errorSignup" element="label"/>
							<form:input  path="password"  placeholder="Password" />
							<form:errors path="password" cssClass="errorSignup" element="label"/>
							<form:input  path="retypePassword"  type="password" placeholder="Password" />
							<form:errors path="retypePassword" cssClass="errorSignup" element="label"/>
							<input type="button" name="next" class="next action-button" value="Next" />
						</fieldset>
						<fieldset id="locali2">
							<h2 class="fs-title">Dettagli Locale</h2>
							<h3 class="fs-subtitle">Aumenta le tue possibilità di successo</h3>
							<form:input path="nomeLocale"  placeholder="Nome Locale" />
							<form:errors path="nomeLocale" cssClass="errorSignup" element="label"/>
							<form:textarea  path="descrizione"  placeholder="Descrizione" />
							<form:errors path="descrizione" cssClass="errorSignup" element="label"/>
							<form:input  path="telefono" placeholder="Telefono" />
							<form:errors path="telefono" cssClass="errorSignup" element="label"/>
							<form:input   path="orarioApertura"  placeholder="Orario Apertura" />
							<form:errors path="orarioApertura" cssClass="errorSignup" element="label"/>
							<form:input  path="orarioChiusura"  placeholder="Orario Chiusura" />
							<form:errors path="orarioChiusura" cssClass="errorSignup" element="label"/>
							<form:input  path="citta"  placeholder="Città"/>
							<form:errors path="citta" cssClass="errorSignup" element="label"/>
							<form:input  path="indirizzo"  placeholder="Indirizzo"/>
							<form:errors path="indirizzo" cssClass="errorSignup" element="label"/>
							<form:hidden path="id" />
							<form:hidden path="lat" />
							<form:hidden path="lng" />
							<form:hidden path="video" />
							<form:hidden path="albumFotografico" />
							<form:hidden path="canale" />
							<form:hidden path="ruolo" />
							<form:hidden path="service" />
							<form:hidden path="contatti" />
							<form:hidden path="eventi" />
							<form:hidden path="categoria" />
							<input type="button" name="previous" class="previous action-button" value="Previous" />
							<input type="button" name="next" class="next action-button" value="Next" />
							
						</fieldset>
						
						<fieldset id="gruppi3">
							<h2 class="fs-title">Portafolio Social</h2>
							<h3 class="fs-subtitle">Qui tutti i tuoi social network</h3>
 						<form:input type="text" path="canale.twitter" name="twitter" placeholder="Twitter" />						
							<form:input type="text" path="canale.facebook" name="facebook" placeholder="Facebook" /> 
							<form:input type="text" path="canale.googlePlus" name="gplus" placeholder="Google Plus" /> 
 							<form:input type="text" path="canale.soundCloud"  name="soundcloud" placeholder="SoundCloud" /> 
							<form:input type="text" path="canale.instagram" name="instagram" placeholder="Instagram" /> 
							<input type="button"  name="previous" class="previous action-button" value="Previous" />
							<input type="submit" name="submit" class="action-button" value="Submit" />
						</fieldset>
					</form:form>
                
                
                
                </div>
            </div>
			
			<div class="clear"></div>
		</div>	
		<!-- /container -->
	</section>
	
<!-- 					jQuery -->
<!-- 					<script src="http://thecodeplayer.com/uploads/js/jquery-1.9.1.min.js" type="text/javascript"></script> -->
<!-- 					jQuery easing plugin -->
<!-- 					<script src="http://thecodeplayer.com/uploads/js/jquery.easing.min.js" type="text/javascript"></script> -->
	<script>
		
	
	var update = function(){
		if ($('#cover').is(":checked")){
			$('#coverbandname').prop('disabled', false);
		}else{
			$('#coverbandname').prop('disabled', 'disabled');
		}
	};
	$(update);
	$('#cover').change(update);
	$('#group-singup').click(function(){
		  $('.info-box').hide();
		  $('#group-form').show( "slow" );

		});
	$('#local-singup').click(function(){
		  $('.info-box').hide();
		  $('#local-form').show( "slow" );

		});
	//jQuery time
	var current_fs, next_fs, previous_fs; //fieldsets
	var left, opacity, scale; //fieldset properties which we will animate
	var animating; //flag to prevent quick multi-click glitches

	var cErrorPage = function checkError(current_fs){
		var filedID = $('fieldset:visible').attr('id');
		
		 	} 
	
	$(".next").click(function(){
		if(animating) return false;
		animating = true;
		
		current_fs = $(this).parent();
		next_fs = $(this).parent().next();
		cErrorPage(current_fs);
		//activate next step on progressbar using the index of next_fs
		$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
		
		//show the next fieldset
		next_fs.show(); 
		//hide the current fieldset with style
		current_fs.animate({opacity: 0}, {
			step: function(now, mx) {
				//as the opacity of current_fs reduces to 0 - stored in "now"
				//1. scale current_fs down to 80%
				scale = 1 - (1 - now) * 0.2;
				//2. bring next_fs from the right(50%)
				left = (now * 50)+"%";
				//3. increase opacity of next_fs to 1 as it moves in
				opacity = 1 - now;
				current_fs.css({'transform': 'scale('+scale+')'});
				next_fs.css({'left': left, 'opacity': opacity});
			}, 
			duration: 800, 
			complete: function(){
				current_fs.hide();
				animating = false;
			}, 
			//this comes from the custom easing plugin
			easing: 'easeInOutBack'
		});
	});

	$(".previous").click(function(){
		if(animating) return false;
		animating = true;
		
		current_fs = $(this).parent();
		previous_fs = $(this).parent().prev();
		cErrorPage(current_fs);
		//de-activate current step on progressbar
		$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
		
		//show the previous fieldset
		previous_fs.show(); 
		//hide the current fieldset with style
		current_fs.animate({opacity: 0}, {
			step: function(now, mx) {
				//as the opacity of current_fs reduces to 0 - stored in "now"
				//1. scale previous_fs from 80% to 100%
				scale = 0.8 + (1 - now) * 0.2;
				//2. take current_fs to the right(50%) - from 0%
				left = ((1-now) * 50)+"%";
				//3. increase opacity of previous_fs to 1 as it moves in
				opacity = 1 - now;
				current_fs.css({'left': left});
				previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
			}, 
			duration: 800, 
			complete: function(){
				current_fs.hide();
				animating = false;
			}, 
			//this comes from the custom easing plugin
			easing: 'easeInOutBack'
		});
	});
	
	$(".submit").click(function(){
		return false;
	});
	
	
	$(document).ready(function() {
		$("#data").datepicker();
							});	
	
</script>






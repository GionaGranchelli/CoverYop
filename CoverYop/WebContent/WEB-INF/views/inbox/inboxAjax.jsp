<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
						$('#titles_id').dataTable(
										{"bProcessing" : true,
										 "bJQueryUI" : true,
										 "bServerSide" : true,
										 "sAjaxDataProp" : "rows",
										 "aoColumns" : [
													{"mData" : "id"},
													{"mData" : "titolo"},
													{"mData" : "destinatario.username", 
													 "sDefaultContent": ""},
													{"mData" : "data"},
													{"sName" : "id",
													 "bSearchable" : false,
													 "bSortable" : false,
													 "sDefaultContent" : "",
													 "fnRender" : function(oObj) {
													 
														 return "<a href='${pageContext.request.contextPath}/messages/conversation/"
																	+ oObj.aData['id']
																	+ "'>Leggi</a>"
																	+ " | "
																	+ "<a href='${pageContext.request.contextPath}/messages/conversation/delete/"
																	+ oObj.aData['id']
																	+ "'>Cancella</a>";

														}
													} ],
											"sAjaxSource" : "${pageContext.request.contextPath}/messages/findAllConversationPaginated.do",
											"fnServerParams" : addsortparams,
											"fnDrawCallback" : function( oSetting){
												getDateJJ();
												
											}
										})
						
					});
</script>



<!-- ############################# Intro ############################# -->
<section class="intro-title section border-bottom"
	style="background-image: url(placeholders/events-bg.jpg)">
	<h1 class="heading-l">
		Inbox <span class="color">Message</span>
	</h1>
</section>
<!-- /intro -->

<!-- ############################# Countdown ############################# -->
<section class="countdown section">
	<div class="container">
		<h5 class="countdown-title">Hai ${fn:length(conversation)}
			Conversazioni Inbox</h5>

	</div>
</section>
<!-- /countdown -->

<!-- ############################# Content ############################# -->
<section class="content section">
	<!-- container -->
	<div class="container">
		<div class="col-md-1"></div>
		<div class="col-md-9">
			<table id="titles_id" class="layout display responsive-table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Titolo</th>
						<th>Destinatario</th>
						<th>Data</th>
						<th>Azioni</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>


		<div class="col-md-2"></div>
		<hr class="divider">

						<h2>Invia Un Messaggio</h2>
						contact form

				        <div class="tabs-wrap">
				         <ul class="tabs">
		                            <li><a href="#tab-gruppo" class="active-tab">Contatta Un Gruppo</a></li>
		                            <li><a href="#tab-locale">Contatta Un Locale</a></li>
				       </ul>

				       <div id="tab-gruppo" class="tab-content">

				        <form action="${pageContext.request.contextPath}/messages/addconversationGroup/" 
		 		        	method="post" 
		 		        	class="form contact-form">
				        	<div class="row clearfix">

				 				<div class="col-1-3">
				 					<label for="contact-name"><strong>Nome Del Gruppo</strong> </label>
									<input type="text" name="destinatario"  id="idGruppo" required>
				 				</div>
				 				<div class="col-1-3">
				 						<label for="contact-www"><strong>Titolo</strong></label>
									<input type="text" name="titolo" id="titolo"></input>
				 				</div>
				 				<div class="col-1-3 last">

				 				</div>
				        	</div>
				        	<div class="row clearfix">
				        		<div class="col-1-1">
				        			<label for="contact-message"><strong>Testo</strong> </label>
									<textarea name="messaggio" id="messaggio1"></textarea>
								</div>
				        	</div>
							<input type="submit" value="Invia" class="large invert">
							<div class="clear"></div>
				        </form>
				</div>


				 <div id="tab-locale" class="tab-content">

				        <form action="${pageContext.request.contextPath}/messages/addconversationLocal/" 
		        			method="post" 
				        	class="form contact-form"> 
				        	<div class="row clearfix">
				 				<div class="col-1-3">
				 					<label for="contact-name"><strong>Nome Del Locale</strong> </label>
									<input type="text" name="destinatario"  id="idLocale" required/>
				 				</div>
				 				<div class="col-1-3">
				 						<label for="contact-www"><strong>Titolo</strong></label>
									<input type="text" name="titolo" id="titolo"/>
				 				</div>
				 				<div class="col-1-3 last">

				 				</div>
				        	</div>
				        	<div class="row clearfix">
				        		<div class="col-1-1">
				        			<label for="contact-message"><strong>Testo</strong> </label>
									<textarea name="messaggio" id="messaggio2" ></textarea>
								</div>
				        	</div>
							<input type="submit" value="Invia" class="large invert"/>
							<div class="clear"></div>
				        </form>
				</div>

				</div>
		</container>

	</div>

</section>
<script>

function timeConverter(UNIX_timestamp){
	  var a = new Date(UNIX_timestamp);
	  var months = ['Gen','Feb','Mar','Apr','Mag','Giu','Lug','Ago','Set','Ott','Nov','Dic'];
	  var year = a.getFullYear();
	  var month = months[a.getMonth()];
	  var date = a.getDate();
	  var hour = a.getHours();
	  var min = a.getMinutes();
	  var sec = a.getSeconds();
	  var time = date + ', ' + month + ' ' + year ;
	  return time;
	}
	function getDateJJ(){
		setTimeout(function (){
			$('table tr td:nth-child(4)').each(function( index ) {
 				  var qualcosa = parseInt($( this ).text());
 				  
 				 console.log("Ualcosa " + qualcosa);
				  $(this).empty();
				  $(this).append(timeConverter(qualcosa));
				});

			}, 1000);	
	}
	
</script>
<script>
	$(document).ready(function() {
						$("#idGruppo").autocomplete(
										{
											source : "${pageContext.request.contextPath}/messages/get_groups_list",
											paramName : "term",
											delimiter : ",",
											transformResult : function(response) {
											return {
													//must convert json to javascript object before process
													suggestions : $.map($.parseJSON(response),
																	function(dataItem) {
																		return {
																			value : dataItem.value,
																			data : dataItem.label
																		};
																	})

												};

											}

										});
					$("#idLocale").autocomplete(
										{
											source : "${pageContext.request.contextPath}/messages/get_locals_list",
											paramName : "term",
											delimiter : ",",
											transformResult : function(response) {
											return {
											//must convert json to javascript object before process
													suggestions : $.map($.parseJSON(response),
																	function(dataItem) {
																		return {
																			value : dataItem.value,
																			data : dataItem.label
																		};
																	})

												};

											}

										});
						
					});

	
		
	

</script>


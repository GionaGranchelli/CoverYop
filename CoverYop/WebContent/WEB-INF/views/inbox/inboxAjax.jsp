<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" charset="utf-8">
	$(document)
			.ready(
					function() {
						$('#titles_id')
								.dataTable(
										{
											"bProcessing" : true,
											"bJQueryUI" : true,
											"bServerSide" : true,
											"sAjaxDataProp" : "rows",
											"aoColumns" : [
													{
														"mData" : "id"
													},
													{
														"mData" : "name"
													},
													{
														"mData" : "author"
													},
													{
														"mData" : "titleKind.name",
														"sDefaultContent" : ""
													},
													{
														"sName" : "id",
														"bSearchable" : false,
														"bSortable" : false,
														"sDefaultContent" : "",
														"fnRender" : function(
																oObj) {
															return "<a href='${pageContext.request.contextPath}/titles/update_start.do?id="
																	+ oObj.aData['id']
																	+ "'>Modifica</a>"
																	+ " | "
																	+ "<a href='${pageContext.request.contextPath}/titles/delete_start.do?id="
																	+ oObj.aData['id']
																	+ "'>Cancella</a>";

														}
													} ],
											"sAjaxSource" : "${pageContext.request.contextPath}/titles/findAllTitlesPaginated.do",
											"oLanguage" : {
												"sUrl" : "${pageContext.request.contextPath}/resources/datatables/i18n/italian.properties"
											},
											"fnServerParams" : addsortparams
										});

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
			<table id="titles_id">
				<thead>
					<tr>
						<th>ID</th>
						<th><spring:message code="title.name" /></th>
						<th><spring:message code="title.author" /></th>
						<th><spring:message code="title.titleKind" /></th>
						<th><spring:message code="common.actions" /></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		<div class="col-md-2"></div>
		<hr class="divider">

		<!-- 				<h2>Invia Un Messaggio</h2> -->
		<!-- 				contact form -->

		<!-- 		        <div class="tabs-wrap"> -->
		<!-- 		         <ul class="tabs"> -->
		<!--                             <li><a href="#tab-gruppo" class="active-tab">Contatta Un Gruppo</a></li> -->
		<!--                             <li><a href="#tab-locale">Contatta Un Locale</a></li> -->
		<!-- 		       </ul> -->

		<!-- 		       <div id="tab-gruppo" class="tab-content"> -->

		<%-- 		        <form action="${pageContext.request.contextPath}/messages/addconversationGroup/"  --%>
		<%-- 		        	method="post"  --%>
		<%-- 		        	class="form contact-form" --%>
		<%-- 		        	id="formConversation"> --%>
		<!-- 		        	<div class="row clearfix"> -->

		<!-- 		 				<div class="col-1-3"> -->
		<!-- 		 					<label for="contact-name"><strong>Nome Del Gruppo</strong> </label> -->
		<!-- 							<input type="text" name="destinatario"  id="idGruppo" required> -->
		<!-- 		 				</div> -->
		<!-- 		 				<div class="col-1-3"> -->
		<!-- 		 						<label for="contact-www"><strong>Titolo</strong></label> -->
		<!-- 							<input   name="titolo"  id="titolo"></input> -->
		<!-- 		 				</div> -->
		<!-- 		 				<div class="col-1-3 last"> -->

		<!-- 		 				</div> -->
		<!-- 		        	</div> -->
		<!-- 		        	<div class="row clearfix"> -->
		<!-- 		        		<div class="col-1-1"> -->
		<!-- 		        			<label for="contact-message"><strong>Testo</strong> </label> -->
		<!-- 							<textarea name="corpo" id="corpo"></textarea> -->
		<!-- 						</div> -->
		<!-- 		        	</div> -->
		<!-- 					<input type="submit" value="Invia" class="large invert"> -->
		<!-- 					<div class="clear"></div> -->
		<%-- 		        </form> --%>
		<!-- 		</div> -->


		<!-- 		 <div id="tab-locale" class="tab-content"> -->

		<%-- 		        <form action="${pageContext.request.contextPath}/messages/addconversationLocal/"  --%>
		<%-- 		        	method="post"  --%>
		<%-- 		        	class="form contact-form" --%>
		<%-- 		        	id="formConversation"> --%>
		<!-- 		        	<div class="row clearfix"> -->
		<!-- 		 				<div class="col-1-3"> -->
		<!-- 		 					<label for="contact-name"><strong>Nome Del Locale</strong> </label> -->
		<!-- 							<input type="text" name="destinatario"  id="idLocale" required> -->
		<!-- 		 				</div> -->
		<!-- 		 				<div class="col-1-3"> -->
		<!-- 		 						<label for="contact-www"><strong>Titolo</strong></label> -->
		<!-- 							<input   name="titolo"  id="titolo"></input> -->
		<!-- 		 				</div> -->
		<!-- 		 				<div class="col-1-3 last"> -->

		<!-- 		 				</div> -->
		<!-- 		        	</div> -->
		<!-- 		        	<div class="row clearfix"> -->
		<!-- 		        		<div class="col-1-1"> -->
		<!-- 		        			<label for="contact-message"><strong>Testo</strong> </label> -->
		<!-- 							<textarea name="corpo" id="corpo"></textarea> -->
		<!-- 						</div> -->
		<!-- 		        	</div> -->
		<!-- 					<input type="submit" value="Invia" class="large invert"> -->
		<!-- 					<div class="clear"></div> -->
		<%-- 		        </form> --%>
		<!-- 		</div> -->

		<!-- 		</div> -->
		<!-- /container -->

	</div>

</section>

<script>
	$(document)
			.ready(
					function() {
						$("#idGruppo")
								.autocomplete(
										{
											source : "${pageContext.request.contextPath}/messages/get_groups_list",
											paramName : "term",
											delimiter : ",",
											transformResult : function(response) {

												return {

													//must convert json to javascript object before process
													suggestions : $
															.map(
																	$
																			.parseJSON(response),
																	function(
																			dataItem) {
																		return {
																			value : dataItem.value,
																			data : dataItem.label
																		};
																	})

												};

											}

										});

						$("#idLocale")
								.autocomplete(
										{
											source : "${pageContext.request.contextPath}/messages/get_locals_list",
											paramName : "term",
											delimiter : ",",
											transformResult : function(response) {

												return {

													//must convert json to javascript object before process
													suggestions : $
															.map(
																	$
																			.parseJSON(response),
																	function(
																			dataItem) {
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


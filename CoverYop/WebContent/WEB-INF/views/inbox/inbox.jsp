<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


    
    <!-- ############################# Intro ############################# -->
	<section class="intro-title section border-bottom" style="background-image: url(placeholders/events-bg.jpg)">
		<h1 class="heading-l">Inbox <span class="color">Message</span></h1>
	</section>
	<!-- /intro -->

    <!-- ############################# Countdown ############################# -->
    <section class="countdown section">
        <div class="container">
            <h5 class="countdown-title">Hai X Messaggi Non Letti</h5>
            
        </div>
    </section>
    <!-- /countdown -->

	<!-- ############################# Content ############################# -->
	<section class="content section">
		<!-- container -->
		<div class="container">

			<!-- Events table -->
            <table class="layout display responsive-table">
                <thead>
                    <tr>
                        <th>Data</th>
                         <th >Con</th>
                         <th colspan="2">Oggetto</th>
                       
                        
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${conversation}" var="item">
                    <tr>
                        <td class="table-date"><fmt:formatDate pattern="dd-MM-yyyy" value="${item.data.time}"/></td>
                        <td class="actions"><a href="#!/pages/event-single-disqus" >${item.destinatario.username}</a></td>
                        <td class="actions"><a href="${pageContext.request.contextPath}/messages/conversation/${item.id}">${item.titolo}</a></td>
                        
                        <td class="actions">
                            <a href="${pageContext.request.contextPath}/messages/conversation/${item.id}"  class="buy-tickets" title="Leggi" style="left:50%;">Leggi</a>
                        </td>
                    </tr>
		</c:forEach>
                    
                </tbody>
            </table>
            <!-- /events table --> 
        
			<!-- response form -->
	        
           	<hr class="divider">

				<h2>Invia Un Messaggio</h2>
				<!-- contact form -->
		        <form action="${pageContext.request.contextPath}/messages/addconversation/" 
		        	method="post" 
		        	class="form contact-form"
		        	id="formContatta">
		        	<div class="row clearfix">
		 				<div class="col-1-3">
		 					<label for="contact-name"><strong>Id</strong> </label>
							<input type="text" name="id"  id="id" required>
		 				</div>
		 				<div class="col-1-3">
		 						<label for="contact-www"><strong>Titolo</strong></label>
							<input   name="titolo"  id="titolo"></input>
		 				</div>
		 				<div class="col-1-3 last">
		 				
		 				</div>
		        	</div>
		        	<div class="row clearfix">
		        		<div class="col-1-1">
		        			<label for="contact-message"><strong>Testo</strong> </label>
							<textarea name="corpo" id="corpo"></textarea>
						</div>
		        	</div>
					<input type="submit" value="Invia" class="large invert">
					<div class="clear"></div>
		        </form>
		
		</div>
		<!-- /container -->
		
	
		
	</section>
	
	<script>
	
						$(document).ready(function(){
							$( "#id" ).autocomplete({
								source: '${pageContext. request. contextPath}/Messages/get_user_list',
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
	</script>
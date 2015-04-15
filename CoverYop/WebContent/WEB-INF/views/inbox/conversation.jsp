<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


    
    <!-- ############################# Intro ############################# -->
	<section class="intro-title section border-bottom" style="background-image: url(placeholders/events-bg.jpg)">
		<h1 class="heading-l">Cover<span class="color">Yop</span></h1>
	</section>
	<!-- /intro -->

    <!-- ############################# Countdown ############################# -->
    <section class="countdown section">
        <div class="container">
            <h4 class="countdown-title">${conversation.titolo}</h4>
            <h5 class="countdown-title">Conversazione Con ${utente2.username}</h5>
   
            
        </div>
    </section>
    <!-- /countdown -->

	<!-- ############################# Content ############################# -->
	<section class="content section">
		<!-- container -->
		<div class="container">

	<!-- <c:choose>
    <c:when test="${salary <= 0}">
       Salary is very low to survive.
    </c:when>
    <c:when test="${salary > 1000}">
        Salary is very good.
    </c:when>
    <c:otherwise>
        No comment sir...
    </c:otherwise>
</c:choose> -->
            
            <!-- Comment -->
            <c:forEach items="${messages}" var="message">
				<li class="comment">
					<c:choose>
						<c:when test="${utente.username == message.autore.username}">
							<article>
								<div class="avatar">
									<img src="${pageContext.request.contextPath}/${fotoprofilo1}">
								</div>
								<div class="comment-meta">
									<h5 class="author"><a href="#">${message.autore.username}</a></h5>
									<p class="date"><fmt:formatDate pattern="dd-MM-yyyy" value="${message.dataInvio.time}"/></p>
								</div>
								<div class="comment-body">
									<p>${message.text}</p>
								</div>
							</article>
					   </c:when>
				  <c:otherwise>
                            <article style="left: 85% ;">
								<div class="avatar">
									<img src="${pageContext.request.contextPath}/${fotoprofilo2}">
								</div>
								<div class="comment-meta">
									<h5 class="author"><a href="#">${message.autore.username}</a></h5>
									<p class="date"><fmt:formatDate pattern="dd-MM-yyyy" value="${message.dataInvio.time}"/></p>
								</div>
								<div class="comment-body">
									<p>${message.text}</p>
								</div>
							</article>
                  </c:otherwise>	
                 </c:choose>
		</c:forEach>
<!-- 		<h4 class="response-title">Rispondi</h4> -->
<br>
<div class="clear"></div>
			<!-- response form -->
	        <form:form method="post"
	        		   class="form response-form" 
	        		   modelAttribute="messaggio" 
	        		   action="${pageContext.request.contextPath}/messages/addreply/${conversation.id}">
	        	
	        	
	        	
	        	<div class="row clearfix">
	        		<div class="col-1-1">
	        			<label for="response-comment"><strong>Reply</strong></label>
						<form:textarea name="comment" path="text" ></form:textarea>
					</div>
	        	</div>
			<div class="clear"></div>
			<input type="submit"  class="action-button" value="Submit" />
	        </form:form>
	        <!-- /response form -->
		</div>
		<!-- /container -->
	</section>
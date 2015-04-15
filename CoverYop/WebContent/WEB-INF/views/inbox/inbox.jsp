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
                        <th>Date</th>
                        <th colspan="2">Message <a  class="event-location">From</a></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${conversation}" var="item">
                    <tr>
                        <td class="table-date"><fmt:formatDate pattern="dd-MM-yyyy" value="${item.data.time}"/></td>
                        <td class="table-name"><a href="${pageContext.request.contextPath}/messages/conversation/${item.id}">${item.titolo}></a><a href="#!/pages/event-single-disqus" class="event-location">${item.destinatario.username}</a></td>
                        <td class="actions">
                            <a href="${pageContext.request.contextPath}/messages/conversation/${item.id}"  class="buy-tickets" title="Leggi" style="left:50%;">Leggi</a>
                        </td>
                    </tr>
		</c:forEach>
                    
                </tbody>
            </table>
            <!-- /events table --> 
        
			<!-- response form -->
	        
           
		
		</div>
		<!-- /container -->
	</section>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content_wrapper">
	<div class="content">
		<div>
			<div class="content-holder">
				<div class="padding_container">THIS ARE MY FRIENDS ON TWITTER: </div>
				
				<c:forEach items="${friends}" var="friend">
					
						<td>${friend}</td>
					
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<sf:form action="logout" modelAttribute="logout">
	<div class="container">
		<button type="submit">Logout</button>
	</div>
</sf:form>


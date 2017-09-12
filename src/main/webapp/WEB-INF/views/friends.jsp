<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content_wrapper">
	<div class="content">
		<div>
			<div class="content-holder">
				<div class="padding_container">THIS ARE MY FRIENDS ON TWITTER: </div>
				
				<c:forEach items="${friends}" var="friend">
					
						<p>${friend.name}</p>
					
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<sf:form action="success">
	<div class="container">
		<button type="submit"> Home </button>
	</div>
</sf:form>


<sf:form action="addfriend" method="GET">
	<div class="container">
		<button type="submit"> Add friends </button>
	</div>
</sf:form>


<sf:form action="removefriend" method="GET">
	<div class="container">
		<button type="submit">Remove friends </button>
	</div>
</sf:form>

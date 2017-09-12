<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<h1>This is the ADD FRIEND page!</h1>
</body>
</html>


<sf:form action="/twitter/addfriend" method="POST" modelAttribute="addfriend">
	<div class="container">
		<label><b>Friend name</b></label>
		<sf:input path="name" type="text" />
		<button type="submit">Add Friend</button>
	</div>
</sf:form>
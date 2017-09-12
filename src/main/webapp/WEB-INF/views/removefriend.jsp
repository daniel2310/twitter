<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
	<h1>This is the REMOVE FRIEND page!</h1>
</body>
</html>


<sf:form action="/twitter/removefriend" method="POST" modelAttribute="removefriend">
	<div class="container">
		<label><b>Friend name</b></label>
		<sf:input path="name" type="text" />
		<button type="submit">Remove Friend</button>
	</div>
</sf:form>
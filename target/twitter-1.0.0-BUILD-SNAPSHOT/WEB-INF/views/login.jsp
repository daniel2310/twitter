<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Please Sign In:</h1>

	<sf:form action="login" method="POST" modelAttribute="login">
		<div class="container">
			<label><b>User name</b></label>
			<sf:input path="name" type="text" />

			<label><b>Password</b></label>
			<sf:input path="password" type="password" />

			<button type="submit">Login</button>
		</div>
	</sf:form>
	<div>${error}</div>


	<sf:form action="home" method='GET'>
		<div class="container">
			<button type="submit">Home</button>
		</div>
	</sf:form>

</body>
</html>

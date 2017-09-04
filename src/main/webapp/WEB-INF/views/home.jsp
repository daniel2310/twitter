<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello TWITTER FAN!!  
</h1>

</body>
</html>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

	
	<sf:form action="login" method="POST" modelAttribute="login">
		<div class="container">
  			<button type="submit">Login</button>
  		</div>
  	</sf:form>
  	
  	<sf:form action="about" modelAttribute="about">
		<div class="container">
  			<button type="submit">About</button>
  		</div>
	</sf:form>

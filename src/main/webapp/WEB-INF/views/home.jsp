<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello TWITTER FAN!!</h1>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>

<style>
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    width: 300 px;
}
</style>

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

<sf:form action="users" modelAttribute="users" method="GET">
	<div class="container">
		<button type="submit">Users</button>
	</div>
</sf:form>


<div class="button">
	<a href="/twitter/adduser" class="button">Register</a>
</div>


<div id="allMessages"></div>


<script type="text/javascript">
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/twitter/home",

		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(data) {
			$("#allMessages").append("<p>" + data.content + "</p>");
			console.log(data);
		},
		failure : function(errMsg) {
			alert(errMsg);
		}
	});

	
</script>
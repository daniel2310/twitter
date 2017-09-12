<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>USERS</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<h1>USERS PAGE</h1>

</body>
</html>

<label><b>Search user</b></label>




<input id="users" type="text" />

<button id="searchUser" type="submit">Search</button>

<sf:form action="home" method='GET'>
	<div class="container">
		<button type="submit">Home</button>
	</div>
</sf:form>

<div id="findingUser"></div>


<c:forEach items="${usersList}" var="user">

	<p>${user.name}</p>

</c:forEach>



<script type="text/javascript">
	$("#searchUser").click(
			function() {
				$.ajax({
					type : "GET",
					url : "http://localhost:8080/twitter/finduser/"
							+ document.getElementById("users").value,

					contentType : "application/json; charset=utf-8",
					dataType : "json",
					success : function(data) {
						$("#findingUser").text(data.username);
						console.log(data);
					},
					failure : function(errMsg) {
						alert(errMsg);
					}
				});
			});

	
</script>
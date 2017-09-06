<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h1>This is the REGISTER page!</h1>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
</body>


<body>
	<h3>Please Register:</h3>



	<div class="container">
		<label><b>New User name</b></label> <input id="username" type="text"
			name="name"><br> <label><b>Your Password</b></label> <input
			id="pass" type="password" name="password"><br>

		<button id="register" type="submit">Register</button>
	</div>


</body>
</html>

<sf:form action="home" method='GET'>
	<div class="container">
		<button type="submit">Home</button>
	</div>
</sf:form>

<div id="addUser"></div>

<script type="text/javascript">
	$("#register").click(
			function() {

				var username = document.getElementById('username').value;
				var pass = document.getElementById('pass').value;
				var Data = {
					"name" : username,
					"password" : pass
				};

				$.ajax({
					type : "POST",
					url : "http://localhost:8080/twitter/adduser",
					data : JSON.stringify(Data),
					processData : false,
					cache : false,
					async : true,
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					success : function(data) {
						$("#addUser").append(
								"<p>" + data.name
										+ " Cont creat cu succes! </p>");
						console.log(data);
					},
					failure : function(errMsg) {
						alert(errMsg);
					}
				});

			});
</script>

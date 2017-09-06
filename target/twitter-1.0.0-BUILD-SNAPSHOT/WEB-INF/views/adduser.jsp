<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content_wrapper">
	<div class="content">
		<div>
			<div class="content-holder">
				<div class="padding_container">REGISTER PAGE</div>
				<script
					src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			</div>
		</div>
	</div>
</div>
<body>
	<h3>Please Register:</h3>


	<form action="register" method="POST">
		<div class="container">
			<label><b>New User name</b></label> <input type="text" name="name"><br>

			<label><b>Your Password</b></label> <input type="text"
				name="password"><br>

			<button type="submit">Register</button>
		</div>
	</form>

</body>


<sf:form action="home" method='GET'>
	<div class="container">
		<button type="submit">Home</button>
	</div>
</sf:form>

<div id="addUser"></div>

<script type="text/javascript">
	$("#addAnUser").click(function() {

		var messageText = document.getElementById('myNewUser').value;
		var Data = {
			"name" : messageText
			"password" : messageText
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
				$("#addUser").append("<p>" + data.content + "</p>");
				console.log(data);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});

	});
</script>

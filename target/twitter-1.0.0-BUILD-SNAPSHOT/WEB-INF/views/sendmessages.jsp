<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

	<div class="container">
		<label><b>Insert Message: </b></label>
			<input type="text" id="myMessage" />
				<button id="sendMessage">SEND</button>
	</div>



<div class="container">
	<c:forEach items="${messageList}" var="map">
		<c:forEach items="${map.value}" var="message">
			<td>${message.text}</td>
		</c:forEach>
	</c:forEach>
</div>

<sf:form action="success" modelAttribute="success">
		<div class="container">
  			<button type="submit"> Home </button>
  		</div>
</sf:form>
	
<div id="newMessage"> </div>


</body>
</html>

<script type="text/javascript">
$("#sendMessage").click(function(){
	
    var messageText = document.getElementById('myMessage').value;
    var Data={"content": messageText};
    
	
	$.ajax({
        type: "PUT",
        url: "http://localhost:8080/twitter/message",
        data: JSON.stringify(Data),
        processData: false,
        cache: false,
        async: true,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data){
         $("#newMessage").append("<p>" + data.content + "</p>");
        	console.log(data);
         },
        failure: function(errMsg) {
            alert(errMsg);
        }
    });
	
});
</script>
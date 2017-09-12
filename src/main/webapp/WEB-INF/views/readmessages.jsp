<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</html>
</head>

<div class="content_wrapper">
	<div class="content">
		<div>
			<div class="content-holder">
				<div class="padding_container">THIS ARE YOUR MESSAGES:</div>
				<c:forEach items="${messageList}" var="map">
					
						<p>${map.user.name} : ${map.content}</p>
					
				</c:forEach>
			</div>
		</div>
	</div>
</div>



<div id="newReadMessage"> </div>

<sf:form action="success">
	<div class="container">
		<button type="submit"> Home </button>
	</div>
</sf:form>

<script type="text/javascript">
  
	$.ajax({
        type: "GET",
        url: "http://localhost:8080/twitter/home",
        
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data){
         $("#newReadMessage").append("<p>" + data.content + "</p>");
        	console.log(data);
         },
        failure: function(errMsg) {
            alert(errMsg);
        }
    });
	

</script>

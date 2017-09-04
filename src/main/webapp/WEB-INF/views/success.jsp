<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content_wrapper">
	<div class="content">
		<div>
			<div class="content-holder">
				<div class="padding_container">WELCOME ON YOUR TWITTER PAGE ${sessionScope.username}</div>
			</div>
		</div>
	</div>
</div>

<sf:form action="logout" >
		<div class="container">
  			<button type="submit">Logout</button>
  			
  		</div>
</sf:form>

<sf:form action="friends" method="GET">
		<div class="container">
  			<button type="submit">Friends</button>
  		</div>
</sf:form>



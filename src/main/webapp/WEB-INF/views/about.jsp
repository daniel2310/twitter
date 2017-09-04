<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content_wrapper">
	<div class="content">
		<div>
			<div class="content-holder">
				<div class="padding_container">THIS IS THE ABOUT PAGE!</div>
			</div>
		</div>
	</div>
</div>

<sf:form action="home" modelAttribute="home">
		<div class="container">
  			<button type="submit">Home</button>
  		</div>
	</sf:form>
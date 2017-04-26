<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>Welcome ${name}</h2>
		</div>
	</div>
		
	<div id="container">
		<div id="content">
			<img src="/resources/images/CMlogo.jpg">
		
			<br><br><br><br>
			<input class="btn-lg btn-default" type="Submit" value="Proceed"
				onclick="window.location.href='/contact/list';return false;"/>
		</div>
	</div>


<%@ include file="common/footer.jspf"%>
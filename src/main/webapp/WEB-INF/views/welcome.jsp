<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>CM - Contact Manager v0.9 Beta</h2>
		</div>
	</div>
		
	<div id="container">
		<div id="content">
			
			<input class="btn-lg btn-success" type="Submit" value="Welcome ${name}. Consider implementing a decent landing page."
							onclick="window.location.href='/contact/list';return false;"/>

		</div>
	</div>


<%@ include file="common/footer.jspf"%>
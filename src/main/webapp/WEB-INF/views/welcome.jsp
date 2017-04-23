<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>CM - Contact Manager v0.6 Alpha</h2>
		</div>
	</div>
		
	<div id="container">
		<div id="content">
			Welcome ${name}<br>
			
			<input class="btn-lg btn-success" type="Submit" value="View Contacts"
							onclick="window.location.href='/contact/list';return false;"/>

			<input class="btn-sm" type="Submit" value="Add Country"
							onclick="window.location.href='/country/addCountryForm';return false;"/>
			<input class="btn-xs" type="Submit" value="List Country"
							onclick="window.location.href='/country/list';return false;"/>

		</div>
	</div>


<%@ include file="common/footer.jspf"%>
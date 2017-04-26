<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>Error has occured!</h2>
		</div>
	</div>
			
	<div id="container">
		<div id="content">
			<h3>You can't delete this entry.</h3> <br>
			<h4>Still references to an existing city or address. <br>
				Please remove the existing entry first.</h4>
		</div>
	</div>

	<br><br>
	<input class="btn-sm" type="Submit" value="Back"
		onclick="window.history.back();return false;"/>
	<br><br>
		
<%@ include file="common/footer.jspf"%>
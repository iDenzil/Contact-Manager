<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>Error has occured!</h2>
		</div>
	</div>
			
	<div id="container">
		<div id="content">
			<h3>You can't delete this entry. Still bound to an existing object (city or address). <br>
				Try removing the causing entry first.</h3>
		</div>
	</div>

	<br><br>
	<input class="btn btn-sm" type="Submit" value="Back"
		onclick="window.history.back();return false;"/>
	<br><br>
		
<%@ include file="common/footer.jspf"%>
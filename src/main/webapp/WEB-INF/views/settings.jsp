<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
	
	<div id="wrapper">
		<div id="header">
			<h2>Settings</h2>
		</div>
	</div>
		
	<div id="container">
		<div id="content">
			<h3>When I grow up.. I'm gonna SetThings</h3> 
			<br>
			<h4>ToDo List:</h4>
			<ul>
				<li>Return values in Delete error view</li>
				<li>User access levels - limit UPDATE and DELETE to ADMIN role</li>
			</ul>


			
		</div>
	</div>
	
	<br><br>
	<input class="btn-sm" type="Submit" value="Home"
		onclick="window.location.href='/welcome';return false;"/>
	<br><br>
	
<%@ include file="common/footer.jspf"%>
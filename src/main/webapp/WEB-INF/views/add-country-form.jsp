<%@ include file="common/header.jspf"%>

	<link type="text/css"
		rel="stylesheet"
  		href="${pageContext.request.contextPath}/resources/css/add-style.css" />

<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>Add Country</h2>
		</div>
	</div>
	<br>

	<div id="container">

		<form:form action="saveCountry" modelAttribute="addcountry" method="POST">
		
		<!-- Need to associate this data with contact and address id -->
		<!-- So when doing submit the backend knows which contact to form the update operation on -->
		<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name"/>
							<form:errors path="name" class="error"/>	<!-- Validation -->
						</td>
					</tr>
					<tr>
						<td><label>Alpha 2:</label></td>
						<td><form:input path="alpha2"/>
							<form:errors path="alpha2" class="error"/>	<!-- Validation -->
						</td>
					</tr>
					<tr>
						<td><label>Alpha 3:</label></td>
						<td><form:input path="alpha3"/>
							<form:errors path="alpha3" class="error"/>	<!-- Validation -->
						</td>
					</tr>
					<tr><td><br></td></tr>	<!-- aesthetics -->
					<tr>
						<td><label></label></td>
						<td><input class="btn-lg btn-success btn-save" type="submit" value="Save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form:form>
	</div>

	<br><br>
	<input class="btn-sm" type="Submit" value="Back"
		onclick="window.history.back();return false;"/>
	<br><br>
		
<%@ include file="common/footer.jspf"%>

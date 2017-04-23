<%@ include file="common/header.jspf"%>

	<link type="text/css"
		rel="stylesheet"
  		href="${pageContext.request.contextPath}/resources/css/add-contact-style.css" />

<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>Add City</h2>
		</div>
	</div>
	<br>

	<div id="container">

		<!-- <h3>>New City</h3>  -->
		
		<form:form action="saveCity" modelAttribute="addcity" method="POST">
		
		<!-- Need to associate this data with contact and address id -->
		<!-- So when doing submit the backend knows which contact to form the update operation on <form:hidden path="country.id"/>-->
		<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name"/></td>
					</tr>
					<tr>
						<td><label>ZIP CODE:</label></td>
						<td><form:input path="zipCode"/></td>
					</tr>
					<tr>
						<td><label>Country:</label></td>
						<td>
							<form:select path="country.id">
           						<form:options items="${countryoptions}" itemValue="id" itemLabel="name" />
           					</form:select>
						</td>
					</tr>
					<tr>
						<td><label><br></label></td>
						<td>
							<input class="add" type="Submit" value="Add Country"
							onclick="window.location.href='/country/addCountryForm';return false;"/>
						</td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input class="btn btn-success" type="submit" value="Save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form:form>
	</div>

	<br><br>
	<input class="btn-xs" type="Submit" value="Back"
		onclick="window.history.back();return false;"/>
		
<%@ include file="common/footer.jspf"%>

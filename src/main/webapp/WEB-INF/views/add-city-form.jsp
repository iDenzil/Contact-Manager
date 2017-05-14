<%@ include file="common/header.jspf"%>

	<link type="text/css"
		rel="stylesheet"
  		href="${pageContext.request.contextPath}/resources/css/add-style.css" />

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
		
		<!-- Need to link this data with City id -->
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
						<td><label>ZIP code:</label></td>
						<td><form:input path="zipCode"/>
							<form:errors path="zipCode" class="error"/>	<!-- Validation -->
						</td>
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
							<input class="btn-xs btn-info" type="Submit" value="Add Country"
							onclick="window.location.href='/country/addCountryForm';return false;"/>
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

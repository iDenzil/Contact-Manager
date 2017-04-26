<%@ include file="common/header.jspf"%>

	<link type="text/css"
		rel="stylesheet"
	  	href="${pageContext.request.contextPath}/resources/css/add-style.css" />

<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>Add Contact</h2>
		</div>
	</div>
	<br>

	<div id="container">

		<!--  <h3>Save Contact</h3> -->
		
		<form:form action="saveContact" modelAttribute="addcontact" method="POST">
		
		<!-- Need to link this data with contact and address id -->
		<form:hidden path="id"/><form:hidden path="address.id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"/>
							<form:errors path="firstName" class="error"/>	<!-- Validation -->
						</td>

					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName"/>
							<form:errors path="lastName" class="error"/>	<!-- Validation -->
						</td>

					</tr>
					<tr>
						<td><label>Sex:</label></td>
						<td>
							<form:select path="sex.id">
           						<form:options items="${sexoptions}" itemValue="id" itemLabel="name" />
           					</form:select>
						</td>
					</tr>
					<tr><td><br></td></tr>  <!-- aesthetics -->
					<tr>
						<td><label>Phone:</label></td>
						<td><form:input path="phone"/>
							<form:errors path="phone" class="error"/>	<!-- Validation -->
						</td>

					</tr>
					<tr>
						<td><label>E-mail:</label></td>
						<td><form:input path="email"/>
							<form:errors path="email" class="error"/>	<!-- Validation -->
						</td>

					</tr>
					<tr>
						<td><label>Street:</label></td>
						<td><form:input path="address.street"/>
							<form:errors path="address.street" class="error"/>	<!-- Validation -->
						</td>

					</tr>
					<tr>
						<td><label>Street no:</label></td>
						<td><form:input path="address.streetNo"/>
							<form:errors path="address.streetNo" class="error"/>	<!-- Validation -->
						</td>

					</tr>
					<tr>
						<td><label>City:</label></td>
						<td>
							<form:select path="address.city.id">
           						<form:options items="${cityoptions}" itemValue="id" itemLabel="name" />
           					</form:select>
						</td>
					</tr>
					<tr>
						<td><label><br></label></td>
						<td>
							<input class="btn-xs btn-info" type="Submit" value="Add City"
							onclick="window.location.href='/city/addCityForm';return false;"/>
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

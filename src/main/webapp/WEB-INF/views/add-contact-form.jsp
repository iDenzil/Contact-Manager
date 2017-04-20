<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

		<link type="text/css"
		rel="stylesheet"
	  	href="${pageContext.request.contextPath}/resources/css/add-contact-style.css" />


	<div id="container">

		<h3>Save Contact</h3>
		
		<form:form action="saveContact" modelAttribute="addcontact" method="POST">
		
		<!-- Need to associate this data with contact id -->
		<!-- So when doing submit the backend knows which contact to form the update operation on -->
		<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Phone:</label></td>
						<td><form:input path="phone"/></td>
					</tr>
					<tr>
						<td><label>E-mail:</label></td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><label>Street:</label></td>
						<td><form:input path="address.street"/></td>
					</tr>
					<tr>
						<td><label>Street no:</label></td>
						<td><form:input path="address.streetNo"/></td>
					</tr>
					<tr>
						<td><label>City ID:</label></td>
						<td><form:input path="address.city"/></td>
					</tr>

					<tr>
						<td><label>Sex:</label></td>
						<td>Female<form:radiobutton path="sex.id" value="1"/></td>
						<td>Male<form:radiobutton path="sex.id" value="2"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
					
				</tbody>
			</table>
					
		</form:form>
		<div style="clear;both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/contact/list">Back to list</a>
		</p>
				
	</div>
	
<br><br><br>
<h6>Must fix radiobuttons!</h6>
<%@ include file="common/footer.jspf"%>

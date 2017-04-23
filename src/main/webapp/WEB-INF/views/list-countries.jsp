<%@ include file="common/header.jspf"%>
	
	<link type="text/css"
		rel="stylesheet"
	  	href="${pageContext.request.contextPath}/resources/css/country.css" />	  
	  	
<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>CM - Contact Manager v0.7 Alpha</h2>
		</div>
	</div>
	<br>	
	<div id="container">
		<div id="content">
		
	
		<!--  Add City button -->
		<input type="submit" class="btn-lg btn-success" value="Add Country"
			onclick="window.location.href='/country/addCountryForm';return false;"/>
		<br><br>
		
		<!-- HTML table from the DB-->
		<table>
			<tr>
				<th>Name</th>
				<th>Alpha 2</th>
				<th>Alpha 3</th>
				<th>Action</th>
			</tr>

			<!-- Loop over each entry and print out a <tr> for each one -->
			<c:forEach var="temp" items="${countries}">
			
				<!-- Construct an "update" link with contact ID  -->
				<c:url var="updateLink" value="/country/update">
					<c:param name="countryId" value="${temp.id}"/>
				</c:url>

				<!-- Construct an "delete" link with contact ID  -->
				<c:url var="deleteLink" value="/country/delete">
					<c:param name="countryId" value="${temp.id}"/>
				</c:url>

				
				<!--  TABLE DATA  -->
				<tr>
					<td>${temp.name}</td>
					<td>${temp.alpha2}</td>
					<td>${temp.alpha3}</td>
					
					<td>
						<input class="btn-xs btn-primary" type="Submit" value="Update"
							onclick="window.location.href='${updateLink}';return false;"/>

						<input class="btn-xs btn-danger" type="Submit" value="Delete"
							onclick="if(confirm('Are you sure you want to delete this country?')) window.location.href='${deleteLink}';return false;"/>	

						
					</td>
				</tr>
		
			</c:forEach>
		</table>
		

		
		</div>
	</div>


<%@ include file="common/footer.jspf"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>CM - Contact Manager v0.9 Beta</h2>
		</div>
	</div>
	<br>	
	<div id="container">
		<div id="content">
		
	
		<!--  Add City button -->
		<input type="submit" class="btn-lg btn-success" value="Add City"
			onclick="window.location.href='/city/addCityForm';return false;"/>
		<br><br>
		
		<!-- HTML table from the DB-->
		<table class="table-city">
			<tr>
				<th>Name</th>
				<th>ZIP Code</th>
				<th>Country</th>
				<th>Action</th>
			</tr>

			<!-- Loop over each entry and print out a <tr> for each one -->
			<c:forEach var="temp" items="${cities}">
			
				<!-- Construct an "update" link with contact ID  -->
				<c:url var="updateLink" value="/city/update">
					<c:param name="cityId" value="${temp.id}"/>
				</c:url>

				<!-- Construct an "delete" link with contact ID  -->
				<c:url var="deleteLink" value="/city/delete">
					<c:param name="cityId" value="${temp.id}"/>
				</c:url>

				
				<!--  TABLE DATA  -->
				<tr>
					<td>${temp.name}</td>
					<td>${temp.zipCode}</td>
					<td>${temp.country}</td>
					
					<td>
						<input class="btn-xs btn-primary" type="Submit" value="Update"
							onclick="window.location.href='${updateLink}';return false;"/>

						<input class="btn-xs btn-danger" type="Submit" value="Delete"
							onclick="if(confirm('Are you sure you want to delete this city?')) window.location.href='${deleteLink}';return false;"/>	

						
					</td>
				</tr>
		
			</c:forEach>
		</table>
		

		
		</div>
	</div>


<%@ include file="common/footer.jspf"%>
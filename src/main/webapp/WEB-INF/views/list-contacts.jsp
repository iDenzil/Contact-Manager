<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div id="wrapper">
		<div id="header">
			<h2>CM - Contact Manager v0.7 Alpha</h2>
		</div>
	</div>
	<br>	
	<div id="container">
		<div id="content">
		
	
		<!--  Add Contact button -->
		<input type="submit" class="btn-lg btn-success" value="Add Contact"
			onclick="window.location.href='addContactForm';return false;"/>
		<br><br>
		<!-- HTML table from the DB-->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Sex</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Address</th>
				<th>Action</th>
			</tr>

			<!-- Loop over each entry and print out a <tr> for each one -->
			<c:forEach var="temp" items="${contacts}">
			
				<!-- Construct an "update" link with contact ID  -->
				<c:url var="updateLink" value="/contact/update">
					<c:param name="contactId" value="${temp.id}"/>
				</c:url>

				<!-- Construct an "delete" link with contact ID  -->
				<c:url var="deleteLink" value="/contact/delete">
					<c:param name="contactId" value="${temp.id}"/>
				</c:url>

				
				<!--  TABLE DATA  -->
				<tr>
					<td>${temp.firstName}</td>
					<td>${temp.lastName}</td>
					<td>${temp.sex.name}</td>
					<td>${temp.phone}</td>
					<td>${temp.email}</td>
					<td>${temp.address}</td>
					
					<td>
						<input class="btn-xs btn-primary" type="Submit" value="Update"
							onclick="window.location.href='${updateLink}';return false;"/>

						<input class="btn-xs btn-danger" type="Submit" value="Delete"
							onclick="if(confirm('Are you sure you want to delete this contact?')) window.location.href='${deleteLink}';return false;"/>	

					</td>
				</tr>
		
			</c:forEach>
		</table>
		

		
		</div>
	</div>


<%@ include file="common/footer.jspf"%>
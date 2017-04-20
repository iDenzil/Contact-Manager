<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	
	<div id="container">
		<div id="content">
		
		<!--  Add Contact button -->
		<input type="button" value="Add Contact"
			onclick="window.location.href='addContactForm';return false;"
			class="add-button"
		/>
		
		
		<!-- HTML table from the DB-->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Address</th>
				<th>Sex</th>
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
					<td>${temp.phone}</td>
					<td>${temp.email}</td>
					<td>${temp.address}</td>
					<td>${temp.sex.name}</td>
					
					<td>
						<!--  display Update link -->
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this contact?'))) return false">Delete</a>
					</td>
				</tr>
		
			</c:forEach>
		</table>
		</div>
	</div>


<%@ include file="common/footer.jspf"%>
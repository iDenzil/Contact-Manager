<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>CONTACT-FORM.JPS</h1><br>
	<form:form action="processForm" modelAttribute="contact">
		First name: <form:input path="firstName"/>
		<br><br>	
		Last name: <form:input path="lastName"/>
		<br><br>
		<form:select path="sex">
			<form:option value="male" label="Male"/>
			<form:option value="female" label="Female"/>
		</form:select>
		<br><br>
		Musko <form:radiobutton path="spol" value="Musko"/>
		Zensko <form:radiobutton path="spol" value="Zensko"/>
		<br><br>
				
		
		<input type="submit" value="Submit"/>
	</form:form>

</body>
</html>
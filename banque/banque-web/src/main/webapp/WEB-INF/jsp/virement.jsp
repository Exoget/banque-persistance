<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue sur votre banque en ligne !</title>
</head>
<body>
<h1>Bienvenue sur votre banque en ligne !</h1>
<h3>Virement entre vos comptes</h3>

<form:form modelAttribute="virementForm">
<table border="1">
	<tr>
		<th>Numéro de compte</th>
		<th>Solde</th>
		<th>Compte à débiter</th>
		<th>Compte à créditer</th>
	</tr>
	<c:forEach items="${lesComptes}" var="cpt">
	<tr>	
		<td><c:out value="${cpt.numero}" /></td>
		<td><c:out value="${cpt.solde}" /></td>
		<td><form:radiobutton path="debiter" value="${cpt.numero}" /></td>
		<td><form:radiobutton path="crediter" value="${cpt.numero}" /></td>
	</tr>
	</c:forEach>
</table>
	Montant : <form:input path="montant"/><br />
	<input type="submit" value="Enregistrer le virement" />
</form:form>

</body>
</html>
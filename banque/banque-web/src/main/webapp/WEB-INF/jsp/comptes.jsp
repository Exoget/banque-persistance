<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bonjour - Vos Comptes ...</title>
</head>
<body>
<h1>Bienvenue sur votre Banque en ligne !</h1>
<h3>Bonjour - Vos Comptes ...</h3>

<p>Bonjour <c:out value="${leClient.prenom}" />
<c:out value="${leClient.nom}" /></p>

<table border="1">
	<tr>
		<th>Numéro</th>
		<th>Solde</th>
	</tr>
	<c:forEach items="${lesComptes}" var="cpt">
	<tr>
		<td><c:out value="${cpt.numero}" /></td>
		<td><c:out value="${cpt.solde}" /></td>
	</tr>
	</c:forEach>
</table>

<a href="virement.do">Effectuer un virement</a>

</body>
</html>

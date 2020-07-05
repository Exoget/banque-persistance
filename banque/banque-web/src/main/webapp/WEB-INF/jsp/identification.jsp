<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Identification Client</title>
</head>
<body>
<h1>Bienvenue sur votre Banque en ligne!</h1>
<h3>Identification Client</h3>

<c:if test="${message != null}">
	<c:out value="${message}" />
</c:if>

<form:form modelAttribute="identificationForm">
	
	<label>Identifiant : </label>
	<form:input path="identifiant" />
	<br />
	
	<label>Mot de passe : </label>
	<form:password path="motDePasse"  />
	<br />
	
	<input type="submit" value="Valider" />
		
</form:form>

</body>
</html>
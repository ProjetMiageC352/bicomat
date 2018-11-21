<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
        <title><spring:message code="titre"/> - <spring:message code="client.titre"/></title>
    </head>
    <body>
    <h1><spring:message code="tiers.titre.creation"/></h1>
    	<form method="post"  modelAttribute="creertiers">
        <p>
            <label for="nom">Numéro de compte : </label>
            <input type="text" name="num" id="num" />
        </p>
        <p>
            <label for="prenom">Actif : </label>
            <input type="checkbox" name="actif" id="actif" value="true"/>
        </p>
        
        <input type="submit" />
    </form> 
    </body>
</html>
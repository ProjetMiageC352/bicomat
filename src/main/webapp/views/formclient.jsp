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
    	<form method="post"  modelAttribute="creerclient">
        <p>
            <label for="nom">Nom : </label>
            <input type="text" name="nom" id="nom" />
        </p>
        <p>
            <label for="prenom">Prénom : </label>
            <input type="text" name="prenom" id="prenom" />
        </p>
        
        <p>
            <label for="adresse">adresse mail: </label>
            <input type="text" name="adresse" id="adresse" />
        </p>
        
         <p>
            <label for="type">type de client: </label>
            <input type="text" name="type" id="type" />
        </p>
        <input type="submit" />
    </form> 
    </body>
</html>
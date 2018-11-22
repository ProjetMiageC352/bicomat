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
    	<table>
    	
    	<tr>
            <td><label for="nom">Nom : </label></td>
           	<td><input type="text" name="nom" id="nom" /></td>
        </tr>
        <tr>
            <td><label for="nom">Prenom : </label></td>
            <td><input type="text" name="prenom" id="prenom" /></td>
       </tr>
        <tr>
            <td><label for="nom">Numéro de compte : </label></td>
            <td><input type="text" name="num" id="num" /></td>
        </tr>
        <tr>
            <td><label for="nom">Id Client : </label></td>
            <td><input type="text" name="id_client" id="id_client" /></td>
        </tr>
        <tr>
            <td><label for="prenom">Actif : </label></td>
            <td><input type="checkbox" name="actif" id="actif" value="true"/></td>
        </tr>
        </table>
        
        <input type="submit" value="Envoyer"/>
    </form> 
    </body>
</html>
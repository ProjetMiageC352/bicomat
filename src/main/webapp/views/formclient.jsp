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
    <h1><spring:message code="client.titre.creation"/></h1>
    	<form method="post"  modelAttribute="creerclient">
        <table>
    	
    	<tr>
            <td><label for="nom">Nom : </label></td>
            <td><input type="text" name="nom" id="nom" /></td>
        </tr>
        <tr>
            <td><label for="prenom">Prénom : </label></td>
            <td><input type="text" name="prenom" id="prenom" /></td>
        </tr>
        <tr>
            <td><label for="adresse">Adresse mail: </label></td>
            <td><input type="text" name="adresse" id="adresse" /></td>
        </tr>
        <tr>
            <td><label for="type">Téléphone </label></td>
            <td><input type="text" name="tel" id="tel"/></td>
        </tr>
        <tr>
            <td><label for="type">Numéro de Contrat</label></td>
            <td><input type="text" name="contrat" id="contrat"/></td>
        </tr>
        <tr>
            <td><label for="type">Id du Conseiller</label></td>
            <td><input type="text" name="conseiller" id="conseiller"/></td>
        </tr>
        <tr>
            <td><label for="type">Login</label></td>
            <td><input type="text" name="login" id="login" /></td>
        </tr>
        <tr>
          <td><label for="type">Mot de passe</label></td>
           <td><input type="text" name="password" id="password"/></td>
        </tr>
        </table>
        <input type="submit" value="Envoyer"/>
    </form> 
    </body>
</html>
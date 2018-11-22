<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un Tiers</title>
    </head>
    <body>
        <form method="post" action="creertiers">
            <fieldset>
                <legend>Créer un tiers</legend>
                <p>Renseigner les champs suivants</p>
				<table>
    				<tr>
                <td><label for="nom">Nom:</label></td>
                <td><input id="nom" name="nom" size="20" maxlength="60" /></td>
                <td><span class="erreur">${form.erreurs['nom']}</span></td>
                </tr>
        		<tr>	
                <td><label for="prenom">Prénom</label></td>
                <td><input  id="prenom" name="prenom" value="" size="20" maxlength="20" /></td>
                <td><span class="erreur">${form.erreurs['prenom']}</span></td>
                </tr>
                <tr>	
                <td><label for="prenom">Numéro de Compte</label></td>
                <td><input  id="num" name="num" value="" size="20" maxlength="20" /></td>
                <td><span class="erreur">${form.erreurs['num']}</span></td>
                </tr>
                 <tr>
	            <td><label for="nom">Id Client : </label></td>
	            <td><input type="text" name="id_client" id="id_client" /></td>
	        	</tr>
	        	<tr>
	            <td><label for="prenom">Actif : </label></td>
	            <td>
	            <select  name="actif" id="actif">
	            	<option value="true">Oui</option>
	            	<option value="false">Non</option>
	            </select>
	            </td>
	        	</tr>
        		<tr>
                <td colspan="3"><input type="submit" value="Valider" /></td>
                </tr>
        		</table>
                
               
            </fieldset>
        </form>
        
        <p><c:out value="${etatTiers}"/></p>
    </body>
</html>
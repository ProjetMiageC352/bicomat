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
    	<h1><spring:message code="client.titre"/></h1>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="client.colonne.identifiant"/></th>
                    <th><spring:message code="client.colonne.nom"/></th>
                    <th><spring:message code="client.colonne.prenom"/></th>
                    <th><spring:message code="client.colonne.adresse"/></th>
                    <th><spring:message code="client.colonne.type"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clients}" var="client">
                    <tr>
                        <td><c:out value="${client.id}"/></td>
                        <td><c:out value="${client.nom}"/></td>
                        <td><c:out value="${client.prenom}"/></td>
                        <td><c:out value="${client.adresse_mail}"/></td>
                         <td><c:out value="${client.type_client}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
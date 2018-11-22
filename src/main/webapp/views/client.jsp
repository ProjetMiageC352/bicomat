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
                    <th><spring:message code="client.colonne.tel"/></th>
                    <th><spring:message code="client.colonne.contrat"/></th>
                    <th><spring:message code="client.colonne.conseiller"/></th>
                    <th><spring:message code="client.colonne.login"/></th>
                    <th><spring:message code="client.colonne.password"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clients}" var="client">
                    <tr>
                        <td><c:out value="${client.id}"/></td>
                        <td><c:out value="${client.nom}"/></td>
                        <td><c:out value="${client.prenom}"/></td>
                        <td><c:out value="${client.adresse_mail}"/></td>
                        <td><c:out value="${client.tel_client}"/></td>
                        <td><c:out value="${client.num_contrat}"/></td>
                        <td><c:out value="${client.id_conseiller}"/></td>
                        <td><c:out value="${client.login}"/></td>
                        <td><c:out value="${client.password}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
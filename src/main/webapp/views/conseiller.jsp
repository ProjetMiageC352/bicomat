<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
        <title><spring:message code="titre"/> - <spring:message code="conseiller.titre"/></title>
    </head>
    <body>
    	<h1><spring:message code="conseiller.titre"/></h1>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="conseiller.colonne.identifiant"/></th>
                    <th><spring:message code="conseiller.colonne.nom"/></th>
                    <th><spring:message code="conseiller.colonne.prenom"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${conseillers}" var="conseiller">
                    <tr>
                        <td><c:out value="${conseiller.id}"/></td>
                        <td><c:out value="${conseiller.nom}"/></td>
                        <td><c:out value="${conseiller.prenom}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
        <title><spring:message code="titre"/> - <spring:message code="banque.titre"/></title>
    </head>
    <body>
    	<h1><spring:message code="banque.titre"/></h1>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="banque.colonne.identifiant"/></th>
                    <th><spring:message code="banque.colonne.nom"/></th>
                    <th><spring:message code="banque.colonne.adresse"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${banques}" var="banque">
                    <tr>
                        <td><c:out value="${banque.id}"/></td>
                        <td><c:out value="${banque.nom}"/></td>
                        <td><c:out value="${banque.adresse}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
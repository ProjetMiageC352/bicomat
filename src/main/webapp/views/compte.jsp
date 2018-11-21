<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
        <title><spring:message code="titre"/> - <spring:message code="compte.titre"/></title>
    </head>
    <body>
    	<h1><spring:message code="compte.titre"/></h1>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="compte.colonne.identifiant"/></th>
                    <th><spring:message code="compte.colonne.type"/></th>
                    <th><spring:message code="compte.colonne.decouvert"/></th>
                    <th><spring:message code="compte.colonne.solde"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${comptes}" var="compte">
                    <tr>
                        <td><c:out value="${compte.id}"/></td>
                        <td><c:out value="${compte.type}"/></td>
                        <td><c:out value="${compte.decouvert}"/></td>
                        <td><c:out value="${compte.solde}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
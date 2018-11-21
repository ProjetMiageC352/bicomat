<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
        <title><spring:message code="titre"/> - <spring:message code="operation.titre"/></title>
    </head>
    <body>
    	<h1><spring:message code="operation.titre"/></h1>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="operation.colonne.identifiant"/></th>
                    <th><spring:message code="operation.colonne.date"/></th>
                    <th><spring:message code="operation.colonne.montant"/></th>
                    <th><spring:message code="operation.colonne.type"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${operations}" var="operation">
                    <tr>
                        <td><c:out value="${operation.id}"/></td>
                        <td><c:out value="${operation.date}"/></td>
                        <td><c:out value="${operation.montant}"/></td>
                        <td><c:out value="${operation.type}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
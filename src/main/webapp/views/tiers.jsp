<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
        <title><spring:message code="titre"/> - <spring:message code="tiers.titre"/></title>
    </head>
    <body>
    	<h1><spring:message code="tiers.titre"/></h1>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="tiers.colonne.compte"/></th>
                    <th><spring:message code="tiers.colonne.actif"/></th>
            
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${Tiers}" var="tiers">
                    <tr>
                       
                        <td><c:out value="${tiers.numCompte}"/></td>
                        <td><c:out value="${tiers.actif}"/></td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
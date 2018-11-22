<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
        <title><spring:message code="titre"/> - <spring:message code="carteBancaire.titre"/></title>
    </head>
    <body>
    	<h1><spring:message code="carteBancaire.titre"/></h1>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="carteBancaire.colonne.identifiant"/></th>
                    <th><spring:message code="carteBancaire.colonne.num"/></th>
                    <th><spring:message code="carteBancaire.colonne.type"/></th>
                     <th><spring:message code="carteBancaire.colonne.echeance"/></th>
                      <th><spring:message code="carteBancaire.colonne.code"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${carteBancaires}" var="carteBancaire">
                    <tr>
                        <td><c:out value="${carteBancaire.idC}"/></td>
                        <td><c:out value="${carteBancaire.num_carte}"/></td>
                        <td><c:out value="${carteBancaire.type_carte}"/></td>
                         <td><c:out value="${carteBancaire.echeance}"/></td>
                        <td><c:out value="${carteBancaire.code_crypto}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
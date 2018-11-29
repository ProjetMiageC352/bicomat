<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>

<a href="/bicomat/compteAgency/creer"><spring:message code="compteAgency.lien.creation"/></a>

<h1><spring:message code="compteAgency.liste.titre"/></h1>

<div class="col-xs-10 col-xs-offset-1">
	<table class="table table-bordered">
		<thead>
		    <tr>
		        <th><spring:message code="compteAgency.colonne.identifiant"/></th>
		        <th><spring:message code="compteAgency.colonne.nom"/></th>
		        <th><spring:message code="compteAgency.colonne.prenom"/></th>
		        <th><spring:message code="compteAgency.colonne.num_contrat"/></th>
		        <th><spring:message code="compteAgency.colonne.login"/></th>
		        <th><spring:message code="compteAgency.colonne.action"/></th>
		    </tr>
		</thead>
		<tbody>
		    <c:forEach items="${clients}" var="client">
		        <tr>
		            <td><c:out value="${client.id}"/></td>
		            <td><c:out value="${client.nom}"/></td>
		            <td><c:out value="${client.prenom}"/></td>
		            <td><c:out value="${client.num_contrat}"/></td>
		            <td><c:out value="${client.login}"/></td>
		            <td>
		            <c:if test = "${client.login == ''}">
				    	<a href="/bicomat/compteAgency/creer/<c:out value="${client.nom}"/>/<c:out value="${client.prenom}"/>/<c:out value="${client.num_contrat}"/>"><spring:message code="compteAgency.lien.modification"/></a>
				    </c:if>
		            </td>
		        </tr>
		    </c:forEach>
	    </tbody>
	</table>
</div>

<%@ include file="../_shared/footer.jsp" %>
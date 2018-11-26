<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>

<h1><spring:message code="virement.liste.titre"/></h1>

<c:if test = "${not empty erreur}">
	<p class="alert alert-danger"><c:out value="${erreur}"/></p>
</c:if>


<div class="col-xs-10 col-xs-offset-1">
	<table class="table table-bordered">
		<thead>
		    <tr>
		        <th><spring:message code="virement.colonne.identifiant"/></th>
		        <th><spring:message code="virement.colonne.nom"/></th>
		        <th><spring:message code="virement.colonne.prenom"/></th>
		        <th><spring:message code="virement.colonne.num_contrat"/></th>
		        <th><spring:message code="virement.colonne.action"/></th>
		    </tr>
		</thead>
		<tbody>
		    <c:forEach items="${clients}" var="client">
		        <tr>
		            <td><c:out value="${client.id}"/></td>
		            <td><c:out value="${client.nom}"/></td>
		            <td><c:out value="${client.prenom}"/></td>
		            <td><c:out value="${client.num_contrat}"/></td>
		            <td><a href="/bicomat/virement/creer/<c:out value="${client.id}"/>"><spring:message code="virement.lien.virement"/></a></td>
		        </tr>
		    </c:forEach>
	    </tbody>
	</table>
</div>

<%@ include file="../_shared/footer.jsp" %>
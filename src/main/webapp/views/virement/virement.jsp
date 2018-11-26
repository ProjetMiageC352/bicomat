<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>

<h1><spring:message code="virement.creation.titre"/></h1>

<c:if test = "${not empty erreur}">
	<p class="alert alert-danger"><c:out value="${erreur}"/></p>
</c:if>

<form method="post" action="/bicomat/virement/virement">
	<p class="badge badge-secondary">Renseigner les champs suivants</p>
	<fieldset>
		<div class="form-group row">
			<label class="col-sm-1 col-form-label"><spring:message code="virement.form.source" /></label>
 			<div class="col-sm-5">
 				<select id="cpteSource" name="cpteSource">
 					<c:forEach items="${comptes}" var="compte">
				        <option><c:out value="${compte.id}"/></option>
				    </c:forEach>
 				</select>
  			</div>
  		</div>

		<div class="col-sm-3">
	        <input  type="submit" value="Valider" class="btn btn-primary" />
	        <input  type="reset" value="Annuler" class="btn btn-primary" />
        </div>
    </fieldset>
</form>

<%@ include file="../_shared/footer.jsp" %>
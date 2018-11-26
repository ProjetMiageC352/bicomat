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

<form method="post" action="/bicomat/virement/creer" class="col-xs-8 col-xs-offset-2">
	<p class="badge badge-secondary">Renseigner les champs suivants</p>
	<fieldset>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label"><spring:message code="virement.form.source" /></label>
 			<div class="col-sm-10">
 				<select id="cpteSource" name="cpteSource" class="col-sm-12">
 					<c:forEach items="${comptes}" var="compte">
				        <option value="<c:out value="${compte.id}"/>">
				        	<c:out value="${compte.type}"/> - <c:out value="${compte.id}"/> (<c:out value="${compte.solde}"/> euros)
				        </option>
				    </c:forEach>
 				</select>
  			</div>
  		</div>
  		
  		<div class="form-group row">
			<label class="col-sm-2 col-form-label"><spring:message code="virement.form.destinataire" /></label>
 			<div class="col-sm-10">
 				<select id="cpteDestination" name="cpteDestination" class="col-sm-12">
 					<c:forEach items="${comptes}" var="compte">
				        <option value="<c:out value="${compte.id}"/>">
				        	<c:out value="${compte.type}"/> - <c:out value="${compte.id}"/> (<c:out value="${compte.solde}"/> euros)
				        </option>
				    </c:forEach>
 				</select>
  			</div>
  		</div>
  		
  		<div class="form-group row">
  			<label class="col-sm-2 col-form-label"><spring:message code="virement.form.montant" /></label>
 			<div class="col-sm-10">
  				<input required id="montant" name="montant" type="number" class="form-control" placeholder="<spring:message code="virement.form.montant" />" aria-describedby="basic-addon1" />
        	</div>
        </div>

		<div class="text-center">
	        <input  type="submit" value="Valider" class="btn btn-primary" />
	        <input  type="reset" value="Annuler" class="btn btn-primary" />
        </div>
    </fieldset>
</form>

<%@ include file="../_shared/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>

<h1><spring:message code="compteAgency.creation.titre"/></h1>

<c:if test = "${not empty erreur}">
	<p class="alert alert-danger"><c:out value="${erreur}"/></p>
</c:if>


<form method="post" action="/bicomat/compteAgency/creer" class="col-xs-8 col-xs-offset-2">
	<p class="badge badge-secondary">Renseigner les champs suivants</p>
	<fieldset> 
 		<div class="form-group row">
			<label class="col-sm-2 col-form-label"><spring:message code="compteAgency.form.nom" /></label>
 			<div class="col-sm-10">
 				<input required id="nom" name="nom" type="text" class="form-control" placeholder="<spring:message code="compteAgency.form.nom" />"
 					<c:if test = "${nom != ''}">
				    	value="<c:out value="${nom}"/>"
				    </c:if>
 					aria-describedby="basic-addon1" />
  			</div>
  		</div>

		<div class="form-group row">
			<label class="col-sm-2 col-form-label"><spring:message code="compteAgency.form.prenom" /></label>
			<div class="col-sm-10">
  				<input required id="prenom" name="prenom" type="text" class="form-control" placeholder="<spring:message code="compteAgency.form.prenom" />"
  					<c:if test = "${prenom != ''}">
				    	value="<c:out value="${prenom}"/>"
				   	</c:if>
				    aria-describedby="basic-addon1"  />
  			</div>
  		</div>
  		
 		<div class="form-group row">
  			<label class="col-sm-2 col-form-label"><spring:message code="compteAgency.form.num_contrat" /></label>
 			<div class="col-sm-10">
  				<input required id="num_contrat" name="num_contrat" type="number" class="form-control" placeholder="<spring:message code="compteAgency.form.num_contrat" />"
  					<c:if test = "${num_contrat != ''}">
				    	value="<c:out value="${num_contrat}"/>"
				   	</c:if>
  					aria-describedby="basic-addon1" />
        	</div>
        </div>
        
        <div class="form-group row">
  			<label class="col-sm-2 col-form-label"><spring:message code="compteAgency.form.password" /></label>
 			<div class="col-sm-10">
  				<input required id="password" name="password" type="text" class="form-control" placeholder="<spring:message code="compteAgency.form.password" />"
  					<c:if test = "${password != ''}">
				    	value="<c:out value="${password}"/>"
				   	</c:if>
  					aria-describedby="basic-addon1" />
        	</div>
        </div>
     
		<div class="text-center">
	        <input  type="submit" value="Valider" class="btn btn-primary" />
	        <input  type="reset" value="Annuler" class="btn btn-primary" />
        </div>
    </fieldset>
</form>

<%@ include file="../_shared/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="_shared/header.jsp" %>

<form method="post" action="connexion">
    <fieldset>
        <legend><h1> <div class="col-sm-1"></div><spring:message code="connexion.titre"/></h1></legend>
        <div class="col-sm-1"></div>
        <p class="badge badge-secondary"><spring:message code="connexion.form.message"/></p>
<div class="form-group row">
                <div class="col-sm-1"></div>
        <label class="col-sm-1 col-form-label"  for="login"><spring:message code="connexion.form.libelle.login"/></label>
        <div class="col-sm-3">
        <input required id="login" name="login" class="form-control" placeholder="Login" aria-describedby="basic-addon1" />
        <span class="erreur">${form.erreurs['login']}</span>
        </div>
                </div>
 <div class="form-group row">
           		 <div class="col-sm-1"></div>
        <label class="col-sm-1 col-form-label" for="password"><spring:message code="connexion.form.libelle.password"/></label>
       <div class="col-sm-3">
        <input required class="form-control" type="password" id="password" name="password" aria-describedby="basic-addon1" placeholder="Password" />
        <span class="erreur">${form.erreurs['password']}</span>
         </div>
         </div>

        <div class="col-sm-3"></div>
                <input  type="submit" value="Valider" class="btn btn-primary" />
                <input  type="reset" value="Annuler" class="btn btn-primary" />
    </fieldset>
</form>

<%@ include file="_shared/footer.jsp" %>
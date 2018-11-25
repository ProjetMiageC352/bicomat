<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="_shared/header.jsp" %>

<form method="post" action="connexion">
    <fieldset>
        <legend>Connexion</legend>
        <p>Vous pouvez vous connecter via ce formulaire.</p>

        <label for="login"><spring:message code="connexion.form.libelle.login"/></label>
        <input id="login" name="login" size="20" maxlength="60" />
        <span class="erreur">${form.erreurs['login']}</span>
        <br />

        <label for="password"><spring:message code="connexion.form.libelle.password"/></label>
        <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['password']}</span>
        <br />

        <input type="submit" value="Connexion" />
        <br />
    </fieldset>
</form>

<%@ include file="_shared/footer.jsp" %>
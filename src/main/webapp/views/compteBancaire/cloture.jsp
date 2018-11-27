<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>

<legend>
<div class="col-sm-1"></div><h4>Libellé du compte: <c:if test = "${type != ''}"><c:out value="${type}"/> </c:if></h4>
<div class="col-sm-1"></div><h4>Solde: <c:if test = "${solde != ''}"><c:out value="${solde}"/> </c:if> €</h4></legend>

 
 <div class="col-sm-1"></div><h5 >Clôture du compte ${type_compte}</h5>
 <div class="col-sm-1"></div><h6 >La clôture du compte entrainera un virement de solde vers le compte courant.</h6>
 <form method="post" action="/bicomat/compteBancaire/cloture" >
 <input type="hidden" id="id_compte" name="id_compte" value="${id}">
 <input type="hidden" id="montant" name="montant" value="${solde}">
 <input type="hidden" id="type" name="type" value="${type}">
 <input type="hidden" id="id_client" name="id_client" value="${id_client}">
 <input type="hidden" id="nom" name="nom" value="${nom}">
 <input type="hidden" id="prenom" name="prenom" value="${prenom}">
 <input type="hidden" id="num_contrat" name="num_contrat" value="${num_contrat}">
 <div class="col-sm-1"></div><input  type="submit" value="Valider" class="btn btn-primary" />
  <input  type="reset" value="Annuler" class="btn btn-primary" />
 </form>
<%@ include file="../_shared/footer.jsp" %>

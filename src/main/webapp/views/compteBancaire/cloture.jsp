<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>

<legend><div class="col-sm-1"></div><h3><c:if test = "${nom != ''}"><c:out value="${nom}"/> </c:if><c:if test = "${prenom != ''}"><c:out value="${prenom}"/> </c:if></h3>
<div class="col-sm-1"></div><h4>Libellé du compte: <c:if test = "${type_compte != ''}"><c:out value="${type_compte}"/> </c:if></h4>
<div class="col-sm-1"></div><h4>Solde: <c:if test = "${solde != ''}"><c:out value="${solde}"/> </c:if> €</h4></legend>

 
 <div class="col-sm-1"></div><h5 >Clôture du compte ${type_compte}</h5>
 <div class="col-sm-1"></div><h6 >La clôture du compte entrainera un virement de solde vers le compte courant.</h6>
 <form method="post" action="cloturercompte">
 <input type="HIDDEN" id="id_compte" name="id_compte" value="">
 <input type="HIDDEN" id="montant" name="montant" value="">
 </form>
<%@ include file="../_shared/footer.jsp" %>

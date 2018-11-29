<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>

<legend><div class="col-sm-1"></div><h3><c:if test = "${nom != ''}"><c:out value="${nom}"/> </c:if><c:if test = "${prenom != ''}"><c:out value="${prenom}"/> </c:if></h3>
<div class="col-sm-1"></div><h4>Libellé du compte: <c:if test = "${type_compte != ''}"><c:out value="${type_compte}"/> </c:if></h4>
<div class="col-sm-1"></div><h4>Solde: <c:if test = "${solde != ''}"><c:out value="${solde}"/> </c:if> €</h4></legend>

 
 <div class="col-sm-1"></div><h5 >Liste des opérations</h5>
 <div class="col-sm-1"></div>
 <table  class="table table-bordered" style="width:80%;">
            <thead>
                <tr>
                    <th scope="col" style="width:10%;">Date</th>
                    <th scope="col">Type</th>
                    <th scope="col" style="width:20%;">Montant</th>
                </tr>
            </thead>
			<tbody>
				
                <c:forEach items="${operations}" var="operations">
                    <tr>      
                        <td class="col-sm-2"><fmt:formatDate value="${operations.date}" pattern="dd/MM/yyyy" /></td>                        
                        <td><c:out value="${operations.type}"/></td>
                        <td><c:out value="${operations.montant}"/> €</td>                    
                    </tr>
                </c:forEach>
            </tbody>
</table>
<%@ include file="../_shared/footer.jsp" %>

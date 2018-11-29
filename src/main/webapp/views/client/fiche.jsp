<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>

<legend><div class="col-sm-1"></div><h3><c:if test = "${nom != ''}"><c:out value="${nom}"/> </c:if><c:if test = "${prenom != ''}"><c:out value="${prenom}"/> </c:if></h3>
<div class="col-sm-1"></div><h4>Numéro de contrat: <c:if test = "${num_contrat != ''}"><c:out value="${num_contrat}"/> </c:if></h4>
<div class="col-sm-1"></div><h4>Mail :<a href="mailto:${mail}" ><c:if test = "${mail != ''}"><c:out value="${mail}"/> </c:if></a></h4>
<div class="col-sm-1"></div><h4>Téléphone :<c:if test = "${tel != ''}"><c:out value="${tel}"/> </c:if></h4>
<div class="col-sm-1"></div><h4>Compte Agency : ${login!='' ? 'Oui': 'Non'}</h4>

</legend>

 
 <div class="col-sm-1"></div><h5 >Liste des comptes</h5>
 <div class="col-sm-1"></div>
 <table  class="table table-bordered" style="width:80%;">
            <thead>
                <tr>
                    <th scope="col">Type</th>
                    <th scope="col">Découvert</th>
                    <th scope="col">Solde</th>
                    <th scope="col">Actif</th>
                    <th  colspan="2" style="text-align:center;" >Actions </th>         
                </tr>
            </thead>
			<tbody>
                <c:forEach items="${comptes}" var="comptes">
                    <tr>      
                        <td><c:out value="${comptes.type}"/></td>
                        <td><c:out value="${comptes.decouvert==true ? 'Oui': 'Non'}"/></td>
                        <td><c:out value="${comptes.solde}"/> €</td>
                        <td><c:out value="${comptes.actif==true ? 'Oui': 'Non'}"/></td>
                        <td width="80px"><a href="/bicomat/client/operation/<c:out value="${nom}"/>/<c:out value="${prenom}"/>/<c:out value="${comptes.id}"/>"">Opérations</a></td>
                        <td width="80px">
                        <a href="/bicomat/compteBancaire/cloture/<c:out value="${comptes.id}"/>&<c:out value="${comptes.idClient}"/>&<c:out value="${nom}"/>&<c:out value="${prenom}"/>&<c:out value="${num_contrat}"/>">
                        <c:if test = "${comptes.type != 'Courant'}">
				    	Cloturer
				    	</c:if>
				    	</a>
				    	</td>                        
                    </tr>
                </c:forEach>
            </tbody>
</table>
 <div class="col-sm-1"></div><h5 ><a href="/bicomat/compteBancaire/creercompteBancaire/<c:out value="${nom}"/>&<c:out value="${prenom}"/>&<c:out value="${num_contrat}"/>&<c:out value="${id}"/>">Creer un compte</a></h5>
<%@ include file="../_shared/footer.jsp" %>

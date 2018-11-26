
<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>  
  
 <legend><h1><spring:message code="compte.titre"/></h1></legend>
<div class="col-sm-1"></div>

<table class="table table-bordered" style="width:80%;">
    <thead >
        <tr >
            <th scope="col"><spring:message code="compte.colonne.identifiant"/></th>
            <th scope="col"><spring:message code="compte.colonne.type"/></th>
            <th scope="col"><spring:message code="compte.colonne.decouvert"/></th>
            <th scope="col"><spring:message code="compte.colonne.solde"/></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${comptes}" var="compte">
            <tr>
                <td ><c:out value="${compte.id}"/></td>
                <td><c:out value="${compte.type}"/></td>
                <td><c:out value="${compte.decouvert==true ? 'Oui': 'Non'}"/></td>
                <td><c:out value="${compte.solde}"/></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@ include file="../_shared/footer.jsp" %>
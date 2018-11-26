<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>

<legend><div class="col-sm-1"></div><h3><c:if test = "${nom != ''}"><c:out value="${nom}"/> </c:if><c:if test = "${prenom != ''}"><c:out value="${prenom}"/> </c:if></h3>
<div class="col-sm-1"></div><h4>Numéro de contrat: <c:if test = "${num_contrat != ''}"><c:out value="${num_contrat}"/> </c:if></h4></legend>

 <div class="col-sm-1"></div> <table  class="table table-bordered" style="width:80%;">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Type</th>
                    <th scope="col">Découvert</th>
                    <th scope="col">Solde</th>
                    <th scope="col">Actif</th>
                    <th  width="50px"></th>
                    <th width="50px" ></th>
                </tr>
            </thead>


<tbody>
                <c:forEach items="${comptes}" var="comptes">
                    <tr>
                        <th scope="row"><c:out value="${comptes.id}"/></th>
                        <td><c:out value="${comptes.type}"/></td>
                        <td><c:out value="${comptes.decouvert==true ? 'Oui': 'Non'}"/></td>
                        <td><c:out value="${comptes.solde}"/></td>
                        <td><c:out value="${comptes.actif==true ? 'Oui': 'Non'}"/></td>
                        <td>Opérations</td>
                        <td>Fermer</td>
                        
                    </tr>
                </c:forEach>
            </tbody>
</table>
<%@ include file="../_shared/footer.jsp" %>

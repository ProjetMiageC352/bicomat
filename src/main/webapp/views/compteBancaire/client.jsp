
<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>  

<h1><spring:message code="client.titre"/></h1>
<div class="col-sm-1"></div>
        <table  class="table table-bordered" style="width:80%;">
            <thead>
                <tr>
                    <th scope="col"><spring:message code="client.colonne.identifiant"/></th>
                    <th scope="col"><spring:message code="client.colonne.nom"/></th>
                    <th scope="col"><spring:message code="client.colonne.prenom"/></th>
                    <th scope="col"><spring:message code="client.colonne.adresse"/></th>
                    <th scope="col"><spring:message code="client.colonne.tel"/></th>
                    <th scope="col" ><spring:message code="client.colonne.contrat"/></th>
                    <th scope="col"><spring:message code="client.colonne.conseiller"/></th>
                    <th scope="col"><spring:message code="client.colonne.login"/></th>
                    <th scope="col"><spring:message code="client.colonne.password"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clients}" var="client">
                    <tr>
                        <th scope="row"><c:out value="${client.id}"/></th>
                        <td><c:out value="${client.nom}"/></td>
                        <td><c:out value="${client.prenom}"/></td>
                        <td><c:out value="${client.adresse_mail}"/></td>
                        <td><c:out value="${client.tel_client}"/></td>
                        <td><c:out value="${client.num_contrat}"/></td>
                        <td><c:out value="${client.id_conseiller}"/></td>
                        <td><c:out value="${client.login}"/></td>
                        <td><c:out value="${client.password}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
<%@ include file="../_shared/footer.jsp" %>  
 
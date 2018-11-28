
<%@ include file="../_shared/header.jsp" %>
 <%@ include file="../_shared/menu.jsp" %>   
    
    	<legend><h1><div class="col-sm-1"></div><spring:message code="tiers.titre"/></h1></legend>
    	<div class="col-sm-1"></div>
        <table class="table table-bordered" style="width:80%;">
            <thead>
                <tr>
                	<th scope="col"><spring:message code="tiers.colonne.nom"/></th>
                    <th scope="col"><spring:message code="tiers.colonne.prenom"/></th>
                    <th scope="col"><spring:message code="tiers.colonne.compte"/></th>
                    <th scope="col"><spring:message code="tiers.colonne.nomclient"/></th>
                    
            
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${Tiers}" var="tiers">
                    <tr>
                    	<th scope="row"><c:out value="${tiers.nom}"/></th>
                       	<td><c:out value="${tiers.prenom}"/></td>
                        <td><c:out value="${tiers.numCompte}"/></td>
                        <c:forEach items="${clients}" var="client">
                        	<c:if test = "${tiers.idclientT == client.id}">
                         <td><c:out value="${client.nom} ${client.prenom}"/></td>
                       </c:if>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
   <%@ include file="../_shared/footer.jsp" %>
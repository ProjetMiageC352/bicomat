   	<h1><spring:message code="operation.titre"/></h1>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="operation.colonne.identifiant"/></th>
                    <th><spring:message code="operation.colonne.date"/></th>
                    <th><spring:message code="operation.colonne.montant"/></th>
                    <th><spring:message code="operation.colonne.type"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${operations}" var="operation">
                    <tr>
                        <td><c:out value="${operation.id}"/></td>
                        <td><c:out value="${operation.date}"/></td>
                        <td><c:out value="${operation.montant}"/></td>
                        <td><c:out value="${operation.type}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

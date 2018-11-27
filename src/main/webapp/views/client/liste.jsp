<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ include file="../_shared/header.jsp" %>
 <%@ include file="../_shared/menu.jsp" %>  


    <legend><h1><div class="col-sm-1"></div><spring:message code="client.titre"/></h1></legend>
        <div class="col-sm-1"></div>
        <table  class="table table-bordered" style="width:80%;">
            <thead>
                <tr>
                    <th scope="col">Numéro</th>
                    <th scope="col"><spring:message code="client.colonne.nom"/></th>
                    <th scope="col"><spring:message code="client.colonne.prenom"/></th>
                    <th scope="col"><spring:message code="client.colonne.adresse"/></th>
                    <th scope="col"><spring:message code="client.colonne.tel"/></th>
                    <th scope="col" ><spring:message code="client.colonne.contrat"/></th>
                    <th scope="col"><spring:message code="client.colonne.conseiller"/></th>
                    <th scope="col"><spring:message code="client.colonne.login"/></th>
                    <th scope="col"></th>
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
                        <td><c:out value="${client.login!='' ? 'Oui': 'Non'}"/></td>
                        
                        <td><a href="./client/fiche/<c:out value="${client.nom}"/>&<c:out value="${client.prenom}"/>&<c:out value="${client.num_contrat}"/>&<c:out value="${client.id}"/>&<c:out value="${client.adresse_mail}"/>&<c:out value="${client.tel_client}"/>&<c:out value="${client.login}"/>">Ouvrir</a></td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
 

<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>


<body>               
	<legend><h1> <div class="col-sm-1"></div>Créér un compte</h1></legend>
	
	 <c:if test = "${not empty etatCompte}">
	<p class="alert alert-danger"><c:out value="${etatCompte}"/></p></c:if>
	<div class="col-sm-1"></div>
		<p class="badge badge-secondary" >Renseigner les champs suivants</p>
		<form method="post" action="/bicomat/compteBancaire/creercompteBancaire">
			<fieldset> 
			<div class="form-group row">
			<div class="col-sm-1"></div>
				<label class="col-sm-1 col-form-label" >Nom</label>
			<div class="col-sm-5">
				<input   required id="nom" name="nom" type="text" class="form-control" placeholder="Nom" aria-describedby="basic-addon1" value="${nom}"/>
			</div>
			</div>
			<div class="form-group row">
			<div class="col-sm-1"></div>
				<label class="col-sm-1 col-form-label" >Prenom</label>
       		<div class="col-sm-5">
            	<input  required class="form-control" placeholder="Prenom" aria-describedby="basic-addon1" id="prenom" name="prenom"  value="${prenom}"/>
            </div>
            </div>
            <div class="form-group row">
            <div class="col-sm-1"></div>
       		 	<label class="col-sm-1 col-form-label" >Numéro du contrat</label>
       		<div class="col-sm-5">
            	<input  required class="form-control" placeholder="Numéro du contrat" aria-describedby="basic-addon1" id="num" name="num" value="${num_contrat}" />
			</div>
            </div>
             <div class="form-group row">
            <div class="col-sm-1"></div>
       		 	<label class="col-sm-1 col-form-label" >Banque</label>
       		<div class="col-sm-5">
				<select required class="form-control" name="banque" id="banque">
  					<option selected disabled >Choisir</option>
	      			<c:forEach items="${Banques}" var="banque">
           		 	<option value="${banque.id}">${banque.nom}</option>
	          	</c:forEach>
				</select>
     		</div>
            </div>
            <div class="form-group row">
            <div class="col-sm-1"></div>
       		 	<label class="col-sm-1 col-form-label" >Type de compte</label>
       		<div class="col-sm-5">
				<select required class="form-control" name="type" id="type">
  					<option selected disabled >Choisir</option>
	      			<option>Courant</option>
	      			<option>Livret A</option>
	      			<option>Livret Developpement Durable</option>
	      			<option>Compte Epargne Logement</option>
				</select>
     		</div>
            </div>
            <div class="form-group row">
            <div class="col-sm-1"></div>
       		 	<label class="col-sm-1 col-form-label" >Découvert autorisé</label>
       		<div class="col-sm-5">
				<select required class="form-control" name="decouvert" id="decouvert">
  					<option selected disabled >Choisir</option>
	      			<option value=true>Oui</option>
	      			<option value=false>Non</option>
				</select>
     		</div>
            </div>
            <div class="form-group row">
            <div class="col-sm-1"></div>
       		 	<label class="col-sm-1 col-form-label" >Montant</label>
       		<div class="col-sm-5">
         		<input required class="form-control" placeholder="Montant" aria-describedby="basic-addon1" type="number" id="montant" name="montant" />
			</div>
            </div>
            <input  type="hidden" name="idclient" id="idclient" value="${idclient}"/>
    		<div class="col-sm-3"></div>
            	<input  type="submit" value="Valider" class="btn btn-primary" />
            	<input  type="reset" value="Annuler" class="btn btn-primary" />
    		
        </fieldset>
    </form>
</body>

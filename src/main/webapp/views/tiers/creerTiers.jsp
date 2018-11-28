<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>
 
        <form method="post" action="">
        
            
            
                <legend><h1> <div class="col-sm-1"></div>Créer un tiers</h1></legend>
                <c:if test = "${not empty etatTiers}">
	<p class="alert alert-success"><c:out value="${etatTiers}"/></p>
</c:if>
                  
                <div class="col-sm-1"></div>
                <p class="badge badge-secondary" >Renseigner les champs suivants</p>
               <fieldset> 
                <div class="form-group row">
                <div class="col-sm-1"></div>
                <label class="col-sm-1 col-form-label" >Nom</label>
                <div class="col-sm-5">
                <input  required id="nom" name="nom" type="text" class="form-control" placeholder="Nom" aria-describedby="basic-addon1" />
          
                </div>
                </div>
                
           		 <div class="form-group row">
           		 <div class="col-sm-1"></div>
           		 <label class="col-sm-1 col-form-label" >Prenom</label>
           		 <div class="col-sm-5">
                <input required class="form-control" placeholder="Prenom" aria-describedby="basic-addon1" id="prenom" name="prenom"  />
                
                </div>
                </div>
                <div class="form-group row">
                <div class="col-sm-1"></div>
           		 <label class="col-sm-1 col-form-label" >Numéro de compte</label>
           		  <div class="col-sm-5">
                <input required class="form-control" placeholder="Numéro de compte" aria-describedby="basic-addon1" id="num" name="num"  />
                
                </div>
                </div>
                <div class="form-group row">
                <div class="col-sm-1"></div>
           		 <label class="col-sm-1 col-form-label" >Client</label>
           		 <div class="col-sm-5">
           		   <select required class="form-control" placeholder="Client" aria-describedby="basic-addon1"  name="id_client" id="id_client">
           		   <option disabled selected >Choisir</option>
           		 <c:forEach items="${clients}" var="client">
           		 	<option value="${client.id}">${client.nom} ${client.prenom}</option>
	          	</c:forEach>
	        	</select>
	        	</div>
                </div>
                

        		<div class="col-sm-3"></div>
                <input  type="submit" value="Valider" class="btn btn-primary" />
                <input  type="reset" value="Annuler" class="btn btn-primary" />
        		
                
            
            </fieldset>
        </form>
        

<%@ include file="../_shared/footer.jsp" %>
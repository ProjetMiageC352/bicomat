<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../_shared/header.jsp" %>
<%@ include file="../_shared/menu.jsp" %>
 
        <form method="post" action="creertiers">
        
            
            
                <legend><h1> <div class="col-sm-1"></div>Créer un tiers</h1></legend>
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
           		 <label class="col-sm-1 col-form-label" >Id du client</label>
           		 <div class="col-sm-5">
	            <input required class="form-control" placeholder="Id du client" aria-describedby="basic-addon1" type="text" name="id_client" id="id_client" />
	        	
	        	</div>
                </div>
                

        		<div class="col-sm-3"></div>
                <input  type="submit" value="Valider" class="btn btn-primary" />
                <input  type="reset" value="Annuler" class="btn btn-primary" />
        		
                
            
            </fieldset>
        </form>
        
        <p><c:out value="${etatTiers}"/></p>

<%@ include file="../_shared/footer.jsp" %>
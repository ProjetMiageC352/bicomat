<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<nav class="navbar navbar-default">
	<div class="container-fluid">  
		<div class="navbar-header col-12 col-sm-1 col-lg-2">
			<a class="navbar-brand" href="/bicomat/accueil">BICOMAT</a>
		</div>
		
		<ul class="nav navbar-nav">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" >Comptes Agency<span class="caret"></span></a>
				<ul class="dropdown-menu">
				 	<li><a href="/bicomat/compteAgency">Liste des comptes agency</a></li>
          			<li><a href="/bicomat/compteAgency/creer">Creer un compte agency</a></li>
   
        		</ul>
        	</li>
        	<li class="dropdown">
        		<a class="dropdown-toggle" data-toggle="dropdown" >Comptes<span class="caret"></span></a>
        		<ul class="dropdown-menu">
        			<li><a href="/bicomat/listeclients" >Liste des clients</a></li>
          			<li><a href="/bicomat/virement">Virements</a></li>
        		</ul>
        	</li>
        	<li class="dropdown">
        		<a class="dropdown-toggle" data-toggle="dropdown" >Tiers<span class="caret"></span></a>
        		<ul class="dropdown-menu">
        			<li><a href="/bicomat/tiers">Liste des tiers</a></li>
        			<li><a href="/bicomat/creertiers" >Créer un tiers</a></li>
        		</ul>
        	</li>
        	<li>
        		<a href="/bicomat/deconnexion">Déconnexion</a>
        	</li>
    	</ul>
	</div>	
</nav>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<nav class="navbar navbar-default">
	<div class="container-fluid">  
		<div class="navbar-header col-12 col-sm-1 col-lg-2">
		<a class="navbar-brand" href="accueil">Accueil</a>
		</div>
			<div class="collapse navbar-collapse" >
				<div class="nav navbar-nav col-12 col-sm-1 col-lg-2">
					<a class="navbar-brand" href="compteAgency">Comptes Agency</a>
				</div>
				<div class="col-12 col-sm-1 col-lg-2">
					<a class="navbar-brand" href="comptes">Comptes</a>
				</div>
				<div class="col-12 col-sm-1 col-lg-2">
					<a class="navbar-brand" href="/bicomat/creertiers">Tiers</a>
				</div>
				<div class="col-12 col-sm-1 col-lg-2">
					<a class="navbar-brand" href="/bicomat/views/connexion.jsp">Déconnexion</a>
				</div>		
			</div>
		
	</div>
</nav>
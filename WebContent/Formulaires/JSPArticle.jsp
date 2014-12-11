<%@page import="com.afpa59.patrice.utils.ConnectionFichiersArticles"%>
<%@page import="com.afpa59.patrice.service.fichier.ServiceArticle"%>
<%@page import="com.afpa59.patrice.utils.DateUser"%>

<%@page import="com.afpa59.patrice.donnees.Article"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="Form.css">
		<title>JSP OK</title>
	</head>
		<body>

<%-- 	<jsp:include page="/ServletEntete" > </jsp:include> --%>

			<br><br>

			<% ServiceArticle serviceArt = new ServiceArticle(); %>
			<% DateUser dateJour = new DateUser(); %>
			
			<% ConnectionFichiersArticles fichArt; %>
			<% String nomPhysiqueArticle = "C:/Users/afpa1653/Documents/GitHub/ProjetGestionCommandes/TableArticles"; %>
			<% fichArt = new ConnectionFichiersArticles(nomPhysiqueArticle); %>
			<% serviceArt = fichArt.getTab(); %>
					
			
			Affichage des articles: 
			
			<br><br>
			
			<%=  serviceArt.toString().replace("\n", "<br>") %> 
		
			<br><br>
			
			<table>
				<thead>
					<tr>
						<th> Code </th>
						<th> Désignation </th>
						<th> Prix </th>
					</tr>
				</thead>
			
				<tbody>
				
					<% for(Article art : serviceArt.getTabArticle()){ %>
						
						<tr>
							
							<td> <%= art.getCode() %> </td>
							<td> <%= art.getDesignation() %> </td>
							<td> <%= art.getPrix() %> </td>
						
						</tr>
						
					<% } %>
					
				</tbody>
				
				<tfoot>
				
					<tr>
						<th colspan="3" align="right" style="font-size: xx-small;">
							<%= "Copyright © "+ dateJour.getAnnee() %>
						</th>
					</tr>
					
				</tfoot>
			
			</table>
			
			
			<br><br>
			
			Nbre d'articles <%= serviceArt.getTabArticle().size() %>
			
			<br><br>

			Hauteur du panier <%= session.getAttribute("monCompteur") %>
			
			<jsp:useBean id="Service" class="com.afpa59.patrice.service.fichier.ServiceArticle" scope="session"/>
			
			<br><br>
			
			<a href='SaisieArticle.html'> Retour Formulaires SaisieArticle</a>
			
<%-- 			<jsp:include page="/ServletPied" > --%>
<%-- 				<jsp:param name="year" value="2014"/> --%>
<%-- 			</jsp:include> --%>
			
<%-- 			Année <%= request.getParameter("year") %> --%>
			
		</body>
</html>
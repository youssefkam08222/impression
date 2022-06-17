<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Plateforme gestion d'une imprimerie</title>
</head>
<body>
 <div class="container">
  <h1>Gestion des demandes</h1>
        <h2>
         <a href="new">Ajouter demande</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">Consulter demandes</a>
         
        </h2>
 </div>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Liste des demandes</h2></caption>
            <tr>
                <th>ID</th>
                <th>Matiere</th>
                <th>Groupe</th>
                <th>Nombre de copies</th>
                <th>Date Arrivée</th>
                <th>Enseignant</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="demande" items="${listDemandes}">
                <tr>
                    <td><c:out value="${demande.idDemande}" /></td>
                    <td><c:out value="${demande.matiere}" /></td>
                    <td><c:out value="${demande.groupe}" /></td>
                    <td><c:out value="${demande.nb_copies}" /></td>
                    <td><c:out value="${demande.date_arrivee}" /></td>
                    <td><c:out value="${demande.enseignant}" /></td>
                    <td>
                     <a href="delete?idDemande=<c:out value='${user.idDemande}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>
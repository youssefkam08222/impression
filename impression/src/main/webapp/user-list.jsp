<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: pink;  
}  
button {   
       background-color: #4CAF50;   
       width: 100%;  
        color: orange;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 3px solid #f1f1f1;   
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 button:hover {   
        opacity: 0.7;   
    }   
  .cancelbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
        
     
 .container {   
        padding: 25px;   
        background-color: lightblue;  
    }   
</style>   
</head>    
<body>
 <center>
  <h1> Gestion des utilisateurs</h1>
        <h2>
         <a href="user-form.jsp">Ajouter</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Users</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Identifiant</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Login</th>
                <th>Rôle</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.idPersonne}" /></td>
                    <td><c:out value="${user.nom}" /></td>
                    <td><c:out value="${user.prenom}" /></td>
                     <td><c:out value="${user.login}" /></td>                    
                    <td><c:out value="${user.type_personne}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${user.idPersonne}' />">Modifier</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="updateStatus?id&false=<c:out value='${user.idPersonne}' />">Désactiver</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>
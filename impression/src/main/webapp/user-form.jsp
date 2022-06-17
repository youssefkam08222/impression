<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Ajouter une personne </title>  
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
<jsp:useBean id="u" class="tn.iit.models.Personne" scope="session"></jsp:useBean>
   
    <center> <h1> Ajouter une personne  </h1> </center>   
    <% if (request.getAttribute("error") != null) { %>
		<font size="3" color="red"><%=request.getAttribute("error") %></font>
	<%} %>
    <form method='post' action='insert'>  
        <div class="container">
        
        label>Name : </label>  
          <label>Rôle : </label>
          <!--  elect name="type_personne">
    		<option value="Enseignant">Enseignant</option>
    		<option value="AgentDeTirage">Agent de tirage</option>
          </select> --> 
            <input type="text" placeholder="choisir le type " name="type_personne" required value='<jsp:getProperty property="type_personne" name="u"/>'>   
            <label>Name : </label>   
            <input type="text" placeholder="Entrer le nom " name="nom" required value='<jsp:getProperty property="nom" name="u"/>'>  
            <label>Undername : </label>   
            <input type="text" placeholder="Enter the prénom " name="prenom" required value='<jsp:getProperty property="prenom" name="u"/>'>  
            <label>Username : </label>   
            <input type="text" placeholder="Entrer le login " name="login" required value='<jsp:getProperty property="login" name="u"/>'>  
            <label>Password : </label>   
            <input type="password" placeholder="Entrer le mot de passe " name="mp" required value='<jsp:getProperty property="mp" name="u"/>'>  
            <button type="submit">Ajouter</button>   
              
        </div>   
    </form>     
</body>     
</html>  
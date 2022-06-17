<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Plateforme gestion d'une imprimerie</title>
</head>
<body>
 <div style="display: center;">
  <h1>Gestion des demandes</h1>
        <h2>
         <a href="new">Ajouter demande</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">Consulter demandes</a>
         
        </h2>
 </div>
    <div align="center"> 
       <form action="insert" method="post">
        <table border="1" cellpadding="5">
            <caption>
             <h2>
               Add New User
             </h2>
            </caption>           
            <tr>
                <th>Matiere: </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${user.name}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Groupe: </th>
                <td>
                 <input type="text" name="email" size="45"
                   value="<c:out value='${user.email}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Country: </th>
                <td>
                 <input type="text" name="country" size="15"
                   value="<c:out value='${user.country}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>
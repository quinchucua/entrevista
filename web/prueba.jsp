<%-- 
    Document   : prueba
    Created on : Sep 22, 2018, 7:05:49 PM
    Author     : Alfonso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            table{
                border-collapse: separate;
                border: black 2px solid;
            }
            th {
                color: #FFFFFF;
                background-color: #08088A;    
            }
            td {
                background-color: #0080FF;
                width: 10%;
            }
            #des{
                width: 30%;
            }
        </style>
        
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th id="des">Descripcion</th>
                <th>Fecha</th>
                <th>Tipo</th>
            </tr>
           <c:forEach var="tem"  items="${elementos}">
            <tr>
                <td> ${tem.nombre}</td>
                <td>${tem.apellido}</td>
                <td>${tem.descripcion}</td>
                <td>${tem.fecha}</td>
                <td>${tem.tipo}</td>
                
                
            </tr>
        </c:forEach>
    </body>
</html>

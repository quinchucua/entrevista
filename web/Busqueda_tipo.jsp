<%-- 
    Document   : Busqueda_tipo
    Created on : Sep 22, 2018, 9:22:55 PM
    Author     : Alfonso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda Tipo</title>
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
                background-color: gainsboro;
                width: 10%;
            }
            #des{
                padding: 8px;
                width: 30%;
            }
            .registro{
                text-align: center;
            }
        </style>
    </head>
    
    <body>
        <h1 align="center">Busqueda por Peticion</h1>
        <table>
            <tr>
                <th>Tipo</th>
                <th>Fecha</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Descripcion</th>
                
            </tr>
           <c:forEach var="tem"  items="${listaTipo}">
            <tr>
                <td class="registro">${tem.tipos}</td>
                <td class="registro">${tem.fecha}</td>
                <td class="registro">${tem.nombre}</td>
                <td class="registro">${tem.apellido}</td>
                <td id="des">${tem.descripcion}</td>                
                
            </tr>
            
            
            
           </c:forEach>
        </table>
    </body>
</html>

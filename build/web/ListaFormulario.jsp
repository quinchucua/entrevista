<%-- 
    Document   : ListaFormulario
    Created on : Sep 22, 2018, 2:47:06 PM
    Author     : Alfonso
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*,com.entrevista.alfonso.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            table{
                border-collapse: separate;
                border: black 2px solid;
            }
            th,td {
                border: black 2px solid;
                padding: 2px;
                
                
            }
        </style>
    </head>
    <%
        List<Formulario> elementos = (List<Formulario>) request.getAttribute("listaFormulario");
        %>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Descripcion</th>
                <th>Fecha</th>
                <th>Tipo</th>
            </tr>
            <% for(Formulario tem:elementos){ %>
            <tr>
                <td><%= tem.getNombre() %></td>
                <td><%= tem.getApellido() %></td>
                <td><%= tem.getDescripcion() %></td>
                <td><%= tem.getFecha() %></td>
                <td><%= tem.getTipo() %></td>
            </tr>
            
            
            
            <%} %>
        </table>
    </body>
</html>

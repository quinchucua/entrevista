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
        <link href="CCS/estilos.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda Tipo</title>
        
    </head>
    
    <body>
        <h1 align="center">Busqueda por Peticion</h1>
        <div id="enlaces">
            <div class="enlace"><a class="dirigir"href="http://localhost:8084/PruebaEntrevista">Regrasar a Inicio</a></div>
        <div class="enlace"><a class="dirigir" href="http://localhost:8084/PruebaEntrevista/controlador">Ir a Busqueda Fecha</a></div><br>
        </div>
        <div id="sel">
            <form action="controlador" method="get">
                <select name="opcion">
                    <option value="asc">ascendente</option>
                    <option value="desc">descendente</option>                    
                </select>                
                <input type="hidden" name="operacion" value="tercer">
                <input type="submit" value="Filtrar">
            </form><br><br>
            
        </div>
        <table>
            <tr>
                <th>Tipo</th>
                <th>Fecha</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Descripcion</th>
                <th>Adjunto</th>
                
            </tr>
           <c:forEach var="tem"  items="${listaTipo}">
            <tr>
                <td class="registro">${tem.tipos}</td>
                <td class="registro">${tem.fecha}</td>
                <td class="registro">${tem.nombre}</td>
                <td class="registro">${tem.apellido}</td>
                <td id="des">${tem.descripcion}</td>
                <td class="registro"><a href="http://localhost:8084/PruebaEntrevista/Mostrar?nombre=${tem.nombre_archivo}">${tem.nombre_archivo}</a></td>
                
            </tr>
                        
            
           </c:forEach>
        </table>
    </body>
</html>

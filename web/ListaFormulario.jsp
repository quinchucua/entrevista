<%-- 
    Document   : ListaFormulario
    Created on : Sep 22, 2018, 2:47:06 PM
    Author     : Alfonso
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda por Tipo</title>
        <link href="CCS/estilos.css" rel="stylesheet">    
        
        
    </head>
    
    <body>
        <h1 align="center">Busqueda por fecha</h1>
        <div id="enlaces">
        <div class="enlace"><a class="dirigir" href="http://localhost:8084/PruebaEntrevista">Regrasar a Inicio</a></div>
        <div class="enlace"><a class="dirigir" href="http://localhost:8084/PruebaEntrevista/controlador?operacion=peticion">Ir a Busqueda Peticion</a></div><br>
        </div>
            <div id="sel">
            <form action="controlador" method="get">
                <select name="opcion">
                    <option value="asc">ascendente</option>
                    <option value="desc">descendente</option>                    
                </select>                
                <input type="hidden" name="operacion" value="cuarto">
                <input type="submit" value="Filtrar">
            </form><br><br>
            
        </div>
        <table>
            <tr>
                <th>Fecha</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Descripcion</th>
                <th>Telefono</th>
                <th>Adjunto</th>
            </tr>
           <c:forEach var="tem"  items="${listaFormulario}">
            <tr>
                <td class="registro">${tem.fecha}</td>
                <td class="registro">${tem.nombre}</td>
                <td class="registro">${tem.apellido}</td>
                <td id="des">${tem.descripcion}</td>
                <td class="registro">${tem.telefono}</td>
                
                <td class="registro"><a href="http://localhost:8084/PruebaEntrevista/Mostrar?nombre=${tem.nombre_archivo}">${tem.nombre_archivo}</a></td>
                
            </tr>
            
            
            
           </c:forEach>
        </table>
    </body>
</html>

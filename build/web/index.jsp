<%-- 
    Document   : index
    Created on : Sep 22, 2018, 5:26:15 PM
    Author     : Alfonso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aplicación</title>
        <link href="CCS/principal.css" rel="stylesheet">
    </head>
    <body>
        <div id="head" >
        <h1 align="center">PAGINA DE INICIO</h1>
        <h2 align="center">INGRESE LOS DATOS</h2>
        <h2 align="center">${operacion}</h2>
        </div>
        <div id="contenedor">
            <form action="controlador" method="post" enctype="multipart/form-data" >
            Nombres:
            <input type="text" name="nombre" ><br><br>
            Apellidos:
            <input type="text" name="apellido" ><br><br>
            Telefono:
            <input type="text" name="telefono" ><br><br>
            Fecha:
            <input type="date" name="fecha" ><br><br>
            Tipo peticion:
            <select name="peticion">
                <option value=1>Queja</option>
                <option value=2>Solicitud</option>
                <option value=3>Reclamo</option>
            </select><br><br>
            Descripcion: 
            <textarea name="comentarios" rows="10" cols="60" placeholder="Escribe aquí tus comentarios"></textarea><br><br>
            Adjuntar Archivo:
            <input type="file" name="archivo" id_archivo="1"/><br><br>
            Adjuntar Archivo2:
            <input type="file" name="archivo" id_archivo="2"/><br><br>
            <div id="enviar">
                <input  type="submit" value="Enviar" class="btn">
            </div>
            
        </form><br><br>
           
            
            </div>
        <div id="consultas">
            <form class="consul" action="controlador" method="get">
                 Consultar por Fecha 
                 <input type="submit" value="Buscar" class="btn">
                                
            </form>
            <form class="consul" action="controlador" method="get">
                 Consultar por Peticion
                 <input type="hidden" name="operacion" value="peticion">
                 <input type="submit" value="Buscar" class="btn">
                                
            </form>
        </div>
    </body>
</html>

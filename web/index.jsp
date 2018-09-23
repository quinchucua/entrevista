<%-- 
    Document   : index
    Created on : Sep 22, 2018, 5:26:15 PM
    Author     : Alfonso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            textarea {
             vertical-align: top;
                }
                #contenedor{
                    width: 40%;
                    padding: 10px;
                    margin: 0 auto;
                    background-color: bisque;
                }
            
        </style>
    </head>
    <body>
        <h1 align="center">PAGINA DE INICIA</h1>
        <h2 align="center">INGRESE LOS DATOS</h2>
        <div id="contenedor">
            <form action="controlador" method="post">
            Nombres:
            <input type="text" name="nombre" ><br><br>
            Apellidos:
            <input type="text" name="apellido" ><br><br>
            Fecha:
            <input type="date" name="fecha" ><br><br>
            Tipo peticion:
            <select name="peticion">
                <option value=1>Queja</option>
                <option value=2>Solicitud</option>
                <option value=3>Iconformidad</option>
            </select><br><br>
            Descripcion: 
            <textarea name="comentarios" rows="10" cols="40" placeholder="Escribe aquí tus comentarios"></textarea><br><br>
            
            <input type="submit" name="Enviar">
            
            
        </form>
            </div>
    </body>
</html>

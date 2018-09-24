/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrevista.alfonso;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

/**
 *
 * @author Alfonso
 */
@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
@MultipartConfig(maxFileSize = 16177215)
public class controlador extends HttpServlet {
    private modelo modelo;
    
    @Resource (name="jdbc/pool")
    private DataSource pool;

    @Override
    public void init() throws ServletException {
        super.init(); 
        try {
            modelo = new modelo(pool);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    

   
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String sel = request.getParameter("opcion");
        
        String comand = request.getParameter("operacion");
         
        if (comand == null) comand="fecha";
        
        switch (comand){
            case "peticion":
                BuscarTipo(request,response);
                break;
            
            case "fecha":
                BuscarFecha(request,response);
                break;
            
            case "tercer":
                
                BuscarTipoA(request, response, sel);
                
                break;
             
            case "cuarto":
                
                BucarFechaAD(request, response, sel);
                
                break;
                
            
                
        }
        
        
        
        
        
       
    }

  

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fecha =request.getParameter("fecha");
        String descripcion = request.getParameter("comentarios");
        String tip = request.getParameter("peticion");
        int tipo = Integer.parseInt(tip);
        
        byte [] archivo = null;
        
        Part archivoP = request.getPart("archivo");
        int tamaño = (int)archivoP.getSize();
        
        
        if (tamaño>0){
            
            archivo = new byte [tamaño];
            DataInputStream ar = new DataInputStream(archivoP.getInputStream());
            ar.readFully(archivo);
            
        }
         
        Formulario formu = new Formulario(nombre, apellido, descripcion, fecha, tipo,archivo);
        String operacion =modelo.Guardar(formu);
        
        
        request.setAttribute("operacion", operacion);
        RequestDispatcher despachador = request.getRequestDispatcher("/index.jsp");
        despachador.forward(request, response);
         
    }
    
    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void BuscarTipo(HttpServletRequest request, HttpServletResponse response) {
        List<Formulario> formuario2;
        try {
            formuario2 = modelo.obtenerTipo();
            request.setAttribute("listaTipo", formuario2);
            RequestDispatcher despachador = request.getRequestDispatcher("/Busqueda_tipo.jsp");
            despachador.forward(request, response);
            
        } catch (Exception e) {
        }
           
            
    
    }

    private void BuscarFecha(HttpServletRequest request, HttpServletResponse response) {
     List<Formulario> formuario;
        try {
            formuario = modelo.obtenerFormulario();
            request.setAttribute("listaFormulario", formuario);
            RequestDispatcher despachador = request.getRequestDispatcher("/ListaFormulario.jsp");
            despachador.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }

    private void BuscarTipoA(HttpServletRequest request, HttpServletResponse response, String sel) {
    
    List<Formulario> formuario3;
    String op = sel;
    try {
            formuario3 = modelo.ObtenerOTipo(op);
            request.setAttribute("listaTipo", formuario3);
            RequestDispatcher despachador = request.getRequestDispatcher("/Busqueda_tipo.jsp");
            despachador.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        
    }

    private void BucarFechaAD(HttpServletRequest request, HttpServletResponse response, String sel) {
        
        List<Formulario> formuario3;
        
        String op = sel;
        
    try {
            formuario3 = modelo.ObtenerFechaAD(op);
            request.setAttribute("listaFormulario", formuario3);
            RequestDispatcher despachador = request.getRequestDispatcher("/ListaFormulario.jsp");
            despachador.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

   

}

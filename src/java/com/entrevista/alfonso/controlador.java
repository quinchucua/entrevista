/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrevista.alfonso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Alfonso
 */
@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
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

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

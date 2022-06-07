package com.example.lab7iweb.servlet;
//probando

import com.example.lab7iweb.bean.Bean;
import com.example.lab7iweb.dao.Dao;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HelloServlet", urlPatterns = {"/inicio",""})
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        ArrayList<Bean> lista= Dao.listarLab7();
        request.setAttribute("lista",lista);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);

    }

}
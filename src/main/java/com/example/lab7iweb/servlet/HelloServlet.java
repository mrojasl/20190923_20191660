package com.example.lab7iweb.servlet;
//probando

import com.example.lab7iweb.bean.Bean;
import com.example.lab7iweb.dao.Dao;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        ArrayList<Bean> lista= Dao.listarLab7();
        request.setAttribute("lista",lista);

    }

    public void destroy() {
    }
}
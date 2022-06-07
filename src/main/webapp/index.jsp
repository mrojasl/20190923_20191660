<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.lab7iweb.bean.Bean"%>
<jsp:useBean type="java.util.ArrayList<com.example.lab7iweb.bean.Bean>" scope="request" id="lista"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Lista Trabajos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
              crossorigin="anonymous">
    </head>
    <body>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">N Categorias</th>
                    <th scope="col">N Peliculas</th>
                </tr>
            </thead>
            <tbody>
                <%for (Bean a : lista) {%>
                <tr>
                    <th scope="row"><%=a.getId()%></th>
                    <td><%=a.getNombre()%></td>
                    <td><%=a.getN_categoria()%></td>
                    <td><%=a.getN_pelicula()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
package com.example.lab7iweb.dao;
import com.example.lab7iweb.bean.Bean;

import java.sql.*;
import java.util.ArrayList;

public class Dao {
    public static ArrayList<Bean> listarLab7(){
        ArrayList<Bean> lista = new ArrayList<>();

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/sakila";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String sql = "select a.actor_id,concat(upper(a.first_name),\" \",upper(a.last_name)),count(fc.category_id),count(f.film_id)\n" +
                "from actor a inner join film_actor fa on (a.actor_id=fa.actor_id) inner join film f on (fa.film_id=f.film_id)\n" +
                "inner join film_category fc on (f.film_id=fc.film_id) where (upper(a.first_name) like \"%LO%\"\n" +
                "or upper(a.last_name) like \"%LO%\")\n" +
                "and f.language_id=1\n" +
                "group by a.actor_id having count(*)>20\n" +
                "order by a.actor_id;\n";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql) ){

            while(rs.next()){
                Bean b = new Bean();
                b.setId(rs.getInt(1));
                b.setNombre(rs.getString(2));
                b.setN_categoria(rs.getInt(3));
                b.setN_pelicula(rs.getInt(4));

                lista.add(b);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listarLab7();
    }
}

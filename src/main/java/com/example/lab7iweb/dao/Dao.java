package com.example.lab7iweb.dao;

import java.sql.*;
import java.util.ArrayList;

public class Dao {
    public ArrayList<Bean> listarTrabajos(){
        ArrayList<Bean> listaTrabajos = new ArrayList<>();

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/hr";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select * from jobs");) {

            while(rs.next()){
                BJob bJob = new BJob();
                bJob.setJobId(rs.getString(1));
                bJob.setJobTitle(rs.getString(2));
                bJob.setMinSalary(rs.getInt(3));
                bJob.setMaxSalary(rs.getInt(4));
                listaTrabajos.add(bJob);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaTrabajos;
    }
}

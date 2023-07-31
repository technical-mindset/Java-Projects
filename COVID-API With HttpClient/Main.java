package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Task 1
       CovidApi.getData();

       // Task 2
    try{
        Connection con = DB_Connection.getInstance().getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees;");

        while(rs.next()){
            System.out.println(rs.getString(1) +"     "+rs.getString(2)+"     "+
                    rs.getString(3)+"    "+rs.getString(4));
        }
        System.out.println(rs);
    }
    catch (Exception e){
        e.printStackTrace();
    }
    }
}
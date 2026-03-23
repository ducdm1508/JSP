package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:4306/duc1",
                "root",
                ""
            );
        }catch(Exception e){
            System.out.println(e);
        }

        return null;

    }



}
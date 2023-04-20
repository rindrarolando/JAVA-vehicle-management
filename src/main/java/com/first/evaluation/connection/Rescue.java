package com.first.evaluation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Rescue {

    static String url="jdbc:postgresql://localhost:5432/evaluation";
    static String user="rindrarolando";
    static String password="mdpprom13";
    
    public static Connection connectToDatabase(){
        try{
            Connection c = null;
            Statement stmt ;
            c = DriverManager.getConnection(url,user,password);
            return c;
        }catch(Exception e){
            return null;
        }
    }
}

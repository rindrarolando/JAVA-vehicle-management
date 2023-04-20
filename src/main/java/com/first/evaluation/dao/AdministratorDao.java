package com.first.evaluation.dao;

import com.first.evaluation.connection.Rescue;
import com.first.evaluation.entities.Administrator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdministratorDao {
    public Administrator checkAdmin(String ident , String mdp) throws SQLException {
        Administrator admin = null;
        Connection c = null;
        Statement stmt = null;
        try {
            c = Rescue.connectToDatabase();
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery("select * from administrator where login='"+ident
                    +"' and password=md5('"+mdp+"')");
            while(res.next()){
                int id = res.getInt("id");
                String identifiant = res.getString("login");
                String password = res.getString("password");
                admin = new Administrator(id,identifiant,password);
            }
            return admin;
        }catch (Exception e){
            return null;
        }finally {
            if(c!=null) c.close();
            if(stmt!=null) stmt.close();
        }
    }

    public static Administrator getAdminById(int id) throws SQLException {
        Administrator admin = null;
        Connection c = null;
        Statement stmt= null;
        try {
            c = Rescue.connectToDatabase();
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery("select * from administrator where id='"+id+"'");
            while(res.next()){
                int i = res.getInt("id");
                String identifiant = res.getString("login");
                String password = res.getString("password");
                admin = new Administrator(i,identifiant,password);
            }
            return admin;
        }catch (Exception e){
            return null;
        }finally {
            if(c!=null) c.close();
            if(stmt!=null) stmt.close();
        }
    }
}

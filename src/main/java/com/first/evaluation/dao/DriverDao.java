package com.first.evaluation.dao;

import com.first.evaluation.connection.Rescue;
import com.first.evaluation.entities.Administrator;
import com.first.evaluation.entities.Driver;

import java.sql.*;
import java.time.LocalDate;

public class DriverDao {

    public Driver checkDriver(String ident , String mdp) throws SQLException {
        Driver driver = null;
        Connection c = null;
        Statement stmt = null;
        try {
            c = Rescue.connectToDatabase();
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery("select * from driver where login='"+ident
                    +"' and password=md5('"+mdp+"')");
            while(res.next()){
                int id = res.getInt("id");
                String name = res.getString("name");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birth = res.getDate("birth");

                driver = new Driver(id,name,password,convertToLocalDateViaSqlDate(birth),login);
            }
            return driver;
        }catch (Exception e){
            return null;
        }finally {
            if(c!=null) c.close();
            if(stmt!=null) stmt.close();
        }
    }

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }
}

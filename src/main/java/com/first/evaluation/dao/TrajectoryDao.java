package com.first.evaluation.dao;

import com.first.evaluation.connection.Rescue;
import com.first.evaluation.entities.Driver;
import com.first.evaluation.entities.Type;
import com.first.evaluation.entities.Vehicle;

import java.sql.*;
import java.time.Instant;

public class TrajectoryDao {

    public void insertDeparture(int id , String number , int driver, String motif, Instant departure_time, String departure_place, double departure_km, double fuel_price, double fuel_quantity) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Rescue.connectToDatabase();
            pst = conn.prepareStatement("INSERT INTO public.trajectory(\n" +
                    "\tid, numbervehicle, iddriver, motif, departure_time, departure_place, departure_km, arrival_time, arrival_place, arrival_km, fuel_price, fuel_quantity, status)\n" +
                    "\tVALUES (DEFAULT, ?, ?, ?, current_timestamp(), ?, ?, null, null, null, ?, ?, false);");
            pst.setString(1, number);
            pst.setInt(2, driver);
            pst.setString(3,motif);
            pst.setString(4,departure_place);
            pst.setDouble(5,departure_km);
            pst.setDouble(6,fuel_price);
            pst.setDouble(7,fuel_quantity);

            pst.executeUpdate();
        } catch (Exception e) {

        }finally{
            if(conn!=null) {
                conn.close();
            }
            if(pst!=null) {
                pst.close();
            }
        }
    }

    public Vehicle getVehiclByNumber(String numero) throws SQLException {
        Vehicle vehicule = null;
        Connection c = null;
        Statement stmt = null;
        try {
            c = Rescue.connectToDatabase();
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery("select * from vehicle where number='"+numero+"'");
            while(res.next()){
                String number = res.getString("number");
                int idtype = res.getInt("idtype");
                Type type = getTypeById(idtype);
                String mark = res.getString("mark");
                String model = res.getString("model");
                Double km = res.getDouble("km");

                vehicule = new Vehicle(number,type,mark,model,km);
            }
            return vehicule;
        }catch (Exception e){
            return null;
        }finally {
            if(c!=null) c.close();
            if(stmt!=null) stmt.close();
        }
    }

    public Type getTypeById(int idtype) throws SQLException {
        Type type = null;
        Connection c = null;
        Statement stmt = null;
        try {
            c = Rescue.connectToDatabase();
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery("select * from type where id="+idtype);
            while(res.next()){

                int id = res.getInt("idtype");

                String desc = res.getString("description");

                type = new Type(id,desc);
            }
            return type;
        }catch (Exception e){
            return null;
        }finally {
            if(c!=null) c.close();
            if(stmt!=null) stmt.close();
        }
    }
}

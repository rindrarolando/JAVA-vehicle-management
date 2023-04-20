package com.first.evaluation.controllers;

import com.first.evaluation.dao.DriverDao;
import com.first.evaluation.entities.*;
import com.first.evaluation.services.ArrivalService;
import com.first.evaluation.services.DepartureService;
import com.first.evaluation.services.TrajectoryService;
import com.first.evaluation.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    VehicleService vehicleService;
    @Autowired
    DepartureService departureService;
    @Autowired
    ArrivalService arrivalService;
    @Autowired
    TrajectoryService trajectoryService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String login(HttpServletRequest request , HttpSession session){
        session = request.getSession();
        if(session.getAttribute("driver")==null) {
            return "frontoffice/login";
        }else {
            return "redirect:/acceuil";
        }
    }

    @RequestMapping(value="/treat-login-driver",method = RequestMethod.POST)
    public String loginDriver(HttpServletRequest request , HttpSession session) throws SQLException {
        session = request.getSession(true);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DriverDao dao = new DriverDao();
        if(dao.checkDriver(login,password)!=null){
            Driver driver = dao.checkDriver(login,password);
            session.setAttribute("driver", driver);
            return "redirect:/acceuil";
        }else{
            return "redirect:/?error=1";
        }
    }

    @RequestMapping(value="/acceuil",method = RequestMethod.GET)
    public String acceuilDriver(HttpServletRequest request , HttpSession session, ModelMap model){
        session = request.getSession();
        if(session.getAttribute("driver")!=null) {
            List<Vehicle> listofavailablevehicles = vehicleService.getAvailableVehicles1();
            List<Vehicle> justlist = vehicleService.getAvailableVehicles2();
            listofavailablevehicles.addAll(justlist);
            model.addAttribute("lists",listofavailablevehicles);
            return "frontoffice/acceuil";
        }else {
            return "redirect:/";
        }
    }

    @RequestMapping(value="/treat-add-trajectory",method = RequestMethod.POST)
    public String treattrajectory(HttpServletRequest request , HttpSession session,
                                  @RequestParam("numbervehicle") String number, @RequestParam("departure_time") String departure_time,@RequestParam("departure_place")String departure_place, @RequestParam("motif")String motif, @RequestParam("departure_km") String departureKm,
                                  @RequestParam("fuel_quantity") String fuel_quantity,@RequestParam("fuel_type") String fuel_type) throws SQLException {
        Driver driver = (Driver)session.getAttribute("driver");
        Vehicle vehicule = vehicleService.getByNumber(number);
        Double fuel_quantite = Double.valueOf(fuel_quantity);
        Double fuel_price= null;
        if(fuel_type=="essence"){
            fuel_price = fuel_quantite*4100;
        }else{
            fuel_price = fuel_quantite*3500;
        }

        String dateDepart = departure_time;
        dateDepart = dateDepart.replace("T"," ");
        Timestamp dp = Timestamp.valueOf(dateDepart+":00");
        Instant dateDep = dp.toInstant();

        Trajectory traject = new Trajectory(vehicule,driver,motif, dateDep,departure_place,Double.valueOf(departureKm),fuel_price,Double.valueOf(fuel_quantity),false);
        try{


            trajectoryService.addTrajectory(traject);

            return "redirect:/acceuil?success=1";
        }catch(Exception e){
            return "redirect:/acceuil?error=1";
        }
    }

    @RequestMapping(value="/departures-to-finish",method = RequestMethod.GET)
    public String terminerDepart(HttpServletRequest request , HttpSession session, ModelMap model){
        session = request.getSession();
        if(session.getAttribute("driver")!=null) {
            Driver driver = (Driver)session.getAttribute("driver");
            List<Departure> listOfDepartures = departureService.getAllDepartures(driver.getId());
            model.addAttribute("lists",listOfDepartures);
            return "frontoffice/deptofinish";
        }else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/form-arrival",method = RequestMethod.GET)
    public String formarrival(HttpServletRequest request , HttpSession session, @RequestParam("id") String idd){
        session = request.getSession();
        if(session.getAttribute("driver")!=null) {
            int id = Integer.parseInt(idd);
            Trajectory trajet = trajectoryService.getById(id);
            return "frontoffice/formarrival";
        }else {
            return "redirect:/";
        }
    }

    @RequestMapping(value="/treat-add-arrival",method = RequestMethod.POST)
    public String treataddarrival(HttpServletRequest request , HttpSession session, @RequestParam("arrival_place") String arrival_place,@RequestParam("arrival_time") String arrival_time, @RequestParam("arrival_km")String arrival_km) throws SQLException {
        session = request.getSession();
        if(session.getAttribute("driver")!=null){

            Driver driver = (Driver)session.getAttribute("driver");
            Trajectory trajet = trajectoryService.getByDriver(driver.getId());
            Vehicle vehicle = trajet.getNumbervehicle();

            String dateArrivee = arrival_time;
            dateArrivee = dateArrivee.replace("T"," ");
            Timestamp dp = Timestamp.valueOf(dateArrivee+":00");
            Instant dateDep = dp.toInstant();
            String lieuArrivee = arrival_place;
            String kilometreArrivee = arrival_km;
            double kmDepart = Double.valueOf(trajet.getDepartureKm());
            double kmArrivee = Double.valueOf(kilometreArrivee);
            if(kmDepart>kmArrivee){
                return "redirect:/form-arrival?error=1";
            }
            else if(kmArrivee<0){
                return "redirect:/form-arrival?error=1";
            }
            Trajectory tt = new Trajectory(trajet.getId(),vehicle,driver,trajet.getMotif(),trajet.getDepartureTime(),trajet.getDeparturePlace(),kmDepart,dateDep,arrival_place,kmArrivee,trajet.getFuelPrice(),trajet.getFuelQuantity(),true);
            try{
                trajectoryService.addTrajectory(tt);

                return "redirect:/departures-to-finish?success=1";
            }catch(Exception e){
                return "redirect:/departures-to-finish?error=1";
            }
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping("/logout-user")
    public String deconnexion(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";

    }
}

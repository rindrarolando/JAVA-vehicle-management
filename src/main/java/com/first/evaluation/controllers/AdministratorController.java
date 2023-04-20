package com.first.evaluation.controllers;


import com.first.evaluation.dao.AdministratorDao;
import com.first.evaluation.entities.*;
import com.first.evaluation.services.*;
import com.first.evaluation.views.Vehiclestate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdministratorController {
    @Autowired
    VehicleService vehicleService ;
    @Autowired
    TypeService typeService;
    @Autowired
    AssuranceService assuranceService;
    @Autowired
    VisiteService visiteService;
    @Autowired
    TrajectoryService trajectoryService;
    @Autowired
    VehiclestateService vehiclestateService;


    @RequestMapping(value = "/login-administrator",method = RequestMethod.POST)
    public String login(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(true);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        AdministratorDao dao = new AdministratorDao();
        if(dao.checkAdmin(login,password)!=null){
            Administrator admin = dao.checkAdmin(login,password);
            session.setAttribute("admin", admin);
            return "redirect:/acceuil-backoffice";
        }else{
            return "redirect:/login?error=1";
        }
    }

    @RequestMapping("/acceuil-backoffice")
    public String loginAdmin(HttpServletRequest request , HttpSession session,ModelMap model){
        session = request.getSession();
        if(session.getAttribute("admin")!=null) {
            List<Vehicle> list_v = vehicleService.getAllVehicles();
            List<Assurance> list = new ArrayList<>();

            for(int i=0 ; i<list_v.size();i++){
                list.add(assuranceService.getAssuranceOfVehicle(list_v.get(i).getId()));
            }

            model.addAttribute("lists",list);

            return "backoffice/acceuil";
        }else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/visit")
    public String visite(HttpServletRequest request , HttpSession session,ModelMap model){
        session = request.getSession();
        if(session.getAttribute("admin")!=null) {
            List<Vehicle> list_v = vehicleService.getAllVehicles();
            List<Visite> list = new ArrayList<>();

            for(int i=0 ; i<list_v.size();i++){
                list.add(visiteService.getVisitOfVehicle(list_v.get(i).getId()));
            }

            model.addAttribute("lists",list);
            return "backoffice/visit";
        }else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request , HttpSession session){
        session = request.getSession();
        if(session.getAttribute("admin")==null) {
            return "backoffice/login";
        }else {
            return "redirect:/acceuil-backoffice";
        }
    }

    @RequestMapping("/form-vehicle")
    public String formAddOfVehicle(HttpServletRequest request,HttpSession session,ModelMap model){
        session = request.getSession();
        if(session.getAttribute("admin")!=null) {
            List<Type> list = typeService.getAllTypes();
            model.addAttribute("lists",list);
            return "backoffice/adding-vehicle";
        }else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/form-pdf")
    public String formpdf(HttpServletRequest request,HttpSession session,ModelMap model){
        session = request.getSession();
        if(session.getAttribute("admin")!=null) {
            List<Vehicle> list = vehicleService.getAllVehicles();
            model.addAttribute("lists",list);
            return "backoffice/formpdf";
        }else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/treat-add-vehicule",method = RequestMethod.POST)
    public String addCommentaire(HttpServletRequest request,HttpSession session,@RequestParam("number") String number,@RequestParam("idtype")String idtype,@RequestParam("mark")String mark,@RequestParam("model") String model,@RequestParam("km") String km) throws SQLException {
        try{
            Type type = typeService.getByid(Integer.valueOf(idtype));
            Vehicle vehicule=new Vehicle(number,type,mark,model,Double.valueOf(km));
            vehicleService.addVehicle(vehicule);
            return "redirect:/form-vehicle?success=1";
        }catch(Exception e){
            return "redirect:/form-vehicle?error=1";
        }

    }

    @RequestMapping(value = "/print-pdf",method = RequestMethod.POST)
    public String pdf(HttpServletRequest request,HttpSession session,@RequestParam("number") String number,ModelMap model) throws SQLException {
        try{
            List<Trajectory> list = trajectoryService.getByVehicleNumber(number);
            model.addAttribute("lists",list);
            model.addAttribute("number",number);
            return "backoffice/trajetpdf";
        }catch(Exception e){
            return "redirect:/form-pdf?error=1";
        }

    }

    @RequestMapping("/form-assurance")
    public String assurance(HttpServletRequest request,HttpSession session,ModelMap model){
        session = request.getSession();
        if(session.getAttribute("admin")!=null) {
            session.setAttribute("id",request.getParameter("id"));
            List<Vehicle> list = vehicleService.getAllVehicles();
            model.addAttribute("lists",list);
            return "backoffice/formassurance";
        }else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/add-assurance",method = RequestMethod.POST)
    public String addass(HttpServletRequest request,HttpSession session,@RequestParam("numbervehicle") String number,@RequestParam("date_payment")String date,@RequestParam("duration")String duration) throws SQLException {

            Vehicle vehicle = vehicleService.getByNumber(number);
            LocalDate last_date_of_payment = LocalDate.parse(date);
            int duree = Integer.parseInt(duration);
            LocalDate expiration = last_date_of_payment.plusMonths(duree);
            Assurance assurance = new Assurance();
            if(session.getAttribute("id")!=null){
                int id = Integer.parseInt((String) session.getAttribute("id"));
                assurance = new Assurance(id ,vehicle,last_date_of_payment,expiration);
                session.removeAttribute("id");
            }else {
                assurance = new Assurance(vehicle,last_date_of_payment,expiration);
            }

        try{
            assuranceService.addAssurance(assurance);
            return "redirect:/form-assurance?success=1";
        }catch(Exception e){
            return "redirect:/form-assurance?error=1";
        }

    }

    @RequestMapping("/form-visit")
    public String visit(HttpServletRequest request,HttpSession session,ModelMap model){
        session = request.getSession();
        if(session.getAttribute("admin")!=null) {
            session.setAttribute("id",request.getParameter("id"));
            List<Vehicle> list = vehicleService.getAllVehicles();
            model.addAttribute("lists",list);
            return "backoffice/formvisit";
        }else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/add-visit", method = RequestMethod.POST)
    public String addvisit(HttpServletRequest request,HttpSession session,@RequestParam("numbervehicle") String number,@RequestParam("date_visit")String date) throws SQLException {

        Vehicle vehicle = vehicleService.getByNumber(number);
        LocalDate date_visit = LocalDate.parse(date);
        LocalDate next_visit = date_visit.plusYears(1);
        Visite visit = new Visite();
        if(session.getAttribute("id")!=null){
            int id=Integer.parseInt((String) session.getAttribute("id"));
            visit = new Visite(id,vehicle,date_visit,next_visit);
            session.removeAttribute("id");
        }else{
            visit = new Visite(vehicle,date_visit,next_visit);
        }

        try{
            visiteService.addVisit(visit);
            return "redirect:/form-visit?success=1";
        }catch(Exception e){
            return "redirect:/form-visit?error=1";
        }

    }

    @RequestMapping("/logout")
    public String deconnexion(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";

    }
}

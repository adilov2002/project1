package practice.springboot.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import practice.springboot.demo.db.Cars;
import practice.springboot.demo.db.DBManager;

import java.util.ArrayList;

@Controller
public class HomeController {


    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Cars> cars = DBManager.getAllCars();
        model.addAttribute("cars", cars);
        return "index";
    }

    @GetMapping(value = "/about")
    public String about(){
        return "about";
    }
}

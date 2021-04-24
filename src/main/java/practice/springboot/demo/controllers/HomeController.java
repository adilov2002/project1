package practice.springboot.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/addcar")
    public String addCar(){
        return "addcar";
    }

    @PostMapping(value = "/addcar")
    public String toAddCar(@RequestParam(name = "name") String name,
                           @RequestParam(name = "model") String model,
                           @RequestParam(name = "speed") int speed){
        DBManager.addCar(new Cars(null, name, model, speed));
        return "redirect:/addcar?success";
    }

    @GetMapping(value = "/details/{carId}")
    public String details(@PathVariable(name = "carId") Long id, Model model){
        Cars car = DBManager.getCar(id);
        model.addAttribute("car", car);
        return "details";
    }

}

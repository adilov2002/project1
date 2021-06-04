package practice.springboot.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.springboot.demo.entities.Cars;
import practice.springboot.demo.services.CarsService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CarsService carsService;

    @GetMapping(value = "/")
    public String index(Model model){
        List<Cars> cars = carsService.listCars();
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
                           @RequestParam(name = "price") int price){
        carsService.addCar(new Cars(null, name, model, price));
        return "redirect:/addcar?success";
    }

    @PostMapping(value = "/savecar")
    public String toSaveCar(@RequestParam(name = "id") Long id,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "model") String model,
                           @RequestParam(name = "price") int price){
        Cars car = carsService.getCar(id);

        if(car!=null){
            car.setName(name);
            car.setModel(model);
            car.setPrice(price);

            carsService.saveCar(car);
            //return "redirect:/details/"+id;
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping(value = "/details/{carId}")
    public String details(@PathVariable(name = "carId") Long id, Model model){
        Cars car = carsService.getCar(id);
        model.addAttribute("car", car);
        return "details";
    }

    @PostMapping(value = "/deletecar")
    public String deleteCar(@RequestParam(name = "id") Long id){
        Cars car = carsService.getCar(id);
        if (car != null){
            carsService.deleteCar(car);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/searchcar")
    public String searchCar(@RequestParam(name = "key") String key, Model model){
        List<Cars> cars = carsService.searchCars(key);
        model.addAttribute("cars", cars);
        model.addAttribute("key", key);
        return "index";
    }

}

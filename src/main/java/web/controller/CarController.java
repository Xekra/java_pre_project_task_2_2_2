package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count,
                            ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford", "Mustang", 1967));
        cars.add(new Car("Toyota", "LandCruzer", 1995));
        cars.add(new Car("Mercedes-Benz", "S500", 2010));
        cars.add(new Car("Lada", "2101", 1983));
        cars.add(new Car("Seat", "Leon", 2013));

        if (count == null) {
            List<Car> nullCarList = new ArrayList<>();
            model.addAttribute("cars", nullCarList);
        } else {
            model.addAttribute("cars", carService.getCountCars(cars, count));
        }

        return "cars";
    }

}

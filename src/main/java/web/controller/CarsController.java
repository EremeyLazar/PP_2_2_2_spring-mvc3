package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Service;
import service.ServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    Service service = new ServiceImp();

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam("count") int carsNum, ModelMap model) {

        if (carsNum > 5) {
            carsNum = 5;
        }

        List<String> messages = new ArrayList<>();
        messages.add("Please, see the list of " + carsNum + " out of 5 cars.");
        service.getCarsFromList(carsNum).stream().forEach(x -> messages.add(String.valueOf(x)));
        model.addAttribute("messages", messages);

        return "cars";
    }
}



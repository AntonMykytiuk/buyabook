package ua.singleton.buyabook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String getHomePage() {
        return "Hello from buyabook resp app)";
    }
}

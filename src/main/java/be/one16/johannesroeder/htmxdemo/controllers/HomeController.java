package be.one16.johannesroeder.htmxdemo.controllers;

import be.one16.johannesroeder.htmxdemo.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final EmployeeService employeeService;

    public HomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("allEmpList", employeeService.getEmployees());
        return "index";
    }
}

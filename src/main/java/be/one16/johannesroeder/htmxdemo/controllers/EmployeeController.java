package be.one16.johannesroeder.htmxdemo.controllers;

import be.one16.johannesroeder.htmxdemo.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String employees(Model model) {
        model.addAttribute("allEmpList", employeeService.getEmployees());
        return "fragments :: employeeList";
    }

    @GetMapping("employee-info/{id}")
    public String employeeInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("info", employeeService.getEmployeeInfo(id));
        return "fragments :: employeeInfo";
    }
}

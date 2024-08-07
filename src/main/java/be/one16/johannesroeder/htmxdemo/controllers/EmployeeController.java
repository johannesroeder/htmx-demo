package be.one16.johannesroeder.htmxdemo.controllers;

import be.one16.johannesroeder.htmxdemo.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public String employees(Model model) {
        model.addAttribute("allEmpList", employeeService.getEmployees());
        return "fragments :: employeeList";
    }

    @GetMapping("employee/{id}")
    public String employeeInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("info", employeeService.getEmployeeInfo(id));
        return "fragments :: employeeInfo";
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable Integer id, Model model) {
        employeeService.deleteEmployee(id);
        model.addAttribute("allEmpList", employeeService.getEmployees());
        return "fragments :: employeeList";
    }
}

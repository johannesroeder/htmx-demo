package be.one16.johannesroeder.htmxdemo.services;

import be.one16.johannesroeder.htmxdemo.domain.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees;

    @PostConstruct
    private void init() {
        employees = List.of(
                new Employee(1, "Johannes", "johanne@one16.be"),
                new Employee(2, "Umberto", "umberto@one16.be"),
                new Employee(3, "Maarten", "maarten@one16.be"),
                new Employee(4, "Arno","arno@one16.be")
        );
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

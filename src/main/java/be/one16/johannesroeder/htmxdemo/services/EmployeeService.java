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
                new Employee(1, "Johannes", "johanne@one16.be", "Johannes is a software engineer at One16."),
                new Employee(2, "Umberto", "umberto@one16.be", "Umberto is a software engineer at One16."),
                new Employee(3, "Maarten", "maarten@one16.be", "Maarten is a software engineer at One16."),
                new Employee(4, "Arno","arno@one16.be", "Arno is a software engineer at One16.")
        );
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getEmployeeInfo(Integer id) {
        return employees.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .map(Employee::info)
                .orElse("No info found.");
    }
}

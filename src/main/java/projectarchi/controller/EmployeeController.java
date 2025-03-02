package projectarchi.controller;

import projectarchi.model.Employee;
import projectarchi.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public Iterable<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee addOneEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }


    @GetMapping("/employee/{lastName}")
    public List<Employee> getEmployeeByLastName(@PathVariable String lastName) {
        return this.employeeRepository.findByLastName(lastName);
    }

}
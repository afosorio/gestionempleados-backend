package com.co.flypass.gestionempleados.controller;

import com.co.flypass.gestionempleados.application.EmployeeService;
import com.co.flypass.gestionempleados.domain.employee.Employee;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void save(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @PutMapping
    public void update(@RequestBody Employee employee){
        employeeService.update(employee);
    }

    @PutMapping("/updateposition")
    public void updatePosition(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getAllEmployees(@PathVariable Long id) throws Exception {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}/{position}")
    public void updatePosition(@PathVariable Long id, @PathVariable String position) throws Exception {
         employeeService.updatePosition(id, position);
    }
}
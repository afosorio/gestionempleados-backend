package com.co.flypass.gestionempleados.controller;

import com.co.flypass.gestionempleados.application.EmployeeService;
import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.co.flypass.gestionempleados.exception.AppException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void save(@RequestBody Employee employee) throws AppException {
        employeeService.save(employee);
    }

    @PutMapping
    public void update(@RequestBody Employee employee){
        employeeService.update(employee);
    }

    @GetMapping("/all")
    public  Response<Object> getAllEmployees() throws AppException {
        return new Response<>(HttpServletResponse.SC_OK, "Lista de Empleados", employeeService.getAll());
    }

    @GetMapping("/employees")
    public  Response<Object> getEmployees(@RequestParam(required = false) final String document,
                                          @RequestParam(required = false) final String position,
                                          @RequestParam(required = false) final String status) throws AppException {

        return new Response<>(HttpServletResponse.SC_OK, "Lista de Empleados", employeeService.getAll(document, position, status));
    }

    @GetMapping("/{id}")
    public  Response<Object> getEmployeeById(@PathVariable long id)  throws AppException  {
        return new Response<>(HttpServletResponse.SC_OK, "Empleado encotrado", employeeService.getEmployeeById(id));
    }

    @PutMapping("/updateposition/{id}/{position}")
    public void updatePosition(@PathVariable Long id, @PathVariable String position) throws AppException {
         employeeService.updatePosition(id, position);
    }
}
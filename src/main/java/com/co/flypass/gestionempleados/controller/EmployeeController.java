package com.co.flypass.gestionempleados.controller;

import com.co.flypass.gestionempleados.application.EmployeeService;
import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.co.flypass.gestionempleados.exception.AppException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Response<Object> save(@RequestBody @Valid  Employee employee) throws AppException {
        employeeService.save(employee);
        return new Response<>(HttpServletResponse.SC_OK, Constant.EMPLOYEE_CREATED);
    }

    @PutMapping
    public Response<Object> update(@RequestBody Employee employee){
        employeeService.update(employee);
        return new Response<>(HttpServletResponse.SC_OK, Constant.EMPLOYEE_UPDATE);
    }

    @GetMapping("/all")
    public  Response<Object> getAllEmployees() throws AppException {
        return new Response<>(HttpServletResponse.SC_OK, Constant.EMPLOYEES_LIST_FOUND, employeeService.getAll());
    }

    @GetMapping("/employees")
    public  Response<Object> getEmployees(@RequestParam(required = false) final String document,
                                          @RequestParam(required = false) final String position,
                                          @RequestParam(required = false) final String status) throws AppException {

        return new Response<>(HttpServletResponse.SC_OK, Constant.EMPLOYEES_LIST_FOUND, employeeService.getAll(document, position, status));
    }

    @GetMapping("/{id}")
    public  Response<Object> getEmployeeById(@PathVariable long id)  throws AppException  {
        return new Response<>(HttpServletResponse.SC_OK, Constant.EMPLOYEE_FOUND, employeeService.getEmployeeById(id));
    }

    @PutMapping("/updateposition/{id}/{position}")
    public Response<Object> updatePosition(@PathVariable long id, @PathVariable String position) throws AppException {
         employeeService.updatePosition(id, position);
        return new Response<>(HttpServletResponse.SC_OK, Constant.EMPLOYEE_POSITION_UPDATE);
    }
}
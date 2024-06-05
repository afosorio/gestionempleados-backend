package com.co.flypass.gestionempleados.controller;

import com.co.flypass.gestionempleados.application.OfficeService;
import com.co.flypass.gestionempleados.domain.office.Office;
import com.co.flypass.gestionempleados.exception.AppException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/office")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping()
    public Response<Object> save(@RequestBody Office office) throws AppException {

        officeService.save(office);
        return new Response<>(HttpServletResponse.SC_OK, "Oficina Creada");
    }

    @GetMapping("/employee/{employeeId}")
    public Response<Object> employeeOffice(@PathVariable long employeeId) throws Exception {

        return new Response<>(HttpServletResponse.SC_OK, "Oficina encontrada", officeService.getOfficeByEmployee(employeeId));
    }

    @GetMapping("/employeescount/{officeId}")
    public Response<Object>  countEmployeesByOffice(@PathVariable long officeId) {
        return new Response<>(HttpServletResponse.SC_OK, "Cantidad de Empleados por Oficina", officeService.getCountEmployeesByOffice(officeId));
    }
}

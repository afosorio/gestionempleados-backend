package com.co.flypass.gestionempleados.controller;

import com.co.flypass.gestionempleados.application.OfficeService;
import com.co.flypass.gestionempleados.domain.office.Office;
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
    public void save(@RequestBody Office office){
        officeService.save(office);
    }

    @GetMapping("/employee/{employeeId}")
    public Response<Object> employeeOffice(@PathVariable long employeeId) throws Exception {

        return new Response<>(HttpServletResponse.SC_OK, "Oficina consultada", officeService.getOfficeByEmployee(employeeId));
    }

    @GetMapping("/employeescount/{officeId}")
    public Response<Object>  countEmployeesByOffice(@PathVariable Long officeId) throws Exception {
        return new Response<>(HttpServletResponse.SC_OK, "Cantidad de Empleados por Oficina", officeService.getCountEmployeesByOffice(officeId));
    }
}

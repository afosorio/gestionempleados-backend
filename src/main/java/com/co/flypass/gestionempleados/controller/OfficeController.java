package com.co.flypass.gestionempleados.controller;

import com.co.flypass.gestionempleados.application.OfficeService;
import com.co.flypass.gestionempleados.domain.office.Office;
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
    public Office employeeOffice(@PathVariable Long employeeId) throws Exception {
        return officeService.getOfficeByEmployee(employeeId);
    }

    @GetMapping("/employeescount/{officeId}")
    public int countEmployeesByOffice(@PathVariable Long officeId) throws Exception {
        return officeService.getCountEmployeesByOffice(officeId);
    }
}

package com.co.flypass.gestionempleados.application;

import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.co.flypass.gestionempleados.domain.office.Office;
import com.co.flypass.gestionempleados.domain.office.OfficeRepository;
import com.co.flypass.gestionempleados.exception.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(OfficeService.class);

    public OfficeService(OfficeRepository officeRepository, EmployeeService employeeService) {
        this.officeRepository = officeRepository;
        this.employeeService = employeeService;
    }

    public void save(Office office) throws AppException {
        validateOffice(office);
        officeRepository.save(office);
    }

    private void validateOffice(Office office) throws AppException {

        if(Objects.isNull(office.getGeographicalLocation())){
            logger.info(Constant.LOCATION_NOT_FOUND);
            throw new AppException();
        }
    }

    public Office getOfficeByEmployee(Long employeeId) throws AppException {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employee.getOffice();
    }

    public int getCountEmployeesByOffice(Long officeId) {
        return  employeeService.countByOfficeId(officeId);
    }

}

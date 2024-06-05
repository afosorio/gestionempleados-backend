package com.co.flypass.gestionempleados.application;

import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.co.flypass.gestionempleados.domain.employee.EmployeeRepository;
import com.co.flypass.gestionempleados.domain.office.Office;
import com.co.flypass.gestionempleados.domain.office.OfficeRepository;
import com.co.flypass.gestionempleados.exception.AppException;
import com.co.flypass.gestionempleados.exception.NoDataFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService(EmployeeRepository employeeRepository, OfficeRepository officeRepository) {
        this.employeeRepository = employeeRepository;
        this.officeRepository = officeRepository;
    }

    public void save(Employee employee) throws AppException {

        validateEmployee(employee);
        employeeRepository.save(employee);
    }

    private void validateEmployee(Employee employee) throws AppException {


        Optional<Office> sourceOffice = officeRepository.findOfficeById(employee.getOffice().getId());
        if (sourceOffice.isEmpty()) {
            logger.info(Constant.OFFICE_NOT_FOUND);
            throw new NoDataFoundException(Constant.OFFICE_NOT_FOUND);
        }

        Optional<List<Employee>> sourceEmployee = employeeRepository.findByDocument(employee.getDocument());
        if (sourceEmployee.isPresent()) {

            logger.info(Constant.EMPLOYEE_DOCUMENT_EXIST.replace("%", employee.getDocument()));
            throw new NoDataFoundException(Constant.EMPLOYEE_DOCUMENT_EXIST.replace("%", employee.getDocument()));
        }

        if (Objects.isNull(employee.getStatus())) {
            logger.info(Constant.STATUS_NOT_FOUND);
            throw new AppException(Constant.STATUS_NOT_FOUND);
        }

    }

    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    public void updatePosition(long id, String position) throws NoDataFoundException {
        Employee employee = getEmployeeById(id);
        employee.setPosition(position);
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id) throws NoDataFoundException {

        Optional<Employee> employee = employeeRepository.findByEmployeeId(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        logger.info(Constant.EMPLOYEE_NOT_FOUND);
        throw new NoDataFoundException(Constant.EMPLOYEE_NOT_FOUND);
    }

    public int countByOfficeId(long id) {
        return employeeRepository.countByOfficeId(id);
    }

    public List<Employee> getAll() throws AppException {

        Optional<List<Employee>> employeeList = employeeRepository.findAllEmployess();

        if (employeeList.isPresent()) {
            Comparator<Employee> comparator = Comparator.comparing(Employee::getContractDate);
            return employeeList.get().stream().sorted(comparator).toList();
        }
        logger.info(Constant.EMPLOYEES_NOT_FOUND);
        throw new NoDataFoundException(Constant.EMPLOYEES_NOT_FOUND);
    }

    public List<Employee> getAll(final String document, final String position, final String status) throws AppException {
        Optional<List<Employee>> employeeList = employeeRepository.findAllEmployess(document, position, status);
        if (employeeList.isPresent()) {
            return employeeList.get();
        }
        logger.info(Constant.EMPLOYEES_NOT_FOUND);
        throw new NoDataFoundException(Constant.EMPLOYEES_NOT_FOUND);
    }
}

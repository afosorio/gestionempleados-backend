package com.co.flypass.gestionempleados.application;

import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.co.flypass.gestionempleados.domain.employee.EmployeeRepository;
import com.co.flypass.gestionempleados.domain.office.Office;
import com.co.flypass.gestionempleados.domain.office.OfficeRepository;
import com.co.flypass.gestionempleados.exception.AppException;
import com.co.flypass.gestionempleados.exception.NoDataFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;

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
            throw new NoDataFoundException("La oficina no Existe");
        }

        Optional<List<Employee>> sourceEmployee = employeeRepository.findByDocument(employee.getDocument());
        if (sourceEmployee.isPresent()) {
            throw new NoDataFoundException("El Empleado con documento " + employee.getDocument() + " ya existe");
        }

        if (Objects.isNull(employee.getStatus())) {
            throw new AppException("El estado No Existe");
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
        throw new NoDataFoundException("Empleado no encontrado");
    }

    public Integer countByOfficeId(long id) {
        return employeeRepository.countByOfficeId(id);
    }

    public List<Employee> getAll() throws AppException {

        Optional<List<Employee>> employeeList = employeeRepository.findAllEmployess();

        if (employeeList.isPresent()) {
            Comparator<Employee> comparator = Comparator.comparing(Employee::getContractDate);
            return employeeList.get().stream().sorted(comparator).toList();
        }
        throw new NoDataFoundException("No se encontraron Empleados");
    }

    public List<Employee> getAll(final String document, final String position, final String status) throws AppException {
        Optional<List<Employee>> employeeList = employeeRepository.findAllEmployess(document, position, status);
        if (employeeList.isPresent()) {
            return employeeList.get();
        }
        throw new NoDataFoundException("No se encontraron Empleados");
    }
}

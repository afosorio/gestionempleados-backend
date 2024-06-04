package com.co.flypass.gestionempleados.application;

import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.co.flypass.gestionempleados.domain.employee.EmployeeRepository;
import com.co.flypass.gestionempleados.exception.AppException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public void update(Employee employee){
        employeeRepository.update(employee);
    }

    public void updatePosition(Long id, String position) throws Exception {
        Employee employee =  getEmployeeById(id);
        employee.setPosition(position);
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) throws Exception {

         Optional<Employee> employee = employeeRepository.findByEmployeeId(id);
         if(employee.isPresent()){
             return employee.get();
         }
         throw new AppException("Empleado no encontrado");
    }

    public Integer countByOfficeId(Long id) throws Exception {
        return employeeRepository.countByOfficeId(id);

    }
    public List<Employee> getAll(){
       return employeeRepository.findAllEmployess();
    }
}

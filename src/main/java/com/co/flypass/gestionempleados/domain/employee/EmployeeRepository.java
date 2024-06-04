package com.co.flypass.gestionempleados.domain.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    void save(Employee employee);

    void update(Employee employee);

    Optional<Employee> findByEmployeeId(Long officeId);

    List<Employee> findAllEmployess();

    Integer countByOfficeId(long officeId);
}

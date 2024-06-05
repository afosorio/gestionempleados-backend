package com.co.flypass.gestionempleados.domain.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    void save(Employee employee);

    void update(Employee employee);

    Optional<Employee> findByEmployeeId(Long officeId);

    Optional<List<Employee>> findByDocument(String document);

    Optional<List<Employee>> findAllEmployess();

    Optional<List<Employee>> findAllEmployess( final String document,
    final String position,
    final String status);

    Integer countByOfficeId(long officeId);
}

package com.co.flypass.gestionempleados.domain.employee;

import com.co.flypass.gestionempleados.domain.office.Office;
import java.util.Optional;

public interface EmployeeRepository {

    void save(Employee employee);
    void update(Employee employee);
    void delete(Long id);
    Optional<Office> findByEmployeeId(Long officeId);
}

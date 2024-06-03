package com.co.flypass.gestionempleados.infraestructure.persistence.employee;

import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.co.flypass.gestionempleados.domain.employee.EmployeeRepository;
import com.co.flypass.gestionempleados.domain.office.Office;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepositoryImpl extends CrudRepository<EmployeeEntity, Long>, EmployeeRepository {

    @Override
    default void save(Employee employee) {

    }

    @Override
    default void update(Employee employee) {

    }

    @Override
    default void delete(Long id) {

    }

    @Override
    default Optional<Office> findByEmployeeId(Long officeId) {
        return Optional.empty();
    }
}

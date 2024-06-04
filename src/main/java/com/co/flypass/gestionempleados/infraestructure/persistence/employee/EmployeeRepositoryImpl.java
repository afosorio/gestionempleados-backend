package com.co.flypass.gestionempleados.infraestructure.persistence.employee;

import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.co.flypass.gestionempleados.domain.employee.EmployeeRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface EmployeeRepositoryImpl extends ListCrudRepository<EmployeeEntity, Long>, EmployeeRepository {

    @Override
    default void save(Employee employee) {
        save(EmployeeEntity.fromDomain(employee));
    }

    @Override
    default void update(Employee employee) {
        save(employee);
    }

    @Override
    default Optional<Employee> findByEmployeeId(Long officeId) {
       return findById(officeId).map(EmployeeEntity::toDomain);
    }

    @Override
    default List<Employee> findAllEmployess() {
       return findAll().stream().map(EmployeeEntity::toDomain).collect(Collectors.toList());
    }

}
package com.co.flypass.gestionempleados.infraestructure.persistence.employee;

import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.co.flypass.gestionempleados.domain.employee.EmployeeRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepositoryImpl extends ListCrudRepository<EmployeeEntity, Long>,
        JpaSpecificationExecutor<EmployeeEntity>, EmployeeRepository {

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
    default Optional<List<Employee>>  findAllEmployess() {
        List<Employee> listDomain = findAll().stream().map(EmployeeEntity::toDomain).toList();
        if (listDomain.isEmpty()) return Optional.empty();
        return Optional.of(listDomain);
    }

    @Override
    default Optional<List<Employee>> findByDocument(String document){
        return findAllEmployess(document, null, null);
    }

    @Override
    default Optional<List<Employee>>  findAllEmployess(String document, String position, String status) {

        Specification<EmployeeEntity> specification = EmployeeSpecification.get(document, position, status);
        List<EmployeeEntity> listEntity = findAll(specification);
        List<Employee> listDomain = listEntity.stream().map(EmployeeEntity::toDomain).toList();

        if (listDomain.isEmpty()) return Optional.empty();
        return Optional.of(listDomain);
    }
}
package com.co.flypass.gestionempleados.infraestructure.persistence.office;

import com.co.flypass.gestionempleados.domain.office.Office;
import com.co.flypass.gestionempleados.domain.office.OfficeRepository;
import com.co.flypass.gestionempleados.infraestructure.persistence.employee.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficeRepositoryImpl extends CrudRepository<OfficeEntity, Long>, OfficeRepository {

    @Override
    default void save(Office domain) {
        save(OfficeEntity.fromDomain(domain));
    }

    @Override
    default Optional<Office> findOfficeById(long id){
        return findById(id).map(OfficeEntity::toDomain);
    }
}

package com.co.flypass.gestionempleados.infraestructure.persistence.office;

import com.co.flypass.gestionempleados.domain.office.Office;
import com.co.flypass.gestionempleados.domain.office.OfficeRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepositoryImpl extends CrudRepository<OfficeEntity, Long>, OfficeRepository {

    @Override
    default void save(Office domain) {
        save(OfficeEntity.fromDomain(domain));
    }

}

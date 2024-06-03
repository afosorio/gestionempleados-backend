package com.co.flypass.gestionempleados.infraestructure.persistence.office;

import com.co.flypass.gestionempleados.domain.office.Office;
import com.co.flypass.gestionempleados.domain.office.OfficeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficeRepositoryImpl extends CrudRepository<OfficeEntity, Long>, OfficeRepository {

    @Override
    default void save(Office domain) {

        OfficeEntity entity = new OfficeEntity();
        BeanUtils.copyProperties(domain, entity);
        save(entity);
    }

    @Override
    default void update(Office office) {

    }

    @Override
    default Optional<Office> findByOfficeId(Long aLong) {
        return Optional.empty();
    }
}

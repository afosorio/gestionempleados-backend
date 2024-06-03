package com.co.flypass.gestionempleados.domain.office;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfficeRepository {

    void save(Office office);
    void update(Office office);

    Optional<Office> findByOfficeId(Long officeId);

}

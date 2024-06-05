package com.co.flypass.gestionempleados.domain.office;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficeRepository {

    void save(Office office);

    Optional<Office> findOfficeById(long id);
}

package com.co.flypass.gestionempleados.domain.office;

import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository {

    void save(Office office);
}

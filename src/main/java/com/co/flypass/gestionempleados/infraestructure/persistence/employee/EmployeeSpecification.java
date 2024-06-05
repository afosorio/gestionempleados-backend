package com.co.flypass.gestionempleados.infraestructure.persistence.employee;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeSpecification {

    public static Specification<EmployeeEntity> get( String document, String position, String status) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(document) && !document.isEmpty()) {

                predicates.add(cb.equal(root.get("document"), document));
            }

            if (Objects.nonNull(position) && !position.isEmpty()) {
                predicates.add(cb.equal(root.get("position"), position));
            }

            if (Objects.nonNull(status) && !status.isEmpty()) {
                predicates.add(cb.equal(root.get("status"), status));
            }
            return cb.and(predicates.toArray(new Predicate[] {}));
        };
    }
}

package com.co.flypass.gestionempleados.infraestructure.persistence.office;

import com.co.flypass.gestionempleados.domain.office.Office;
import com.co.flypass.gestionempleados.infraestructure.persistence.employee.EmployeeEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tb_offices")
public class OfficeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private long geographicalLocation;

    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private List<EmployeeEntity> employees;

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public OfficeEntity(Long id, String name, long geographicalLocation) {
        this.id = id;
        this.name = name;
        this.geographicalLocation = geographicalLocation;
    }

    public OfficeEntity(Long id) {
        this.id = id;
    }
    public OfficeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGeographicalLocation() {
        return geographicalLocation;
    }

    public void setGeographicalLocation(long geographicalLocation) {
        this.geographicalLocation = geographicalLocation;
    }

    public static OfficeEntity fromDomain(final Office office) {
        return new OfficeEntity(
                office.getId(),
                office.getName(),
                office.getGeographicalLocation().id()
        );
    }

    public Office toDomain() {

        return new Office(
                this.id,
                this.name,
                this.geographicalLocation

        );
    }
}
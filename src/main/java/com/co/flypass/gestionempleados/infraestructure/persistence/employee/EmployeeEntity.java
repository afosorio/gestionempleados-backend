package com.co.flypass.gestionempleados.infraestructure.persistence.employee;

import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.co.flypass.gestionempleados.infraestructure.persistence.office.OfficeEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tb_employees")
public class EmployeeEntity
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private String document;

    @Column(name = "position")
    private String position;

    @Column(name = "contractDate")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate contractDate;

    @Column(name = "status")
    private String status;

    @Column(name = "salary")
    private Double salary;

    @ManyToOne(fetch = FetchType.LAZY)
    private OfficeEntity office;

    public EmployeeEntity(Long id, String name, String document, String position, LocalDate contractDate, String status, Double salary, OfficeEntity office) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.position = position;
        this.contractDate = contractDate;
        this.status = status;
        this.salary = salary;
        this.office = office;
    }

    public EmployeeEntity() {
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public OfficeEntity getOffice() {
        return office;
    }

    public void setOffice(OfficeEntity office) {
        this.office = office;
    }

    public static EmployeeEntity fromDomain(final Employee employee) {
        return new EmployeeEntity(
                employee.getId(),
                employee.getName(),
                employee.getDocument(),
                employee.getPosition(),
                employee.getContractDate(),
                employee.getStatus(),
                employee.getSalary(),
                OfficeEntity.fromDomain(employee.getOffice())
        );
    }

    public Employee toDomain() {
        return new Employee(
                this.id,
                this.name,
                this.document,
                this.position,
                this.contractDate,
                this.status,
                this.salary,
                this.office.toDomain()
        );
    }
}

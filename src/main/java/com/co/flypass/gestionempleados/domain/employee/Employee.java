package com.co.flypass.gestionempleados.domain.employee;

import com.co.flypass.gestionempleados.domain.office.Location;
import com.co.flypass.gestionempleados.domain.office.Office;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private Long id;
    private String name;
    private String document;
    private String position;
    private LocalDate contractDate;
    private Estatus status;
    private Double salary;
    private Office office;

    public Employee(Long id, String name, String document, String position, LocalDate contractDate, long status, Double salary, Office office) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.position = position;
        this.contractDate = contractDate;
        this.salary = salary;
        this.office = office;

        EnumEmployeeStatus enumEmployeeStatus = EnumEmployeeStatus.findById(status);
        if(Objects.nonNull(enumEmployeeStatus)){
            this.status = new Estatus(enumEmployeeStatus.ordinal(), enumEmployeeStatus.getValue());
        }
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

    public Estatus getStatus() {
        return status;
    }

    public void setStatus(Estatus status) {
        this.status = status;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}

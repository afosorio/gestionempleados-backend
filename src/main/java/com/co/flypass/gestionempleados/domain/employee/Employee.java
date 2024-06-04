package com.co.flypass.gestionempleados.domain.employee;

import com.co.flypass.gestionempleados.domain.office.Office;

import java.time.LocalDate;

public class Employee {

    private Long id;
    private String name;
    private String document;
    private String position;
    private LocalDate contractDate;
    private String status;
    private Double salary;
    private Office office;

    public Employee(Long id, String name, String document, String position, LocalDate contractDate, String status, Double salary, Office office) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.position = position;
        this.contractDate = contractDate;
        this.status = status;
        this.salary = salary;
        this.office = office;
    }

    public Employee(){}

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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}

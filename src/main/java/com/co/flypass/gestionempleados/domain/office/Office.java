package com.co.flypass.gestionempleados.domain.office;

import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Office {

    private Long id;
    private String name;
    private String geographicalLocation;

    @JsonIgnore
    private List<Employee> employees;

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

    public String getGeographicalLocation() {
        return geographicalLocation;
    }

    public void setGeographicalLocation(String geographicalLocation) {
        this.geographicalLocation = geographicalLocation;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

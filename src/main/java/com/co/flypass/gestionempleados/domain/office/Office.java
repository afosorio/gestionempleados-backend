package com.co.flypass.gestionempleados.domain.office;

import com.co.flypass.gestionempleados.domain.Constant;
import com.co.flypass.gestionempleados.domain.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

public class Office {

    private Long id;
    @NotBlank(message =  Constant.MESSAGE)
    private String name;

    @NotNull(message =  Constant.MESSAGE)
    private Location geographicalLocation;
    @JsonIgnore
    private List<Employee> employees;

    public Office(Long id, String name, long geographicalLocation)  {
        this.id = id;
        this.name = name;
        EnumOfficeLocation enumOfficeLocation = EnumOfficeLocation.findById(geographicalLocation);
        if(Objects.nonNull(enumOfficeLocation)){
            this.geographicalLocation =  new Location(enumOfficeLocation.ordinal(), enumOfficeLocation.getValue());
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

    public Location getGeographicalLocation() {
        return geographicalLocation;
    }

    public void setGeographicalLocation(Location geographicalLocation) {
        this.geographicalLocation = geographicalLocation;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

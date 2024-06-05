package com.co.flypass.gestionempleados.domain.office;

import java.util.Arrays;
import java.util.Optional;

public enum EnumOfficeLocation {

    CITY_ONE("Medellín"),
    CITY_TWO("Bogotá"),
    CITY_THREE("Armenia"),
    CITY_FOUR("Santa Marta");

    private final String value;

    EnumOfficeLocation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static EnumOfficeLocation findById(long id) {

        Optional<EnumOfficeLocation> location = Arrays.stream(EnumOfficeLocation.values()).filter((enumOfficeLocation)-> enumOfficeLocation.ordinal() == id).findAny();
        return location.orElse(null);
    }
}

package com.co.flypass.gestionempleados.domain.office;

import java.util.Arrays;

 enum EnumOfficeLocation {

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

    public static EnumOfficeLocation findById(long id){

        return Arrays.stream(EnumOfficeLocation.values())
                .filter(enumOfficeLocation -> enumOfficeLocation.ordinal() == id).
                findAny().get();
    }
}

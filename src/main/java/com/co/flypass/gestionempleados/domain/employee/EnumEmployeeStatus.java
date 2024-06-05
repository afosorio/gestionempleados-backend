package com.co.flypass.gestionempleados.domain.employee;

import com.co.flypass.gestionempleados.domain.office.EnumOfficeLocation;

import java.util.Arrays;
import java.util.Optional;

public enum EnumEmployeeStatus {

   CREATED("Creado"),
   BLOCKED("Bloqueado"),
   FREE("Libre");

   private final String value;

   EnumEmployeeStatus(String value) {
       this.value = value;
   }

   public String getValue() {
       return this.value;
   }

   public static EnumEmployeeStatus findById(long id){
       Optional<EnumEmployeeStatus> employeeStatus = Arrays.stream(EnumEmployeeStatus.values()).filter((enumEmployeeStatus)-> enumEmployeeStatus.ordinal() == id).findAny();
       return employeeStatus.orElse(null);
   }
}

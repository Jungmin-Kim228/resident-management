package com.nhnacademy.resimanage.domain.resident;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ResidentRequest {
    Integer residentSerialNumber;
    String name;
    String residentRegistrationNumber;
    String genderCode;
    LocalDateTime birthDate;
    String birthPlaceCode;
    String registrationBaseAddress;
}

package com.nhnacademy.resimanage.domain.resident;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ResidentModifyRequest {
    String name;
    String residentRegistrationNumber;
    String genderCode;
    LocalDateTime birthDate;
    String birthPlaceCode;
    String registrationBaseAddress;
    LocalDateTime deathDate;
    String deathPlaceCode;
    String deathPlaceAddress;
}

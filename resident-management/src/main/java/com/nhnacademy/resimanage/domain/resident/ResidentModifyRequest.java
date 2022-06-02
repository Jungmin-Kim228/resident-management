package com.nhnacademy.resimanage.domain.resident;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ResidentModifyRequest {
    String name;
    String residentRegistrationNumber;
    String genderCode;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime birthDate;
    String birthPlaceCode;
    String registrationBaseAddress;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime deathDate;
    String deathPlaceCode;
    String deathPlaceAddress;
}

package com.nhnacademy.resimanage.domain.resident;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public interface ResidentDto {
    Integer getResidentSerialNumber();
    String getName();
    String getResidentRegistrationNumber();
    String getGenderCode();
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime getBirthDate();
    String getBirthPlaceCode();
    String getRegistrationBaseAddress();
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime getDeathDate();
    String getDeathPlaceCode();
    String getDeathPlaceAddress();
}

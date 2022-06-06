package com.nhnacademy.resimanage.repository.custom;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface HouseholdCompositionResidentRepositoryCustom {

    Integer getHouseholdSerialNumByResident(Integer residentNum);
}

package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.entity.Household;
import com.nhnacademy.resimanage.repository.custom.HouseholdRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, Integer>,
    HouseholdRepositoryCustom {

    @Query("select i from Household i where i.householdSerialNumber = ?1")
    Household getHouseholdByHouseholdSerialNumber(Integer householdSerialNumber);
}

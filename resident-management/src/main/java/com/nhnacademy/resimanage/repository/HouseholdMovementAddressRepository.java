package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.entity.HouseholdMovementAddress;
import com.nhnacademy.resimanage.repository.custom.HouseholdMovementAddressRepositoryCustom;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.Pk>,
    HouseholdMovementAddressRepositoryCustom {

    @Query(value = "select * from household_movement_address where house_movement_report_date = ?1 and household_serial_number = ?2", nativeQuery = true)
    HouseholdMovementAddress getHouseholdMovementAddressByTwoKeys(LocalDate houseMovementReportDate,
                                                                  Integer householdSerialNumber);
}

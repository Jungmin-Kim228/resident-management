package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.entity.HouseholdMovementAddress;
import com.nhnacademy.resimanage.repository.custom.HouseholdMovementAddressRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.Pk>,
    HouseholdMovementAddressRepositoryCustom {


}

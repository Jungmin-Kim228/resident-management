package com.nhnacademy.resimanage.repository;

import com.nhnacademy.resimanage.entity.CertificateIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<CertificateIssue, Long> {

}

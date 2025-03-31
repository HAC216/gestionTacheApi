package com.uqam.mgl7010.application_web.Repositories;

import com.uqam.mgl7010.application_web.Entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}

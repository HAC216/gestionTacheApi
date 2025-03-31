package com.uqam.mgl7010.application_web.Repositories;

import com.uqam.mgl7010.application_web.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}

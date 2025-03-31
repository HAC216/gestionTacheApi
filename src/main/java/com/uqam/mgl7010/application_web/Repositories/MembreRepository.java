package com.uqam.mgl7010.application_web.Repositories;


import com.uqam.mgl7010.application_web.Entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<Membre, Long> {
}

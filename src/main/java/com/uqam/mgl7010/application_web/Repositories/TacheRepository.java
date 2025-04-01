package com.uqam.mgl7010.application_web.Repositories;

import com.uqam.mgl7010.application_web.Entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}

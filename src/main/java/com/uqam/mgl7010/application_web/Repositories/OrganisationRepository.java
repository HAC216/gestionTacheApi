package com.uqam.mgl7010.application_web.Repositories;

import com.uqam.mgl7010.application_web.Entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation , Long> {
}

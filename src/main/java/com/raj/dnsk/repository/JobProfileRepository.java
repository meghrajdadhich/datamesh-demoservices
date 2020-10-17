package com.raj.dnsk.repository;

import com.raj.dnsk.domain.JobProfile;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the JobProfile entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JobProfileRepository extends JpaRepository<JobProfile, Long> {
}

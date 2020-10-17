package com.raj.dnsk.repository;

import com.raj.dnsk.domain.WorkProfile;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WorkProfile entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WorkProfileRepository extends JpaRepository<WorkProfile, Long> {
}

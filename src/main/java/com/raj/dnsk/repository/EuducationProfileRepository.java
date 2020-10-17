package com.raj.dnsk.repository;

import com.raj.dnsk.domain.EuducationProfile;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EuducationProfile entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EuducationProfileRepository extends JpaRepository<EuducationProfile, Long> {
}

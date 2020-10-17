package com.raj.dnsk.repository;

import com.raj.dnsk.domain.PersonNetwork;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PersonNetwork entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PersonNetworkRepository extends JpaRepository<PersonNetwork, Long> {
}

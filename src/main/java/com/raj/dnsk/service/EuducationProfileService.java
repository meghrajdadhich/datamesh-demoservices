package com.raj.dnsk.service;

import com.raj.dnsk.domain.EuducationProfile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link EuducationProfile}.
 */
public interface EuducationProfileService {

    /**
     * Save a euducationProfile.
     *
     * @param euducationProfile the entity to save.
     * @return the persisted entity.
     */
    EuducationProfile save(EuducationProfile euducationProfile);

    /**
     * Get all the euducationProfiles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<EuducationProfile> findAll(Pageable pageable);


    /**
     * Get the "id" euducationProfile.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EuducationProfile> findOne(Long id);

    /**
     * Delete the "id" euducationProfile.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

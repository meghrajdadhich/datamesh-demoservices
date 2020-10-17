package com.raj.dnsk.service;

import com.raj.dnsk.domain.WorkProfile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link WorkProfile}.
 */
public interface WorkProfileService {

    /**
     * Save a workProfile.
     *
     * @param workProfile the entity to save.
     * @return the persisted entity.
     */
    WorkProfile save(WorkProfile workProfile);

    /**
     * Get all the workProfiles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<WorkProfile> findAll(Pageable pageable);


    /**
     * Get the "id" workProfile.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<WorkProfile> findOne(Long id);

    /**
     * Delete the "id" workProfile.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

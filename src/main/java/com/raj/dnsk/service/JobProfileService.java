package com.raj.dnsk.service;

import com.raj.dnsk.domain.JobProfile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link JobProfile}.
 */
public interface JobProfileService {

    /**
     * Save a jobProfile.
     *
     * @param jobProfile the entity to save.
     * @return the persisted entity.
     */
    JobProfile save(JobProfile jobProfile);

    /**
     * Get all the jobProfiles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<JobProfile> findAll(Pageable pageable);


    /**
     * Get the "id" jobProfile.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<JobProfile> findOne(Long id);

    /**
     * Delete the "id" jobProfile.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

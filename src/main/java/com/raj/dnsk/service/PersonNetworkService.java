package com.raj.dnsk.service;

import com.raj.dnsk.domain.PersonNetwork;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link PersonNetwork}.
 */
public interface PersonNetworkService {

    /**
     * Save a personNetwork.
     *
     * @param personNetwork the entity to save.
     * @return the persisted entity.
     */
    PersonNetwork save(PersonNetwork personNetwork);

    /**
     * Get all the personNetworks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PersonNetwork> findAll(Pageable pageable);


    /**
     * Get the "id" personNetwork.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PersonNetwork> findOne(Long id);

    /**
     * Delete the "id" personNetwork.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

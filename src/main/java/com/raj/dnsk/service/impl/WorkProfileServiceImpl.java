package com.raj.dnsk.service.impl;

import com.raj.dnsk.service.WorkProfileService;
import com.raj.dnsk.domain.WorkProfile;
import com.raj.dnsk.repository.WorkProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link WorkProfile}.
 */
@Service
@Transactional
public class WorkProfileServiceImpl implements WorkProfileService {

    private final Logger log = LoggerFactory.getLogger(WorkProfileServiceImpl.class);

    private final WorkProfileRepository workProfileRepository;

    public WorkProfileServiceImpl(WorkProfileRepository workProfileRepository) {
        this.workProfileRepository = workProfileRepository;
    }

    @Override
    public WorkProfile save(WorkProfile workProfile) {
        log.debug("Request to save WorkProfile : {}", workProfile);
        return workProfileRepository.save(workProfile);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<WorkProfile> findAll(Pageable pageable) {
        log.debug("Request to get all WorkProfiles");
        return workProfileRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<WorkProfile> findOne(Long id) {
        log.debug("Request to get WorkProfile : {}", id);
        return workProfileRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete WorkProfile : {}", id);
        workProfileRepository.deleteById(id);
    }
}

package com.raj.dnsk.service.impl;

import com.raj.dnsk.service.JobProfileService;
import com.raj.dnsk.domain.JobProfile;
import com.raj.dnsk.repository.JobProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link JobProfile}.
 */
@Service
@Transactional
public class JobProfileServiceImpl implements JobProfileService {

    private final Logger log = LoggerFactory.getLogger(JobProfileServiceImpl.class);

    private final JobProfileRepository jobProfileRepository;

    public JobProfileServiceImpl(JobProfileRepository jobProfileRepository) {
        this.jobProfileRepository = jobProfileRepository;
    }

    @Override
    public JobProfile save(JobProfile jobProfile) {
        log.debug("Request to save JobProfile : {}", jobProfile);
        return jobProfileRepository.save(jobProfile);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<JobProfile> findAll(Pageable pageable) {
        log.debug("Request to get all JobProfiles");
        return jobProfileRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<JobProfile> findOne(Long id) {
        log.debug("Request to get JobProfile : {}", id);
        return jobProfileRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete JobProfile : {}", id);
        jobProfileRepository.deleteById(id);
    }
}

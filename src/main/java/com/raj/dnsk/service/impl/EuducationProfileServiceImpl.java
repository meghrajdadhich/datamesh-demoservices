package com.raj.dnsk.service.impl;

import com.raj.dnsk.service.EuducationProfileService;
import com.raj.dnsk.domain.EuducationProfile;
import com.raj.dnsk.repository.EuducationProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link EuducationProfile}.
 */
@Service
@Transactional
public class EuducationProfileServiceImpl implements EuducationProfileService {

    private final Logger log = LoggerFactory.getLogger(EuducationProfileServiceImpl.class);

    private final EuducationProfileRepository euducationProfileRepository;

    public EuducationProfileServiceImpl(EuducationProfileRepository euducationProfileRepository) {
        this.euducationProfileRepository = euducationProfileRepository;
    }

    @Override
    public EuducationProfile save(EuducationProfile euducationProfile) {
        log.debug("Request to save EuducationProfile : {}", euducationProfile);
        return euducationProfileRepository.save(euducationProfile);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EuducationProfile> findAll(Pageable pageable) {
        log.debug("Request to get all EuducationProfiles");
        return euducationProfileRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<EuducationProfile> findOne(Long id) {
        log.debug("Request to get EuducationProfile : {}", id);
        return euducationProfileRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete EuducationProfile : {}", id);
        euducationProfileRepository.deleteById(id);
    }
}

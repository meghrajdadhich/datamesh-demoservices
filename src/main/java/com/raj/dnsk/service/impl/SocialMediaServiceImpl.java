package com.raj.dnsk.service.impl;

import com.raj.dnsk.service.SocialMediaService;
import com.raj.dnsk.domain.SocialMedia;
import com.raj.dnsk.repository.SocialMediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SocialMedia}.
 */
@Service
@Transactional
public class SocialMediaServiceImpl implements SocialMediaService {

    private final Logger log = LoggerFactory.getLogger(SocialMediaServiceImpl.class);

    private final SocialMediaRepository socialMediaRepository;

    public SocialMediaServiceImpl(SocialMediaRepository socialMediaRepository) {
        this.socialMediaRepository = socialMediaRepository;
    }

    @Override
    public SocialMedia save(SocialMedia socialMedia) {
        log.debug("Request to save SocialMedia : {}", socialMedia);
        return socialMediaRepository.save(socialMedia);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SocialMedia> findAll(Pageable pageable) {
        log.debug("Request to get all SocialMedias");
        return socialMediaRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<SocialMedia> findOne(Long id) {
        log.debug("Request to get SocialMedia : {}", id);
        return socialMediaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SocialMedia : {}", id);
        socialMediaRepository.deleteById(id);
    }
}

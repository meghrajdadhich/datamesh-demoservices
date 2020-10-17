package com.raj.dnsk.service.impl;

import com.raj.dnsk.service.ContactInfoService;
import com.raj.dnsk.domain.ContactInfo;
import com.raj.dnsk.repository.ContactInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ContactInfo}.
 */
@Service
@Transactional
public class ContactInfoServiceImpl implements ContactInfoService {

    private final Logger log = LoggerFactory.getLogger(ContactInfoServiceImpl.class);

    private final ContactInfoRepository contactInfoRepository;

    public ContactInfoServiceImpl(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public ContactInfo save(ContactInfo contactInfo) {
        log.debug("Request to save ContactInfo : {}", contactInfo);
        return contactInfoRepository.save(contactInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ContactInfo> findAll(Pageable pageable) {
        log.debug("Request to get all ContactInfos");
        return contactInfoRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ContactInfo> findOne(Long id) {
        log.debug("Request to get ContactInfo : {}", id);
        return contactInfoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ContactInfo : {}", id);
        contactInfoRepository.deleteById(id);
    }
}

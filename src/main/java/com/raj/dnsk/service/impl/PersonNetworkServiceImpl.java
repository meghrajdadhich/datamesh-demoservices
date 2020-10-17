package com.raj.dnsk.service.impl;

import com.raj.dnsk.service.PersonNetworkService;
import com.raj.dnsk.domain.PersonNetwork;
import com.raj.dnsk.repository.PersonNetworkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PersonNetwork}.
 */
@Service
@Transactional
public class PersonNetworkServiceImpl implements PersonNetworkService {

    private final Logger log = LoggerFactory.getLogger(PersonNetworkServiceImpl.class);

    private final PersonNetworkRepository personNetworkRepository;

    public PersonNetworkServiceImpl(PersonNetworkRepository personNetworkRepository) {
        this.personNetworkRepository = personNetworkRepository;
    }

    @Override
    public PersonNetwork save(PersonNetwork personNetwork) {
        log.debug("Request to save PersonNetwork : {}", personNetwork);
        return personNetworkRepository.save(personNetwork);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PersonNetwork> findAll(Pageable pageable) {
        log.debug("Request to get all PersonNetworks");
        return personNetworkRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<PersonNetwork> findOne(Long id) {
        log.debug("Request to get PersonNetwork : {}", id);
        return personNetworkRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PersonNetwork : {}", id);
        personNetworkRepository.deleteById(id);
    }
}

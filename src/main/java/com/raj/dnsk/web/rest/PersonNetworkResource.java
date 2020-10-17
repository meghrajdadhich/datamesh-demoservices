package com.raj.dnsk.web.rest;

import com.raj.dnsk.domain.PersonNetwork;
import com.raj.dnsk.service.PersonNetworkService;
import com.raj.dnsk.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.raj.dnsk.domain.PersonNetwork}.
 */
@RestController
@RequestMapping("/api")
public class PersonNetworkResource {

    private final Logger log = LoggerFactory.getLogger(PersonNetworkResource.class);

    private static final String ENTITY_NAME = "personNetwork";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PersonNetworkService personNetworkService;

    public PersonNetworkResource(PersonNetworkService personNetworkService) {
        this.personNetworkService = personNetworkService;
    }

    /**
     * {@code POST  /person-networks} : Create a new personNetwork.
     *
     * @param personNetwork the personNetwork to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new personNetwork, or with status {@code 400 (Bad Request)} if the personNetwork has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/person-networks")
    public ResponseEntity<PersonNetwork> createPersonNetwork(@RequestBody PersonNetwork personNetwork) throws URISyntaxException {
        log.debug("REST request to save PersonNetwork : {}", personNetwork);
        if (personNetwork.getId() != null) {
            throw new BadRequestAlertException("A new personNetwork cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PersonNetwork result = personNetworkService.save(personNetwork);
        return ResponseEntity.created(new URI("/api/person-networks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /person-networks} : Updates an existing personNetwork.
     *
     * @param personNetwork the personNetwork to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated personNetwork,
     * or with status {@code 400 (Bad Request)} if the personNetwork is not valid,
     * or with status {@code 500 (Internal Server Error)} if the personNetwork couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/person-networks")
    public ResponseEntity<PersonNetwork> updatePersonNetwork(@RequestBody PersonNetwork personNetwork) throws URISyntaxException {
        log.debug("REST request to update PersonNetwork : {}", personNetwork);
        if (personNetwork.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PersonNetwork result = personNetworkService.save(personNetwork);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, personNetwork.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /person-networks} : get all the personNetworks.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of personNetworks in body.
     */
    @GetMapping("/person-networks")
    public ResponseEntity<List<PersonNetwork>> getAllPersonNetworks(Pageable pageable) {
        log.debug("REST request to get a page of PersonNetworks");
        Page<PersonNetwork> page = personNetworkService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /person-networks/:id} : get the "id" personNetwork.
     *
     * @param id the id of the personNetwork to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the personNetwork, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/person-networks/{id}")
    public ResponseEntity<PersonNetwork> getPersonNetwork(@PathVariable Long id) {
        log.debug("REST request to get PersonNetwork : {}", id);
        Optional<PersonNetwork> personNetwork = personNetworkService.findOne(id);
        return ResponseUtil.wrapOrNotFound(personNetwork);
    }

    /**
     * {@code DELETE  /person-networks/:id} : delete the "id" personNetwork.
     *
     * @param id the id of the personNetwork to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/person-networks/{id}")
    public ResponseEntity<Void> deletePersonNetwork(@PathVariable Long id) {
        log.debug("REST request to delete PersonNetwork : {}", id);
        personNetworkService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}

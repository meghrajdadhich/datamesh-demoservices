package com.raj.dnsk.web.rest;

import com.raj.dnsk.domain.WorkProfile;
import com.raj.dnsk.service.WorkProfileService;
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
 * REST controller for managing {@link com.raj.dnsk.domain.WorkProfile}.
 */
@RestController
@RequestMapping("/api")
public class WorkProfileResource {

    private final Logger log = LoggerFactory.getLogger(WorkProfileResource.class);

    private static final String ENTITY_NAME = "workProfile";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WorkProfileService workProfileService;

    public WorkProfileResource(WorkProfileService workProfileService) {
        this.workProfileService = workProfileService;
    }

    /**
     * {@code POST  /work-profiles} : Create a new workProfile.
     *
     * @param workProfile the workProfile to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new workProfile, or with status {@code 400 (Bad Request)} if the workProfile has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/work-profiles")
    public ResponseEntity<WorkProfile> createWorkProfile(@RequestBody WorkProfile workProfile) throws URISyntaxException {
        log.debug("REST request to save WorkProfile : {}", workProfile);
        if (workProfile.getId() != null) {
            throw new BadRequestAlertException("A new workProfile cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WorkProfile result = workProfileService.save(workProfile);
        return ResponseEntity.created(new URI("/api/work-profiles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /work-profiles} : Updates an existing workProfile.
     *
     * @param workProfile the workProfile to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated workProfile,
     * or with status {@code 400 (Bad Request)} if the workProfile is not valid,
     * or with status {@code 500 (Internal Server Error)} if the workProfile couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/work-profiles")
    public ResponseEntity<WorkProfile> updateWorkProfile(@RequestBody WorkProfile workProfile) throws URISyntaxException {
        log.debug("REST request to update WorkProfile : {}", workProfile);
        if (workProfile.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WorkProfile result = workProfileService.save(workProfile);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, workProfile.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /work-profiles} : get all the workProfiles.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of workProfiles in body.
     */
    @GetMapping("/work-profiles")
    public ResponseEntity<List<WorkProfile>> getAllWorkProfiles(Pageable pageable) {
        log.debug("REST request to get a page of WorkProfiles");
        Page<WorkProfile> page = workProfileService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /work-profiles/:id} : get the "id" workProfile.
     *
     * @param id the id of the workProfile to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the workProfile, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/work-profiles/{id}")
    public ResponseEntity<WorkProfile> getWorkProfile(@PathVariable Long id) {
        log.debug("REST request to get WorkProfile : {}", id);
        Optional<WorkProfile> workProfile = workProfileService.findOne(id);
        return ResponseUtil.wrapOrNotFound(workProfile);
    }

    /**
     * {@code DELETE  /work-profiles/:id} : delete the "id" workProfile.
     *
     * @param id the id of the workProfile to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/work-profiles/{id}")
    public ResponseEntity<Void> deleteWorkProfile(@PathVariable Long id) {
        log.debug("REST request to delete WorkProfile : {}", id);
        workProfileService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}

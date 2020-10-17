package com.raj.dnsk.web.rest;

import com.raj.dnsk.domain.JobProfile;
import com.raj.dnsk.service.JobProfileService;
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
 * REST controller for managing {@link com.raj.dnsk.domain.JobProfile}.
 */
@RestController
@RequestMapping("/api")
public class JobProfileResource {

    private final Logger log = LoggerFactory.getLogger(JobProfileResource.class);

    private static final String ENTITY_NAME = "jobProfile";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final JobProfileService jobProfileService;

    public JobProfileResource(JobProfileService jobProfileService) {
        this.jobProfileService = jobProfileService;
    }

    /**
     * {@code POST  /job-profiles} : Create a new jobProfile.
     *
     * @param jobProfile the jobProfile to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new jobProfile, or with status {@code 400 (Bad Request)} if the jobProfile has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/job-profiles")
    public ResponseEntity<JobProfile> createJobProfile(@RequestBody JobProfile jobProfile) throws URISyntaxException {
        log.debug("REST request to save JobProfile : {}", jobProfile);
        if (jobProfile.getId() != null) {
            throw new BadRequestAlertException("A new jobProfile cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JobProfile result = jobProfileService.save(jobProfile);
        return ResponseEntity.created(new URI("/api/job-profiles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /job-profiles} : Updates an existing jobProfile.
     *
     * @param jobProfile the jobProfile to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated jobProfile,
     * or with status {@code 400 (Bad Request)} if the jobProfile is not valid,
     * or with status {@code 500 (Internal Server Error)} if the jobProfile couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/job-profiles")
    public ResponseEntity<JobProfile> updateJobProfile(@RequestBody JobProfile jobProfile) throws URISyntaxException {
        log.debug("REST request to update JobProfile : {}", jobProfile);
        if (jobProfile.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JobProfile result = jobProfileService.save(jobProfile);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, jobProfile.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /job-profiles} : get all the jobProfiles.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of jobProfiles in body.
     */
    @GetMapping("/job-profiles")
    public ResponseEntity<List<JobProfile>> getAllJobProfiles(Pageable pageable) {
        log.debug("REST request to get a page of JobProfiles");
        Page<JobProfile> page = jobProfileService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /job-profiles/:id} : get the "id" jobProfile.
     *
     * @param id the id of the jobProfile to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the jobProfile, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/job-profiles/{id}")
    public ResponseEntity<JobProfile> getJobProfile(@PathVariable Long id) {
        log.debug("REST request to get JobProfile : {}", id);
        Optional<JobProfile> jobProfile = jobProfileService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jobProfile);
    }

    /**
     * {@code DELETE  /job-profiles/:id} : delete the "id" jobProfile.
     *
     * @param id the id of the jobProfile to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/job-profiles/{id}")
    public ResponseEntity<Void> deleteJobProfile(@PathVariable Long id) {
        log.debug("REST request to delete JobProfile : {}", id);
        jobProfileService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}

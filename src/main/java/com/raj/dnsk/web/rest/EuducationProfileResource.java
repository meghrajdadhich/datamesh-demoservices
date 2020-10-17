package com.raj.dnsk.web.rest;

import com.raj.dnsk.domain.EuducationProfile;
import com.raj.dnsk.service.EuducationProfileService;
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
 * REST controller for managing {@link com.raj.dnsk.domain.EuducationProfile}.
 */
@RestController
@RequestMapping("/api")
public class EuducationProfileResource {

    private final Logger log = LoggerFactory.getLogger(EuducationProfileResource.class);

    private static final String ENTITY_NAME = "euducationProfile";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EuducationProfileService euducationProfileService;

    public EuducationProfileResource(EuducationProfileService euducationProfileService) {
        this.euducationProfileService = euducationProfileService;
    }

    /**
     * {@code POST  /euducation-profiles} : Create a new euducationProfile.
     *
     * @param euducationProfile the euducationProfile to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new euducationProfile, or with status {@code 400 (Bad Request)} if the euducationProfile has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/euducation-profiles")
    public ResponseEntity<EuducationProfile> createEuducationProfile(@RequestBody EuducationProfile euducationProfile) throws URISyntaxException {
        log.debug("REST request to save EuducationProfile : {}", euducationProfile);
        if (euducationProfile.getId() != null) {
            throw new BadRequestAlertException("A new euducationProfile cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EuducationProfile result = euducationProfileService.save(euducationProfile);
        return ResponseEntity.created(new URI("/api/euducation-profiles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /euducation-profiles} : Updates an existing euducationProfile.
     *
     * @param euducationProfile the euducationProfile to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated euducationProfile,
     * or with status {@code 400 (Bad Request)} if the euducationProfile is not valid,
     * or with status {@code 500 (Internal Server Error)} if the euducationProfile couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/euducation-profiles")
    public ResponseEntity<EuducationProfile> updateEuducationProfile(@RequestBody EuducationProfile euducationProfile) throws URISyntaxException {
        log.debug("REST request to update EuducationProfile : {}", euducationProfile);
        if (euducationProfile.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EuducationProfile result = euducationProfileService.save(euducationProfile);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, euducationProfile.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /euducation-profiles} : get all the euducationProfiles.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of euducationProfiles in body.
     */
    @GetMapping("/euducation-profiles")
    public ResponseEntity<List<EuducationProfile>> getAllEuducationProfiles(Pageable pageable) {
        log.debug("REST request to get a page of EuducationProfiles");
        Page<EuducationProfile> page = euducationProfileService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /euducation-profiles/:id} : get the "id" euducationProfile.
     *
     * @param id the id of the euducationProfile to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the euducationProfile, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/euducation-profiles/{id}")
    public ResponseEntity<EuducationProfile> getEuducationProfile(@PathVariable Long id) {
        log.debug("REST request to get EuducationProfile : {}", id);
        Optional<EuducationProfile> euducationProfile = euducationProfileService.findOne(id);
        return ResponseUtil.wrapOrNotFound(euducationProfile);
    }

    /**
     * {@code DELETE  /euducation-profiles/:id} : delete the "id" euducationProfile.
     *
     * @param id the id of the euducationProfile to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/euducation-profiles/{id}")
    public ResponseEntity<Void> deleteEuducationProfile(@PathVariable Long id) {
        log.debug("REST request to delete EuducationProfile : {}", id);
        euducationProfileService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}

package com.raj.dnsk.web.rest;

import com.raj.dnsk.domain.SocialMedia;
import com.raj.dnsk.service.SocialMediaService;
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
 * REST controller for managing {@link com.raj.dnsk.domain.SocialMedia}.
 */
@RestController
@RequestMapping("/api")
public class SocialMediaResource {

    private final Logger log = LoggerFactory.getLogger(SocialMediaResource.class);

    private static final String ENTITY_NAME = "socialMedia";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SocialMediaService socialMediaService;

    public SocialMediaResource(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    /**
     * {@code POST  /social-medias} : Create a new socialMedia.
     *
     * @param socialMedia the socialMedia to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new socialMedia, or with status {@code 400 (Bad Request)} if the socialMedia has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/social-medias")
    public ResponseEntity<SocialMedia> createSocialMedia(@RequestBody SocialMedia socialMedia) throws URISyntaxException {
        log.debug("REST request to save SocialMedia : {}", socialMedia);
        if (socialMedia.getId() != null) {
            throw new BadRequestAlertException("A new socialMedia cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SocialMedia result = socialMediaService.save(socialMedia);
        return ResponseEntity.created(new URI("/api/social-medias/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /social-medias} : Updates an existing socialMedia.
     *
     * @param socialMedia the socialMedia to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated socialMedia,
     * or with status {@code 400 (Bad Request)} if the socialMedia is not valid,
     * or with status {@code 500 (Internal Server Error)} if the socialMedia couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/social-medias")
    public ResponseEntity<SocialMedia> updateSocialMedia(@RequestBody SocialMedia socialMedia) throws URISyntaxException {
        log.debug("REST request to update SocialMedia : {}", socialMedia);
        if (socialMedia.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SocialMedia result = socialMediaService.save(socialMedia);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, socialMedia.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /social-medias} : get all the socialMedias.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of socialMedias in body.
     */
    @GetMapping("/social-medias")
    public ResponseEntity<List<SocialMedia>> getAllSocialMedias(Pageable pageable) {
        log.debug("REST request to get a page of SocialMedias");
        Page<SocialMedia> page = socialMediaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /social-medias/:id} : get the "id" socialMedia.
     *
     * @param id the id of the socialMedia to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the socialMedia, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/social-medias/{id}")
    public ResponseEntity<SocialMedia> getSocialMedia(@PathVariable Long id) {
        log.debug("REST request to get SocialMedia : {}", id);
        Optional<SocialMedia> socialMedia = socialMediaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(socialMedia);
    }

    /**
     * {@code DELETE  /social-medias/:id} : delete the "id" socialMedia.
     *
     * @param id the id of the socialMedia to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/social-medias/{id}")
    public ResponseEntity<Void> deleteSocialMedia(@PathVariable Long id) {
        log.debug("REST request to delete SocialMedia : {}", id);
        socialMediaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}

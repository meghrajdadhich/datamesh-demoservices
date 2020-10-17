package com.raj.dnsk.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A EuducationProfile.
 */
@Entity
@Table(name = "euducation_profile")
public class EuducationProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_user_id")
    private String personUserId;

    @Column(name = "education_title")
    private String educationTitle;

    @Column(name = "education_subject")
    private String educationSubject;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonUserId() {
        return personUserId;
    }

    public EuducationProfile personUserId(String personUserId) {
        this.personUserId = personUserId;
        return this;
    }

    public void setPersonUserId(String personUserId) {
        this.personUserId = personUserId;
    }

    public String getEducationTitle() {
        return educationTitle;
    }

    public EuducationProfile educationTitle(String educationTitle) {
        this.educationTitle = educationTitle;
        return this;
    }

    public void setEducationTitle(String educationTitle) {
        this.educationTitle = educationTitle;
    }

    public String getEducationSubject() {
        return educationSubject;
    }

    public EuducationProfile educationSubject(String educationSubject) {
        this.educationSubject = educationSubject;
        return this;
    }

    public void setEducationSubject(String educationSubject) {
        this.educationSubject = educationSubject;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public EuducationProfile startDate(Instant startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public EuducationProfile endDate(Instant endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EuducationProfile)) {
            return false;
        }
        return id != null && id.equals(((EuducationProfile) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EuducationProfile{" +
            "id=" + getId() +
            ", personUserId='" + getPersonUserId() + "'" +
            ", educationTitle='" + getEducationTitle() + "'" +
            ", educationSubject='" + getEducationSubject() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            "}";
    }
}

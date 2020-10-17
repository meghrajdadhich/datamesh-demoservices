package com.raj.dnsk.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A WorkProfile.
 */
@Entity
@Table(name = "work_profile")
public class WorkProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_user_id")
    private String personUserId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "company_name")
    private String companyName;

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

    public WorkProfile personUserId(String personUserId) {
        this.personUserId = personUserId;
        return this;
    }

    public void setPersonUserId(String personUserId) {
        this.personUserId = personUserId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public WorkProfile jobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public WorkProfile companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public WorkProfile startDate(Instant startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public WorkProfile endDate(Instant endDate) {
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
        if (!(o instanceof WorkProfile)) {
            return false;
        }
        return id != null && id.equals(((WorkProfile) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WorkProfile{" +
            "id=" + getId() +
            ", personUserId='" + getPersonUserId() + "'" +
            ", jobTitle='" + getJobTitle() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            "}";
    }
}

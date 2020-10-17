package com.raj.dnsk.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A JobProfile.
 */
@Entity
@Table(name = "job_profile")
public class JobProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_user_id")
    private String personUserId;

    @Column(name = "job_role")
    private String jobRole;

    @Column(name = "skills")
    private String skills;

    @Column(name = "experience")
    private Float experience;

    @Column(name = "job_location")
    private String jobLocation;

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

    public JobProfile personUserId(String personUserId) {
        this.personUserId = personUserId;
        return this;
    }

    public void setPersonUserId(String personUserId) {
        this.personUserId = personUserId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public JobProfile jobRole(String jobRole) {
        this.jobRole = jobRole;
        return this;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getSkills() {
        return skills;
    }

    public JobProfile skills(String skills) {
        this.skills = skills;
        return this;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Float getExperience() {
        return experience;
    }

    public JobProfile experience(Float experience) {
        this.experience = experience;
        return this;
    }

    public void setExperience(Float experience) {
        this.experience = experience;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public JobProfile jobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
        return this;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobProfile)) {
            return false;
        }
        return id != null && id.equals(((JobProfile) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JobProfile{" +
            "id=" + getId() +
            ", personUserId='" + getPersonUserId() + "'" +
            ", jobRole='" + getJobRole() + "'" +
            ", skills='" + getSkills() + "'" +
            ", experience=" + getExperience() +
            ", jobLocation='" + getJobLocation() + "'" +
            "}";
    }
}

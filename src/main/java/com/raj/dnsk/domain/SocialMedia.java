package com.raj.dnsk.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A SocialMedia.
 */
@Entity
@Table(name = "social_media")
public class SocialMedia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_user_id")
    private String personUserId;

    @Column(name = "social_media_url")
    private String socialMediaURL;

    @Column(name = "social_media_link")
    private String socialMediaLink;

    @Column(name = "socical_media_account")
    private String socicalMediaAccount;

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

    public SocialMedia personUserId(String personUserId) {
        this.personUserId = personUserId;
        return this;
    }

    public void setPersonUserId(String personUserId) {
        this.personUserId = personUserId;
    }

    public String getSocialMediaURL() {
        return socialMediaURL;
    }

    public SocialMedia socialMediaURL(String socialMediaURL) {
        this.socialMediaURL = socialMediaURL;
        return this;
    }

    public void setSocialMediaURL(String socialMediaURL) {
        this.socialMediaURL = socialMediaURL;
    }

    public String getSocialMediaLink() {
        return socialMediaLink;
    }

    public SocialMedia socialMediaLink(String socialMediaLink) {
        this.socialMediaLink = socialMediaLink;
        return this;
    }

    public void setSocialMediaLink(String socialMediaLink) {
        this.socialMediaLink = socialMediaLink;
    }

    public String getSocicalMediaAccount() {
        return socicalMediaAccount;
    }

    public SocialMedia socicalMediaAccount(String socicalMediaAccount) {
        this.socicalMediaAccount = socicalMediaAccount;
        return this;
    }

    public void setSocicalMediaAccount(String socicalMediaAccount) {
        this.socicalMediaAccount = socicalMediaAccount;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SocialMedia)) {
            return false;
        }
        return id != null && id.equals(((SocialMedia) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SocialMedia{" +
            "id=" + getId() +
            ", personUserId='" + getPersonUserId() + "'" +
            ", socialMediaURL='" + getSocialMediaURL() + "'" +
            ", socialMediaLink='" + getSocialMediaLink() + "'" +
            ", socicalMediaAccount='" + getSocicalMediaAccount() + "'" +
            "}";
    }
}

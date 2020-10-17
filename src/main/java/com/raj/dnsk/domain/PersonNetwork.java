package com.raj.dnsk.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A PersonNetwork.
 */
@Entity
@Table(name = "person_network")
public class PersonNetwork implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_user_id")
    private String fromUserId;

    @Column(name = "to_user_id")
    private String toUserId;

    @Column(name = "relation_type")
    private String relationType;

    @Column(name = "connected_since")
    private Instant connectedSince;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public PersonNetwork fromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
        return this;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public PersonNetwork toUserId(String toUserId) {
        this.toUserId = toUserId;
        return this;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getRelationType() {
        return relationType;
    }

    public PersonNetwork relationType(String relationType) {
        this.relationType = relationType;
        return this;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public Instant getConnectedSince() {
        return connectedSince;
    }

    public PersonNetwork connectedSince(Instant connectedSince) {
        this.connectedSince = connectedSince;
        return this;
    }

    public void setConnectedSince(Instant connectedSince) {
        this.connectedSince = connectedSince;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonNetwork)) {
            return false;
        }
        return id != null && id.equals(((PersonNetwork) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PersonNetwork{" +
            "id=" + getId() +
            ", fromUserId='" + getFromUserId() + "'" +
            ", toUserId='" + getToUserId() + "'" +
            ", relationType='" + getRelationType() + "'" +
            ", connectedSince='" + getConnectedSince() + "'" +
            "}";
    }
}

package com.raj.dnsk.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Person.
 */
@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "source")
    private String source;

    @Column(name = "native_location")
    private String nativeLocation;

    @Column(name = "current_location")
    private String currentLocation;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "note")
    private String note;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupName() {
        return groupName;
    }

    public Person groupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSource() {
        return source;
    }

    public Person source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNativeLocation() {
        return nativeLocation;
    }

    public Person nativeLocation(String nativeLocation) {
        this.nativeLocation = nativeLocation;
        return this;
    }

    public void setNativeLocation(String nativeLocation) {
        this.nativeLocation = nativeLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public Person currentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
        return this;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Person createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getNote() {
        return note;
    }

    public Person note(String note) {
        this.note = note;
        return this;
    }

    public void setNote(String note) {
        this.note = note;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        return id != null && id.equals(((Person) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Person{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", groupName='" + getGroupName() + "'" +
            ", source='" + getSource() + "'" +
            ", nativeLocation='" + getNativeLocation() + "'" +
            ", currentLocation='" + getCurrentLocation() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", note='" + getNote() + "'" +
            "}";
    }
}

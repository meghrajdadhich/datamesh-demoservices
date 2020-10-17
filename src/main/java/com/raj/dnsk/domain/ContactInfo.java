package com.raj.dnsk.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A ContactInfo.
 */
@Entity
@Table(name = "contact_info")
public class ContactInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email_1")
    private String email1;

    @Column(name = "phone_number_1")
    private String phoneNumber1;

    @Column(name = "email_2")
    private String email2;

    @Column(name = "phone_number_2")
    private String phoneNumber2;

    @Column(name = "email_3")
    private String email3;

    @Column(name = "phone_number_3")
    private String phoneNumber3;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail1() {
        return email1;
    }

    public ContactInfo email1(String email1) {
        this.email1 = email1;
        return this;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public ContactInfo phoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
        return this;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactInfo email2(String email2) {
        this.email2 = email2;
        return this;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public ContactInfo phoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
        return this;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactInfo email3(String email3) {
        this.email3 = email3;
        return this;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getPhoneNumber3() {
        return phoneNumber3;
    }

    public ContactInfo phoneNumber3(String phoneNumber3) {
        this.phoneNumber3 = phoneNumber3;
        return this;
    }

    public void setPhoneNumber3(String phoneNumber3) {
        this.phoneNumber3 = phoneNumber3;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ContactInfo)) {
            return false;
        }
        return id != null && id.equals(((ContactInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ContactInfo{" +
            "id=" + getId() +
            ", email1='" + getEmail1() + "'" +
            ", phoneNumber1='" + getPhoneNumber1() + "'" +
            ", email2='" + getEmail2() + "'" +
            ", phoneNumber2='" + getPhoneNumber2() + "'" +
            ", email3='" + getEmail3() + "'" +
            ", phoneNumber3='" + getPhoneNumber3() + "'" +
            "}";
    }
}

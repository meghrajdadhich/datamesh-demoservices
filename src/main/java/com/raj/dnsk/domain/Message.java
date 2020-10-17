package com.raj.dnsk.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Message.
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "msg_txt")
    private String msgTxt;

    @Column(name = "msg_type")
    private String msgType;

    @Column(name = "media_m_sg_id")
    private String mediaMSgId;

    @Column(name = "msg_date_time")
    private Instant msgDateTime;

    @Column(name = "msg_from_user_id")
    private String msgFromUserId;

    @Column(name = "msg_to_user_id")
    private String msgToUserId;

    @Column(name = "msg_source")
    private String msgSource;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgTxt() {
        return msgTxt;
    }

    public Message msgTxt(String msgTxt) {
        this.msgTxt = msgTxt;
        return this;
    }

    public void setMsgTxt(String msgTxt) {
        this.msgTxt = msgTxt;
    }

    public String getMsgType() {
        return msgType;
    }

    public Message msgType(String msgType) {
        this.msgType = msgType;
        return this;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMediaMSgId() {
        return mediaMSgId;
    }

    public Message mediaMSgId(String mediaMSgId) {
        this.mediaMSgId = mediaMSgId;
        return this;
    }

    public void setMediaMSgId(String mediaMSgId) {
        this.mediaMSgId = mediaMSgId;
    }

    public Instant getMsgDateTime() {
        return msgDateTime;
    }

    public Message msgDateTime(Instant msgDateTime) {
        this.msgDateTime = msgDateTime;
        return this;
    }

    public void setMsgDateTime(Instant msgDateTime) {
        this.msgDateTime = msgDateTime;
    }

    public String getMsgFromUserId() {
        return msgFromUserId;
    }

    public Message msgFromUserId(String msgFromUserId) {
        this.msgFromUserId = msgFromUserId;
        return this;
    }

    public void setMsgFromUserId(String msgFromUserId) {
        this.msgFromUserId = msgFromUserId;
    }

    public String getMsgToUserId() {
        return msgToUserId;
    }

    public Message msgToUserId(String msgToUserId) {
        this.msgToUserId = msgToUserId;
        return this;
    }

    public void setMsgToUserId(String msgToUserId) {
        this.msgToUserId = msgToUserId;
    }

    public String getMsgSource() {
        return msgSource;
    }

    public Message msgSource(String msgSource) {
        this.msgSource = msgSource;
        return this;
    }

    public void setMsgSource(String msgSource) {
        this.msgSource = msgSource;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Message)) {
            return false;
        }
        return id != null && id.equals(((Message) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Message{" +
            "id=" + getId() +
            ", msgTxt='" + getMsgTxt() + "'" +
            ", msgType='" + getMsgType() + "'" +
            ", mediaMSgId='" + getMediaMSgId() + "'" +
            ", msgDateTime='" + getMsgDateTime() + "'" +
            ", msgFromUserId='" + getMsgFromUserId() + "'" +
            ", msgToUserId='" + getMsgToUserId() + "'" +
            ", msgSource='" + getMsgSource() + "'" +
            "}";
    }
}

package com.raj.dnsk.repository;

import com.raj.dnsk.domain.Message;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Message entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}

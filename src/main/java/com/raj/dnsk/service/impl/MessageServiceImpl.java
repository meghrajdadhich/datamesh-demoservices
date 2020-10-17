package com.raj.dnsk.service.impl;

import com.raj.dnsk.service.MessageService;
import com.raj.dnsk.domain.Message;
import com.raj.dnsk.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Message}.
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message save(Message message) {
        log.debug("Request to save Message : {}", message);
        return messageRepository.save(message);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Message> findAll(Pageable pageable) {
        log.debug("Request to get all Messages");
        return messageRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Message> findOne(Long id) {
        log.debug("Request to get Message : {}", id);
        return messageRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Message : {}", id);
        messageRepository.deleteById(id);
    }
}

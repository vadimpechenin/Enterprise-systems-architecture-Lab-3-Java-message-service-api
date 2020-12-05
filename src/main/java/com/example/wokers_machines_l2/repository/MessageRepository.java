package com.example.wokers_machines_l2.repository;

import com.example.wokers_machines_l2.entitymessages.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}

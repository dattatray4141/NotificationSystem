package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}

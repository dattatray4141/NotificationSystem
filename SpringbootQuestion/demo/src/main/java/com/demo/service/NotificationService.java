package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Notification;
import com.demo.repository.NotificationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NotificationService {

	@Autowired
	NotificationRepository repository;

	public List<Notification> getAllNotifications() {
		return repository.findAll();
	}

	public Optional<Notification> getNotificationById(Long id) {
		return repository.findById(id);
	}

	public Notification createNotification(String message, String type, String response) {
		Notification notification = new Notification();
		notification.setMessage(message);
		notification.setType(type);
		notification.setResponse(response);
		return repository.save(notification);
	}

	public void deleteNotification(Long id) {
		repository.deleteById(id);
	}

	public Notification updateNotification(Long id, String message, String type, String response) {
		Optional<Notification> existingNotification = repository.findById(id);
		if (existingNotification.isPresent()) {
			Notification notification = existingNotification.get();
			notification.setMessage(message);
			notification.setResponse(response);
			return repository.save(notification);
		} else {
			throw new EntityNotFoundException("Notification not found with id " + id);
		}
	}
}

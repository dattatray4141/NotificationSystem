package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.demo.model.Notification;
import com.demo.service.NotificationService;

@RestController
@RequestMapping("api/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationService service;
	
	@GetMapping("")
	public ResponseEntity<List<Notification>> getAllNotifications(){
		List<Notification>  notifications=service.getAllNotifications();
		return ResponseEntity.ok(notifications);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Notification> getNotificationById(@PathVariable Long id){
		Optional<Notification> notification=service.getNotificationById(id);
		if(notification.isPresent()) {
			return ResponseEntity.ok(notification.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Notification> createNotification(@RequestBody Notification request){
           Notification create=service.createNotification(request.getMessage(), request.getType(), request.getResponse());
           return ResponseEntity.ok(create);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Notification> updateNotification(@PathVariable Long id,@RequestBody NotificationRequest request,@RequestBody Notification note){
		Optional<Notification> existingNotification=service.getNotificationById(id);
		if(existingNotification.isPresent()) {
			Notification notification=existingNotification.get();
			System.out.println(notification.getMessage()+" "+notification.getResponse()+" "+existingNotification.get().getResponse());
			notification.setMessage(request.getMessage());
			notification.setType(request.getType());
			Notification notification2=service.updateNotification(id, notification.getMessage(), notification.getType(), notification.getResponse());
			return ResponseEntity.ok(notification2);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Notification> deleteNotification(@PathVariable Long id){
		Optional<Notification> existingNotification=service.getNotificationById(id);
		if(existingNotification.isPresent()) {
			 service.deleteNotification(id);
			 return ResponseEntity.noContent().build();
		}else {
		 return ResponseEntity.notFound().build();
		}
	}

}

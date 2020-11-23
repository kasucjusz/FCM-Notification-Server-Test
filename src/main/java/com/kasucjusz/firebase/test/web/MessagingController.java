package com.kasucjusz.firebase.test.web;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.kasucjusz.firebase.test.service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/api/message")
public class MessagingController {

    @Autowired
    MessagingService service;

@PostMapping
    public ResponseEntity<?> sendMessageToDeviceWithToken(@RequestParam("token") String token) throws IOException, FirebaseMessagingException {

    service.sendMessageToDeviceWithToken(token);

    return ResponseEntity.ok("Message sent successfully");
}


}

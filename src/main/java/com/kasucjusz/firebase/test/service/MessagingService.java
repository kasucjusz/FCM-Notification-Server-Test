package com.kasucjusz.firebase.test.service;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.kasucjusz.firebase.test.component.FirebaseMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class MessagingService {

    @Autowired
    private FirebaseMessageService firebaseMessageService;

    public void sendMessageToDeviceWithToken(String token) throws IOException, FirebaseMessagingException {
        firebaseMessageService.sendToToken(token);

    }



}

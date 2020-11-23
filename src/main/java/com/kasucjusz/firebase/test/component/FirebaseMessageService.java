package com.kasucjusz.firebase.test.component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Component
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FirebaseMessageService {

    private static final String AUTH_FILE_PATH = "fcm-receiving-data-firebase-adminsdk-24iwj-c1a1894d0c.json";


    @PostConstruct
    public void initializeFirebase() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream(getClass().getClassLoader().getResource(AUTH_FILE_PATH).getPath());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://fcm-receiving-data.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }


    public void sendToToken(String token) throws FirebaseMessagingException {
        Message message = Message.builder()
                .putData("score", "tetowyWynik")
                .putData("time", "2:45")
                .setToken(token)
                .build();


        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Successfully sent message: " + response);
    }
}

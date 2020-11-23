package com.kasucjusz.firebase.test.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FirebasePayload {
    private String to;

    @JsonProperty("time_to_live")
    private int timeToLive;

    @JsonProperty("content_available")
    private boolean contentAvailable;

    private String priority;
}

package utils;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;

public class GCMFactory {
    private static final String API_KEY = "AIzaSyCIX8GYyIf-CFTdI9r8zKd5NKGABCuyWOE";

    public Sender createSender() {
        return new Sender(API_KEY);
    }

    public Message createMessage(String contentId, String content, int timeToLive) {
        return new Message.Builder()
                .timeToLive(timeToLive)
                .addData(contentId, content)
                .build();
    }
}

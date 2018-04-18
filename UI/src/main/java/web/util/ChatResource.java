package web.util;

import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PathParam;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

@PushEndpoint("/chat/{id}")
public class ChatResource {

    @PathParam("id")
    private String username;

    @OnMessage(encoders = {JSONEncoder.class})
    public String onMessage(String message) {
        return message;
    }

}

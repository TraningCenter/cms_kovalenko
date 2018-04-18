package service;

import controller.MessageController;
import dto.MessageDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class MessageService {

    @EJB
    private MessageController messageController;

    public void addMessage(MessageDto messageDto){
        try {
            messageController.addMessage(messageDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

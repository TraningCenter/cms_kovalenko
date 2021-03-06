package com.netcracker.unc.dto.mappers;

import com.netcracker.unc.dto.MessageDto;
import com.netcracker.unc.dto.PostDto;
import com.netcracker.unc.dto.UserDto;
import com.netcracker.unc.model.Message;
import com.netcracker.unc.model.Post;
import com.netcracker.unc.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;

public class MessageMapperTest {

    private MessageMapper mapper = Mappers.getMapper(MessageMapper.class);

    @Test
    public void messageToMessageDto() {
        Message message = new Message(2, 1, "text", new Date());
        MessageDto messageDto = mapper.messageToMessageDto(message);
        Assert.assertEquals(message.getMessageId(), messageDto.getMessageId());
        Assert.assertEquals(message.getPostId(), messageDto.getPostId());
        Assert.assertEquals(message.getUserId(), messageDto.getUserId());
        Assert.assertNull(messageDto.getUserName());
        Assert.assertEquals(message.getText(), messageDto.getText());
        Assert.assertEquals(message.getDateTime(), messageDto.getDateTime());
    }

    @Test
    public void messageDtoToMessage() {
        MessageDto messageDto =  new MessageDto(1, 2, 3, "text", new Date());
        Message message = mapper.messageDtoToMessage(messageDto);
        Assert.assertEquals(message.getMessageId(), messageDto.getMessageId());
        Assert.assertEquals(message.getPostId(), messageDto.getPostId());
        Assert.assertEquals(message.getUserId(), messageDto.getUserId());
        Assert.assertEquals(message.getText(), messageDto.getText());
        Assert.assertEquals(message.getDateTime(), messageDto.getDateTime());
    }
}

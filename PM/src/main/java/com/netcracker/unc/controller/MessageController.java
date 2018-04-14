package com.netcracker.unc.controller;

import com.netcracker.unc.controller.exception.BadRequestException;
import com.netcracker.unc.controller.exception.DataNotFoundException;
import com.netcracker.unc.controller.exception.InternalServerErrorException;
import com.netcracker.unc.dto.MessageDto;
import com.netcracker.unc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/{messageId}", method = RequestMethod.GET)
    @ResponseBody
    public MessageDto getMessageById(@PathVariable("messageId") Integer id) {
        if (id == null || id < 0) throw new BadRequestException();
        MessageDto messageDto;
        try {
            messageDto = messageService.getMessageById(id);
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
        return messageDto;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<MessageDto> getAllMessages() {
        List<MessageDto> messages = messageService.getAll();
        if (messages == null || messages.isEmpty())
            throw new DataNotFoundException();
        return messages;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createMessage(@RequestBody MessageDto messageDto) {
        if (messageDto == null) throw new BadRequestException();
        messageService.addMessage(messageDto);
    }

    @RequestMapping(value = "/{messageId}", method = RequestMethod.PUT)
    public void updatePost(@PathVariable("messageId") Integer id, @RequestBody MessageDto messageDto) {
        if (id == null || id < 0) throw new BadRequestException();
        if (messageDto == null) throw new BadRequestException();
        messageService.updateMessage(messageDto);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("postId") Integer id) {
        if (id == null || id < 0) throw new BadRequestException();
        messageService.deleteMessage(id);
    }
}

package com.netcracker.unc.service;

import com.netcracker.unc.dao.MessageDao;
import com.netcracker.unc.dto.MessageDto;
import com.netcracker.unc.dto.mappers.MessageMapper;
import com.netcracker.unc.model.Message;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageDao dao;
    private MessageMapper mapper = Mappers.getMapper(MessageMapper.class);

    @Transactional
    public List<MessageDto> getAll() {
        List<Message> messages = dao.getAllMessages();
        return messages.stream()
                .map(elem -> mapper.messageToMessageDto(elem))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<MessageDto> getAllMessagesByPostId(Integer postId) {
        List<Message> messages = dao.getAllMessagesByPostId(postId);
        return messages.stream()
                .map(elem -> mapper.messageToMessageDto(elem))
                .collect(Collectors.toList());
    }

    @Transactional
    public MessageDto getMessageById(Integer id) {
        Message message = dao.getMessageById(id);
        return mapper.messageToMessageDto(message);
    }

    @Transactional
    public void addMessage(MessageDto messageDto) {
        Message message = mapper.messageDtoToMessage(messageDto);
        dao.addMessage(message);
    }

    @Transactional
    public void updateMessage(MessageDto messageDto) {
        Message message = mapper.messageDtoToMessage(messageDto);
        dao.updateMessage(message);
    }

    @Transactional
    public void deleteMessage(Integer id) {
        dao.deleteMessage(id);
    }
}

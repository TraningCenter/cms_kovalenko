package com.netcracker.unc.dto.mappers;

import com.netcracker.unc.dto.MessageDto;
import com.netcracker.unc.dto.UserDto;
import com.netcracker.unc.model.Message;
import com.netcracker.unc.service.UserService;
import com.netcracker.unc.util.ApplicationContextProvider;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.context.ApplicationContext;

@Mapper
public abstract class MessageMapper {

    public abstract MessageDto messageToMessageDto(Message message);

    public abstract Message messageDtoToMessage(MessageDto messageDto);

    @AfterMapping
    void setUserName(Message message, @MappingTarget MessageDto messageDto) {
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        UserService userService = (UserService) context.getBean("userService");
        UserDto userDto = userService.getUserById(message.getUserId());
        messageDto.setUserName(userDto.getFirstName() + " " + userDto.getLastName());
    }
}

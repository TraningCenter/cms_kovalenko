package com.netcracker.unc.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason="Client request error")
public class InternalServerErrorException extends RuntimeException{
}

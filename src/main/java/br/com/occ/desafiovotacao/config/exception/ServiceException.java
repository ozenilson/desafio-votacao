package br.com.occ.desafiovotacao.config.exception;

import org.springframework.http.HttpStatus;


public class ServiceException extends CustomException {

    public ServiceException(String message, HttpStatus status) {
        super(message, status);
    }
}

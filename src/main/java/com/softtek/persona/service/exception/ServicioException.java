package com.softtek.persona.service.exception;

import org.apache.log4j.Logger;

public class ServicioException extends Exception{
    final static Logger log = Logger.getLogger(ServicioException.class);

    private static final long serialVersionUID = 1L;

    public ServicioException(){

    }

    public ServicioException(String message) {
        super(message);
    }

    public ServicioException(Throwable cause){
        super(cause);
        log.error("ServiceException: {} ",cause);
    }

    public ServicioException(String message, Throwable cause){
        super(message, cause);
    }

}

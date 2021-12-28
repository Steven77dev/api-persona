package com.softtek.persona.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class RespuestaHttp implements Serializable {

    private static final long serialVersionID=1L;
    private Object data;
    private String mensaje;
    private boolean valido;
}

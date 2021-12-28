package com.softtek.persona.service;

import com.softtek.persona.model.Persona;
import com.softtek.persona.service.exception.ServicioException;

public interface PersonaService {
    Persona insertar(Persona persona) throws ServicioException;
    Persona actualizar(Persona persona)  throws ServicioException;
    boolean eliminar(long id)  throws ServicioException;
}

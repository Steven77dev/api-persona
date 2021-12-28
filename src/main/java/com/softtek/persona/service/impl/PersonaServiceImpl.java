package com.softtek.persona.service.impl;

import com.softtek.persona.model.Persona;
import com.softtek.persona.repository.PersonaRepository;
import com.softtek.persona.service.PersonaService;
import com.softtek.persona.service.exception.ResourceNotFoundException;
import com.softtek.persona.service.exception.ServicioException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    final static Logger log = Logger.getLogger(PersonaServiceImpl.class);

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona insertar(Persona persona) throws ServicioException {
        try {
            return personaRepository.save(persona);
        } catch (Exception ex) {
            log.error("Error al insertar {} "+ ex);
            throw new ServicioException(ex);
        }

    }

    @Override
    public Persona actualizar(Persona persona) throws ServicioException  {
        try {
            Persona personaEncontrada = personaRepository.findById(persona.getId()).orElseThrow(() -> new ResourceNotFoundException("No se encontró registro."));
            personaEncontrada.setApellido(persona.getApellido());
            personaEncontrada.setDni(persona.getDni());
            personaEncontrada.setNombre(persona.getNombre());
            personaEncontrada.setEmpleado(persona.isEmpleado());
            return personaRepository.save(personaEncontrada);
        } catch (Exception ex) {
            log.error("Error al actualizar {} "+ ex);
            throw new ServicioException(ex);
        }
    }

    @Override
    public boolean eliminar(long id) throws ServicioException  {
        try {
            Persona personaEncontrada = personaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró registro."));
             personaRepository.delete(personaEncontrada);
             return true;
        } catch (Exception ex) {
            log.error("Error al eliminar {} "+ ex);
            throw new ServicioException(ex);
        }
    }
}

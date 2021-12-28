package com.softtek.persona.controller;

import com.softtek.persona.model.Persona;
import com.softtek.persona.response.RespuestaHttp;
import com.softtek.persona.service.PersonaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/persona")
public class PersonaController {

    final static Logger log = Logger.getLogger(PersonaController.class);

    @Autowired
    private PersonaService personaService;

    //Alta persona
    @PostMapping("/insertar")
    public ResponseEntity<?> insertar(@RequestBody Persona persona){
        RespuestaHttp respuesta = new RespuestaHttp();
        try {
            Persona objPersona = personaService.insertar(persona);
            respuesta.setData(objPersona);
            respuesta.setValido(true);
            respuesta.setMensaje("Se insertó registro.");
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Persona persona){
        RespuestaHttp respuesta = new RespuestaHttp();
        try {
            Persona objPersona = personaService.actualizar(persona);
            respuesta.setData(objPersona);
            respuesta.setValido(true);
            respuesta.setMensaje("Se actualizó registro.");
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable(value = "id") Long id){
        RespuestaHttp respuesta = new RespuestaHttp();
        try {
            boolean eliminado = personaService.eliminar(id);
            respuesta.setMensaje("Se eliminó registro.");
            respuesta.setValido(eliminado);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

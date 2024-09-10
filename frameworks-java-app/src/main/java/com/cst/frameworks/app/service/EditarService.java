package com.cst.frameworks.app.service;

import com.cst.frameworks.app.model.Persona;

public interface EditarService {

    Persona obtenerPersona();
    void guardarPersona(Persona persona);

}

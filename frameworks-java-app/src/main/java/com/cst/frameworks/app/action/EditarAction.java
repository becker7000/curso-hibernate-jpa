package com.cst.frameworks.app.action;

import com.cst.frameworks.app.model.Estado;
import com.cst.frameworks.app.model.Persona;
import com.cst.frameworks.app.service.EditarService;
import com.cst.frameworks.app.service.EditarServiceEnMemoria;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EditarAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private EditarService editarService = new EditarServiceEnMemoria();
    private Persona persona;

    // Conjuntos de valores constantes:
    private String[] deportes = {"soccer","baloncesto","natacion"};
    private String[] generos = {"masculino","femenino","otro"};
    private List<Estado> estados;
    private String[] modelosDeCocheDisponibles = {"Nissan","Honda","Subaru","Toyota"};

    // Getters y setters:

    public Persona getPersona(){
        return persona;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
    }

    public List<String> getDeportes(){
        return Arrays.asList(deportes);
    }

    public List<String> getGeneros(){
        return Arrays.asList(generos);
    }

    public List<Estado> getEstados(){
        estados = new ArrayList<>();
        estados.add(new Estado("CDMX","Ciudad de México"));
        estados.add(new Estado("JAL","Jalisco"));
        estados.add(new Estado("PUE","Puebla"));
        estados.add(new Estado("MTY","Monterrey"));
        estados.add(new Estado("QRO","Queretaro"));
        estados.add(new Estado("YUC","Yucatán"));
        estados.add(new Estado("OAX","Oaxaca"));
        return estados;
    }

    public String[] getModelosDeCocheDisponibles(){
        return modelosDeCocheDisponibles;
    }

    public EditarService getEditarService(){
        return editarService;
    }

    public void setEditarService(EditarService editarService){
        this.editarService = editarService;
    }

    public String execute() throws Exception{
        editarService.guardarPersona(getPersona());
        return SUCCESS;
    }

    public String input() throws Exception{
        setPersona(editarService.obtenerPersona());
        return INPUT;
    }

}

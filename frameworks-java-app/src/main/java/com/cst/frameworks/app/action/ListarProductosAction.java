package com.cst.frameworks.app.action;

import com.cst.frameworks.app.entity.Producto;
import com.cst.frameworks.app.service.ProductoService;
import com.cst.frameworks.app.service.ProductoServiceImp;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ListarProductosAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    // Instancia de un servicio:
    private ProductoService productoService = new ProductoServiceImp();

    // Lista de productos:
    private List<Producto> productos;

    // Getters and setters:

    public List<Producto> getProductos(){
        return productos;
    }

    public void setProductos(List<Producto> productos){
        this.productos = productos;
    }

    @Override
    public String execute(){
        try{
            // Llamamos al servicio para obtener la lista:
            productos = productoService.listar();
            return SUCCESS;
        }catch (Exception exception){
            exception.printStackTrace();
            return ERROR;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.controller;

import daw.agrouja.model.Formulario;
import daw.agrouja.model.ContactoDao.FormulariosDAO;
import daw.agrouja.qualifiers.DAOJpa;
import daw.agrouja.qualifiers.DAOMap;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */

@Named("ctrlFormulario")
@ViewScoped
public class ContactoController implements Serializable {

    private final Logger logger = Logger.getLogger(ContactoController.class.getName());

    
    private boolean bar=false;
    private int contador = 1;
    
    @Inject @DAOJpa
    private FormulariosDAO formulariosDAO;
    
    private Formulario formulario;
    
    List<Formulario> formularios;
    
    public ContactoController(){   
    }
    
    @PostConstruct
    private void init (){
        formulario=new Formulario();
        formularios=formulariosDAO.buscaTodos();
    }
    
    public Formulario getFormulario(){
        return formulario;
    }
    
    public void setFormulario(Formulario formulario){
        this.formulario=formulario;
    }
    
    public List<Formulario> getFormularios(){
        logger.info("Buscando formularios");
        return formularios;
    }
    
    public String contForm(){
        return "Formulario"+contador++;
    }
    
    public String crea(){
        logger.info("Guardando formulario");
        formulariosDAO.crea(formulario);
        //formularios=formulariosDAO.buscaTodos();
        this.formulario=new Formulario();
        return "";
    }
    
    public void recupera(){
        logger.info("Recuperando formulario "+formulario.getEmail());
        formulario=formulariosDAO.buscaEmail(formulario.getEmail());

    }
    
    public void recupera(String email){
        logger.info("Recuperando formulario "+email);
        formulario = formulariosDAO.buscaEmail(email);
    }
    
    public int isContador(){
        return contador;
    }
    
    public void foo(){
        bar=!bar;
    }
    
    public boolean isBar(){
        return bar;
    }
    
    public void setBar(boolean bar){
        this.bar=bar;
    }       
}
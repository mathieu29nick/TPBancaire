/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.tpbancaire.jsf;

import com.mycompany.tpbancaire.entity.CompteBancaire;
import com.mycompany.tpbancaire.entity.OperationBancaire;
import com.mycompany.tpbancaire.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author rakot
 */
@Named(value = "operations")
@ViewScoped
public class Operations implements Serializable {
    
    @Inject
    private GestionnaireCompte bean;

    private Long idCompte;
    private CompteBancaire compte;
    private List<OperationBancaire> operations;

    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }
    
    public Long getIdCompte(){
        return idCompte;
    }
    
    public void setIdCompte(Long id){
        idCompte=id;
    }
    
    public void loadCompte() {
        compte = bean.findById(idCompte);
    }
    
    public CompteBancaire getCompteBancaire() {
        return (CompteBancaire)bean.findById(idCompte);
    }
    
    public List<OperationBancaire> getOperations() { 
      System.out.println("ISA"+compte.getOperations());
      operations=compte.getOperations();
      return operations;
    }
    
    public String formatDate(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }
    
}

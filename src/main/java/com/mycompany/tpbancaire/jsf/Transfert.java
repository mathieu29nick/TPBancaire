/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.tpbancaire.jsf;

import com.mycompany.tpbancaire.entity.CompteBancaire;
import com.mycompany.tpbancaire.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

/**
 *
 * @author rakot
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {
    
    @Inject
    private GestionnaireCompte bean;
    private Long idSource;
    private Long idDestination;
    private int montant;

    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    
    
    public Transfert() {
    }
    
    public String valider() {
        CompteBancaire source=bean.findById(idSource);
        CompteBancaire destinataire=bean.findById(idDestination);
        bean.transferer(source, destinataire, montant);
        return "listeComptes";
    }
    
}
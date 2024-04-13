/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.tpbancaire.jsf;

import com.mycompany.tpbancaire.entity.CompteBancaire;
import com.mycompany.tpbancaire.jsf.util.Util;
import com.mycompany.tpbancaire.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

/**
 *
 * @author rakot
 */
@Named(value = "modifier")
@ViewScoped
public class Modifier implements Serializable {

    /**
     * Creates a new instance of Modifier
     */
    public Modifier() {
    }
    
    private Long id;
    private String nom;
    private CompteBancaire compte;

    @Inject
    private GestionnaireCompte bean;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public void loadCompte() {
        this.compte = bean.findById(id);
    }

    public CompteBancaire getCompteBancaire() {
        return this.compte;
    }
    
    public String valdier(){
        bean.modifierNom(compte,nom);
        Util.addFlashInfoMessage("Nom (" + compte.getNom() + ") changé en ("+nom+")");
        return "listeComptes?faces-redirect=true";
    }
    
}

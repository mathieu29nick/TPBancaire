/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.tpbancaire.jsf;

import com.mycompany.tpbancaire.entity.CompteBancaire;
import com.mycompany.tpbancaire.jsf.util.Util;
import com.mycompany.tpbancaire.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.PositiveOrZero;

/**
 *
 * @author rakot
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {
    
    @Inject
    private GestionnaireCompte bean;
    private String nom;
    @PositiveOrZero
    private int solde;
    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
    
    public String ajouter(){
        boolean erreur = false;
        if(this.nom.equals("")){
            Util.messageErreur("Entrer un nom valdie");
            erreur=true;
        }
        String link="listeComptes?faces-redirect=true";
        if(erreur){
            return null;
        }
        CompteBancaire compte=new CompteBancaire(this.nom,this.solde);
        bean.creerCompte(compte);
        Util.addFlashInfoMessage("Ajout du compte : "+this.nom+" terminé!");
        return link;
    }
    
}

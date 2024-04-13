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
import java.util.List;

/**
 *
 * @author rakot
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @Inject
    private GestionnaireCompte bean;
    private List<CompteBancaire> compteList;

    public ListeComptes() {
    }

    public List<CompteBancaire> getAllComptes() {
        if (compteList == null) {
            compteList = bean.getAllComptes();
        }
        return compteList;
    }

    public String supprimerCompte(CompteBancaire compteBancaire) {
        bean.supprimerCompte(compteBancaire);
        Util.addFlashInfoMessage("Compte de " + compteBancaire.getNom() + " supprimé");
        return "listeComptes?faces-redirect=true";
    }

}

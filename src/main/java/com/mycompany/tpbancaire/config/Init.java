/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpbancaire.config;

import com.mycompany.tpbancaire.entity.CompteBancaire;
import com.mycompany.tpbancaire.service.GestionnaireCompte;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import java.io.Serializable;

/**
 *
 * @author rakot
 */
@Named(value="init")
@ApplicationScoped
public class Init implements Serializable{
    
    @Inject
    private GestionnaireCompte bean;
    
    /**
     *
     */
    @PostConstruct
    @Transactional
    public void init(){
        CompteBancaire[] list = new CompteBancaire[4];
        list[0] = new CompteBancaire("John Lennon",150000);
        list[1] = new CompteBancaire("Paul McCartney",950000);
        list[2] = new CompteBancaire("Ringo Starr",20000);
        list[3] = new CompteBancaire("Georges Harrisson",100000);
        if(bean.nbComptes()<=0){
            for (CompteBancaire compte : list) {
                bean.creerCompte(compte);
            }
        }
    }
    
    public void onStartup(@Observes @Initialized(ApplicationScoped.class) Object init) {
    }
    
}

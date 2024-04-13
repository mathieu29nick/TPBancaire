/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpbancaire.service;

import com.mycompany.tpbancaire.entity.CompteBancaire;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author rakot
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3304,
        user = "root",
        password = "Kalisi61!",
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true",
            "driverClass=com.mysql.cj.jdbc.Driver"
        }
)

@Named(value = "gestionnairecompte")
@ApplicationScoped
public class GestionnaireCompte implements Serializable {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;

    public List<CompteBancaire> getAllComptes() {
        TypedQuery<CompteBancaire> query = em.createNamedQuery("CompteBancaire.findAll", CompteBancaire.class);
        return query.getResultList();
    }

    @Transactional
    public void creerCompte(CompteBancaire compte) {
        em.persist(compte);
    }

    public long nbComptes() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM CompteBancaire c", Long.class);
        return query.getSingleResult();
    }

    @Transactional
    public void transferer(CompteBancaire source, CompteBancaire destination,
            int montant) {
        source.retirer(montant);
        destination.deposer(montant);
        update(source);
        update(destination);
    }

    @Transactional
    public CompteBancaire update(CompteBancaire compteBancaire) {
        return em.merge(compteBancaire);
    }
    
    public CompteBancaire findById(Long idCompte) {
        return em.find(CompteBancaire.class, idCompte);
    }
}

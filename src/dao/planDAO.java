/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.cell;
import entidad.plan;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JULIO
 */
public class planDAO {
    
     public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MB_version_8.2PU");
    
    public void crear1(plan object){
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{            
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}

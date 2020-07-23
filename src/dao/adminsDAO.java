/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Admin;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author JULIO
 */
public class adminsDAO {
    private static EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("MB_version_8.2PU");

    public adminsDAO() {
    }

    

    public void crear (Admin objeto)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
     }
    
     public boolean eliminar (Admin objeto)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            em.remove(objeto);
            em.getTransaction().commit();
            ret=true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }
    }
     
    public Admin leer (Admin par)
    {
        EntityManager em = emf.createEntityManager();
        Admin admin = null;
        Query q = em.createQuery("SELECT u FROM Admin u " + 
                                 "WHERE u.nombre LIKE :nombre"+
                                 " AND u.contraseña LIKE :password")
                                 .setParameter("nombre", par.getNombre())
                                 .setParameter("password", par.getContraseña());
        
        
        
        
        try {
            admin = (Admin) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            admin = (Admin) q.getResultList().get(0);
        } catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            em.close();
            return admin;
        }
    }
    
    
    public boolean actualizar (Admin objeto , Admin nuevoObjeto)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            objeto = leer(objeto);
            objeto.setNombre(nuevoObjeto.getNombre());
            objeto.setContraseña(nuevoObjeto.getContraseña());
            em.merge(objeto);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }
     }
     



}

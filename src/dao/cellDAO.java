/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.cell;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
public class cellDAO {
    
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MB_version_8.2PU");
    
    public void crear(cell object){
        
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
    
    public void eliminar(cell object){
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            em.remove(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
        
    public cell leer(){
        
        EntityManager em = emf.createEntityManager();
        cell cell = null;
        cell par = new cell();
        Query q = em.createQuery("SELECT c FROM cell c " +
                                 "WHERE c.company LIKE :company" +
                                 " AND c.processor LIKE :processor" +
                                 " AND c.ram LIKE :ram" +
                                 " AND c.rom LIKE :rom" +
                                 " AND c.camera LIKE :camera" +
                                 " AND c.batery LIKE :batery" +
                                 " AND c.cost LIKE :cost" +
                                 " AND c.plan LIKE :plan")
                                 .setParameter("company", par.getCompany())
                                 .setParameter("processor", par.getProcessor())
                                 .setParameter("ram", par.getRam())
                                 .setParameter("rom", par.getRom())
                                 .setParameter("camera", par.getCamera())
                                 .setParameter("batery", par.getBatery())
                                 .setParameter("cost", par.getCost())
                                 .setParameter("plan", par.isPlan());
        try{
            cell = (cell) q.getSingleResult();
        } catch (Exception e) {
            cell = (cell) q.getResultList().get(0);
        } finally {
            em.close();
            return cell;
        }
    }
    public cell leer(cell par){
        
        EntityManager em = emf.createEntityManager();
        cell cell = null;
        //cell par = new cell();
        Query q = em.createQuery("SELECT c FROM cell c " +
                                 "WHERE c.company LIKE :company" +
                                 " AND c.processor LIKE :processor" +
                                 " AND c.ram LIKE :ram" +
                                 " AND c.rom LIKE :rom" +
                                 " AND c.camera LIKE :camera" +
                                 " AND c.batery LIKE :batery" +
                                 " AND c.cost LIKE :cost" +
                                 " AND c.plan LIKE :plan")
                                 .setParameter("company", par.getCompany())
                                 .setParameter("processor", par.getProcessor())
                                 .setParameter("ram", par.getRam())
                                 .setParameter("rom", par.getRom())
                                 .setParameter("camera", par.getCamera())
                                 .setParameter("batery", par.getBatery())
                                 .setParameter("cost", par.getCost())
                                 .setParameter("plan", par.isPlan());
        try{
            cell = (cell) q.getSingleResult();
        } catch (Exception e) {
            cell = (cell) q.getResultList().get(0);
        } finally {
            em.close();
            return cell;
        }
    }
    public static List paralaJlist ()
    {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select UPPER(e.company) from cell e ");
        List<String> listcompany=query.getResultList();
     
        return  listcompany;
    }
    
    
    public static ArrayList obtenerDatos() {
        EntityManager em = emf.createEntityManager();
        //ArrayList<String> datos = new ArrayList<>();
        //compañia
        Query query = em.createQuery("Select UPPER(e.company) from cell e ");
        List<String> listcompany=query.getResultList();
        //prosesador
        query = em.createQuery("Select UPPER(e.processor) from cell e ");
        List<String> listapross = query.getResultList();
        //ram
        query = em.createQuery("Select (e.ram) from cell e ");
        List<Double> listaram = query.getResultList();
        //rom
        query = em.createQuery("Select (e.rom) from cell e ");
        List<Double> listarom = query.getResultList();
        //camara
        query = em.createQuery("Select (e.camera) from cell e ");
        List<Double> listacamera = query.getResultList();
        //bateria
        query = em.createQuery("Select (e.batery) from cell e ");
        List<Double> listabateria = query.getResultList();
        //costo
        query = em.createQuery("Select (e.cost) from cell e ");
        List<Double> listacosto = query.getResultList();
        //plan
        query = em.createQuery("Select (e.plan) from cell e ");
        List<Boolean> listplan = query.getResultList();
        //pasar los datos a una ista de celulares
        ArrayList<cell> datos = new ArrayList<>();
        for (int i = 0; i < listapross.size(); i++) {
            cell aux = new cell(listcompany.get(i),listapross.get(i),listaram.get(i),listarom.get(i),
                               listacamera.get(i),listabateria.get(i),listacosto.get(i),listplan.get(i));
            datos.add(aux);
            System.out.println(datos.get(i).toString());
        }
        
        
        
       return datos;
    }
    public boolean actualizar(cell object, cell nuevoObjeto){
  
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = leer(object);
            object.setCompany(nuevoObjeto.getCompany());
            object.setProcessor(nuevoObjeto.getProcessor());
            em.merge(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();            
        } finally {
            em.close();
            return ret;
        }
    }
    
}

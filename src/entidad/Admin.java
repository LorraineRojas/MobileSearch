/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author Diego
 */

@Entity
@Table(name="administradores")
public class Admin implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
            
            
    String nombre;
    String contraseña;
    public Admin() {}
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String value) {
        this.nombre = value;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String value) {
        this.contraseña = value;
    }
    
    /*
    public Admin(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
     */
   
    
    
    /*
    public void inicializar ()
    {
        
        ArrayList<Admin> admins = new ArrayList();
        
        Admin a = new Admin("diego", "1234");
        Admin b = new Admin("julio", "5678");
        Admin c = new Admin("brian", "9012");
        Admin d = new Admin("lorraine", "3456");
        Admin e = new Admin("javier", "7890");

        admins.add(a);
        admins.add(b);
        admins.add(c);
        admins.add(d);
        admins.add(e);
        
    }
    */
}

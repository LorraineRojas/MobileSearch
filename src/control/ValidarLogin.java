/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidad.Admin;
import entidad.SistemaCatalogo;
import java.util.ArrayList;
import frontera.Pantalla_principal;
import javax.swing.JOptionPane;
import frontera.IncludePanel;
import frontera.LoginPanel;


/**
 *
 * @author usuario
 */
public class ValidarLogin {
    
    private SistemaCatalogo sistemacatalogo = Pantalla_principal.sistemacatalogo;

    //ArrayList<Admin> admin = new ArrayList<Admin>();
    
    public ValidarLogin(){
        
    }
    
    public SistemaCatalogo getSistemaCatalogo(){
        return sistemacatalogo;
    }
    
    public void setSistemaCatalogo( SistemaCatalogo val){
        this.sistemacatalogo = val;
    }
    
    public String passLogin(Admin admin){
        
        for(Admin a: sistemacatalogo.getAdmins()){
            if(a.getNombre().equals(admin.getNombre())&& a.getContraseña().equals(admin.getContraseña())){
                //return true;
                JOptionPane.showMessageDialog(null, "Bienvenido\n"
                    + "Has ingresado satisfactoriamente al sistema",   "Mensaje de bienvenida",
                    JOptionPane.INFORMATION_MESSAGE);
                return ("bienvenido");
                
            }
        }
        //return false;
        JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
               + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
               JOptionPane.ERROR_MESSAGE);
        return ("denegado");
    }
    
    public boolean verificarLongitudNombre(String nombre){
        return (nombre.length()>1 && nombre.length()<=8);
        
    }
    
    public boolean verificarLongitudPassword(String password){
        return (password.length()>=3 && password.length()<6);
    }
    
    public String verificarLogin(Admin a){
        if(!verificarLongitudNombre(a.getNombre())){
            return("Longitud nombre incorrecta");
        }
        if(!verificarLongitudPassword(a.getContraseña())){
            return("Datos incorrectos");
        }
        for(Admin ad: sistemacatalogo.getAdmins()){
            if(ad.getNombre().equals(ad.getNombre())&& ad.getContraseña().equals(ad.getContraseña())){
                return("Bienvenido");
            }
        }
        return ("Datos incorrectos");
    }
  }

      


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class SistemaCatalogo 
{    
    private ArrayList<Admin> admins;
    private ArrayList<cell> cells;
    
    public SistemaCatalogo (){
        
    }
    public ArrayList<Admin> getAdmins(){
        return admins;
    }
    
    public void setAdmins(ArrayList<Admin> val){
        this.admins = val;
    }
    
    public ArrayList<cell> getCells(){
        return cells;
    }
    
    public void setCells(ArrayList<cell> val){
        this.cells = val;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidad.cell;
import java.awt.Color;

/**
 *
 * @author JULIO
 */
public class comparar {
 
    public static String compararc(int key1, int key2) {
        /*aqui lo se realiza desde la lista q esta hecha, 
        pero se debe cuadrar para q se haga desde la tabla*/
        //________traigo los objetos 'cell' desde la lista
        cell celu1= new cell();
        cell celu2= new cell();
        String resultado = new String();
        /*
        ------------------------------
        tabla de comparacion
        1---->caracteristica del primer celular gana
        2---->caracteristica del segundo celular gana
        0----> empate
        */
        
        celu1=frontera.Pantalla_principal.listaCell.get(key1);
        celu2=frontera.Pantalla_principal.listaCell.get(key2);
        
        //ram
        if(celu1.getRam()<celu2.getRam())
        {
            resultado = "1";
        }else if(celu1.getRam()== celu2.getRam())
        {
            resultado ="0";
        } else
        {
            resultado ="2";
        }
        //rom        
        if(celu1.getRom()<celu2.getRom())
        {
            resultado = (resultado + "1");
        }else if(celu1.getRom()== celu2.getRom())
        {
            resultado = (resultado + "0");
        }else
        {
            resultado= (resultado + "2");
        }
        //camara
        if(celu1.getCamera()<celu2.getCamera())
        {
            resultado = (resultado + "1");
        }else if(celu1.getCamera()== celu2.getCamera())
        {
            resultado = (resultado + "0");
        }else
        {
           resultado= (resultado + "2");
        }
        //bateria
        if(celu1.getBatery()<celu2.getBatery())
        {
             resultado = (resultado + "1");
        }else if(celu1.getBatery()== celu2.getBatery())
        {
            resultado = (resultado + "0");
        }else
        {
            resultado= (resultado + "2");
        }
        //costo
        if(celu1.getCost()<celu2.getCost())
        {
             resultado = (resultado + "2");
        }else if(celu1.getCost()== celu2.getCost())
        {
            resultado = (resultado + "0");
        }else
        {
            resultado= (resultado + "1");
        }
        System.out.println(resultado);
    return resultado;
    }
       
}

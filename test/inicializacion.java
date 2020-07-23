
import dao.adminsDAO;
import entidad.Admin;
import static frontera.Pantalla_principal.sistemacatalogo;
import java.util.ArrayList;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JULIO
 */
public class inicializacion {
@Test
public void initData()
{
    adminsDAO dao = new adminsDAO();
    
     ArrayList<Admin> admins = new ArrayList<Admin>();
        
        Admin a = new Admin();
        Admin b = new Admin();
        Admin c = new Admin();
        Admin d = new Admin();
        Admin e = new Admin();
        
        a.setNombre("Diego");
        a.setContraseña("12345");
        b.setNombre("Brian");
        b.setContraseña("56789");
        c.setNombre("Lorraine");
        c.setContraseña("54321");
        d.setNombre("Julio");
        d.setContraseña("98765");
        e.setNombre("Javier");
        e.setContraseña("24680");
        
        admins.add(a);
        admins.add(b);
        admins.add(c);
        admins.add(d);
        admins.add(e);
        
       // sistemacatalogo.setAdmins(admins);
        
        for(Admin ad : admins){
            System.out.println(ad.getNombre());
            System.out.println(ad.getContraseña());
            System.out.println("----------------");
            dao.crear(ad);
        }

}
        

}

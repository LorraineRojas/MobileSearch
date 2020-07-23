/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import control.ValidarLogin;
import entidad.Admin;
import static frontera.Pantalla_principal.sistemacatalogo;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lolita
 */
public class ValidarLoginTest {
    
     private static ValidarLogin validarLogin = new ValidarLogin();
    
    private String DATOS_INCORRECTOS = "Datos incorrectos";
    private String USUARIO_AUTORIZADO = "Bienvenido";
    
    public ValidarLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
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
        
        sistemacatalogo.setAdmins(admins);
        
        for(Admin ad : sistemacatalogo.getAdmins()){
            System.out.println(ad.getNombre());
            System.out.println(ad.getContraseña());
            System.out.println("----------------");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testNombre(){
        Admin a = new Admin();
        a.setNombre("Profe");
        a.setContraseña("99092");
        assertEquals(validarLogin.verificarLogin(a), USUARIO_AUTORIZADO);
    }
   
    @Test
    public void testContraseña(){
        
       Admin a = new Admin();
        a.setNombre("Lorraine");
        a.setContraseña("54321");
        assertEquals(validarLogin.verificarLogin(a), USUARIO_AUTORIZADO);    
    }
    
    
        @Test
    public void testTodoCorrecto(){
        Admin a = new Admin();
        
        a.setNombre("Diego");
        a.setContraseña("12345");
        assertEquals(validarLogin.verificarLogin(a), USUARIO_AUTORIZADO);
        a.setNombre("Brian");
        a.setContraseña("56789");
        assertEquals(validarLogin.verificarLogin(a), USUARIO_AUTORIZADO);
        a.setNombre("Lorraine");
        a.setContraseña("54321");
        assertEquals(validarLogin.verificarLogin(a), USUARIO_AUTORIZADO);
        a.setNombre("Julio");
        a.setContraseña("98765");
        assertEquals(validarLogin.verificarLogin(a), USUARIO_AUTORIZADO);
        a.setNombre("Javier");
        a.setContraseña("24680");
        assertEquals(validarLogin.verificarLogin(a), USUARIO_AUTORIZADO);
    }
    
 
     @Test
    public void testContraseña1(){
        
       Admin a = new Admin();
        a.setNombre("Brian");
        a.setContraseña("5");
        assertEquals(validarLogin.verificarLogin(a), DATOS_INCORRECTOS);    
    }
    
    
}

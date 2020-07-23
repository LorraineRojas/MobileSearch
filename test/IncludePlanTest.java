/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import control.InsertPlan;
import entidad.plan;
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
public class IncludePlanTest {
    private static InsertPlan validarPlan = new InsertPlan();
    
    private String DATOS_INCOMPLETOS = "Faltan algunos datos";
    private String DATOS_COMPLETOS = "Plan guardado";
    public IncludePlanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    public void testDatosCompletos(){
        plan a = new plan();
        a.setCost(3000);
        a.setGB("10 GB");
        a.setMessages(100);
        a.setOperator("Claro");
        a.setSecondLine(50);  
        assertEquals(validarPlan.verificarFormulario(a), DATOS_COMPLETOS);
    }
    
     @Test
    public void testDatosIncompletos(){
        plan a = new plan();
        a.setCost(3000);
        //a.setGB(10);
        //a.setMessages(100);
        a.setOperator("Claro");
        a.setSecondLine(50);  
        assertEquals(validarPlan.verificarFormulario(a), DATOS_INCOMPLETOS);
    }
   
}

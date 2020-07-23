import control.InsertCell;
import entidad.cell;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class IncludeCellTest {
    private static InsertCell validarPlan;
    
    private String DATOS_INCOMPLETOS = "Faltan algunos datos";
    private String DATOS_COMPLETOS = "Plan guardado";
    public IncludeCellTest() {
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
        cell a = new cell();
        a.setBatery(2000);
        a.setCamera(3);
        a.setCompany("Huawei");
        a.setCost(8000);
        a.setPlan(false);
        a.setProcessor("Holi");
        a.setRam(5);
        a.setRom(20);
        assertEquals(validarPlan.verificar(a), DATOS_COMPLETOS);
    }
    
     @Test
    public void testDatosIncompletos(){
        cell a = new cell();
        a.setBatery(2000);
        a.setCamera(3);
        //a.setCompany("Huawei");
       // a.setCost(8000);
        a.setPlan(false);
        a.setProcessor("Holi");
        a.setRam(5);
        a.setRom(20);
        assertEquals(validarPlan.verificar(a), DATOS_COMPLETOS);
    }
}

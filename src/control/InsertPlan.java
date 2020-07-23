/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
//import javax.swing.JOptionPane;
//import mb_version_3.IncludePanel;

import entidad.plan;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import static org.junit.Assert.*;

/**
 *
 * @author Lorraine
 */
public class InsertPlan {

    private plan plan;

    public InsertPlan() {
    }

    /*public InsertPlan(int gb, int scd, int mss, double cst, String operator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public String PlanRepetido(plan a, plan b) throws IOException {
        InsertPlan x = new InsertPlan(a.getGB(), (int) a.getSecondLine(), a.getMessages(), a.getCost(), a.getOperator());
        ArrayList<String[]> plan1 = x.returnPlans();
        InsertPlan y = new InsertPlan(b.getGB(), (int) b.getSecondLine(), b.getMessages(), b.getCost(), b.getOperator());

        ArrayList<String[]> plan2 = y.returnPlans();
        int p = numberPlans();
        if (plan1.get(p).equals(plan2.get(p))) {
            return "Ya existe este plan";
        } else {
            return "Datos correctos";
        }
    }

    public String verificarNum(plan b) {
        try {
            b.getCost();
            b.getMessages();
            b.getSecondLine();
            return "Plan guardado correctamente";
        } catch (NumberFormatException nfe) {
            return "Datos incompatibles";
        }

    }

    public String verificarDatos() {
        return "Datos incompatibles";
    }

    public String verificarFormulario(plan a) {
        if (a.getCost() == 0 || a.getGB() == "" || a.getMessages() == 0 || a.getOperator() == "" || a.getSecondLine() == 0) {
            return "Faltan algunos datos";
        } else {
            return "Plan guardado";
        }
    }

    public InsertPlan(String GB, int secont, int messages, double cost, String operator) throws IOException {
        //String GB1 = Integer.toString(GB);
        String scnt = Integer.toString(secont);
        String mss = Integer.toString(messages);
        String cst = Double.toString(cost);

        this.saveplan(GB, scnt, mss, cst, operator);
    }

    private void saveplan(String GB, String secont, String messages, String cost, String operator) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("plans.db", true));

        String tosave = GB + " " + secont + " " + messages + " " + cost + " " + operator;
        writer.append(tosave);
        writer.newLine();
        writer.close();

    }

    public int numberPlans() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader("plans.db");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int n = 0;
        while ((line = bufferedReader.readLine()) != null) {
            n++;
        }
        return n;
    }

    public ArrayList returnPlans() throws FileNotFoundException, IOException {
        // FileReader reads text files in the default encoding.
        FileReader fileReader
                = new FileReader("plans.db");

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // This will reference one line at a time
        String line;
        ArrayList<String[]> plans = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            plans.add(line.split(" "));
        }
        return plans;
    }

    public ArrayList namePlans() throws FileNotFoundException, IOException {
        ArrayList<String> nameOperator = new ArrayList();
        ArrayList<String[]> plans = returnPlans();

        for (int i = 0; i < numberPlans(); i++) {
            String p = plans.get(i)[4];
            nameOperator.add(p);
        }

        return nameOperator;
    }

    //for git
}

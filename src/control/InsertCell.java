/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidad.SistemaCatalogo;
import entidad.cell;
import frontera.Pantalla_principal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class InsertCell 
{
    private SistemaCatalogo sistemacatalogo = Pantalla_principal.sistemacatalogo;
    private cell c = new cell();

    public InsertCell() {
        //this.saveCell(c);
    }
    public String verificarNum(cell b){
       try{
           b.getBatery();
           b.getCamera();
           b.getCost();
           b.getRam();
           b.getRom();
           return "Plan guardado correctamente";
       }catch(NumberFormatException nfe){
           return "Datos incompatibles";
       }
       
      
      }
    public String verificarDatos(){
        return "Datos incompatibles";
    }
    
    public String verificar(cell a)
    {    
        if(a.getBatery()==0  || a.getCamera() == 0  || a.getCompany() == ""  || 
                a.getCost() == 0  ||  a.getProcessor() == ""  ||  a.getRam() == 0  || a.getRom() == 0  || a.isPlan() == null){
           return "Faltan algunos datos";
       }else{
           return "Plan guardado";
       }
       /*try{
           a.getBatery();
           a.getCamera();
           a.getCompany();
           a.getCost();
           a.getPlan();
           a.getProcessor();
           a.getRam();
           a.getRom();
       }catch (NullPointerException e){
           return "Faltan algunos datos";
       }
       return"Plan guardado";*/
   }
    
    /*
    public void saveCell(cell cells) throws IOException
    {   
        for(cell c: sistemacatalogo.getCells()){}
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cells.db", true))) {
            String tosave = c.getCompany() + " " + c.getProcessor() + " " + c.getRam() + " " + c.getRom() +
                    " " + c.getCamera() + " " + c.getBatery() + " " + c.getCost() + " " + c.getPlan();
            writer.append(tosave);
            writer.newLine();
            writer.close();
        }
    }
    */
    
    public InsertCell(String company, String processor, double ram, double rom, double camera,
                      double batery, double cost, boolean plan) throws IOException
    {
        String Sram = Double.toString(ram);
        String Srom = Double.toString(rom);
        String Scamera = Double.toString(camera);
        String Sbatery = Double.toString(batery);
        String Scost = Double.toString(batery);
        String Splan = Boolean.toString(plan);
        
        this.saveCell(company, processor, Sram, Srom, Scamera, Sbatery, Scost, Splan);
    }
  
    private void saveCell(String company, String processor, String ram, String rom, String camera,
                      String batery, String cost, String plan) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("cells.db", true));
        String tosave = company + " " + processor + " " + ram + " " + rom + " " + camera + " " + batery
                                + " " + cost + " " + plan ;
        writer.append(tosave);
        writer.newLine();
        writer.close();
    }
    
    public ArrayList returnCellss() throws FileNotFoundException, IOException
    {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = 
            new FileReader("cells.db");

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // This will reference one line at a time
        String line;
        ArrayList<String[]> cells = new ArrayList<>();
        while((line = bufferedReader.readLine()) != null) {
            cells.add(line.split(" "));
        }  
        return cells;
    }

    /*
    public String returnNameCell() throws FileNotFoundException, IOException
    {
        FileReader fileReader = new FileReader("cells.db");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String nameCell = null;
        while((line = bufferedReader.readLine()) != null){
            nameCell = line;
        }
        return nameCell;
    }
    */
    
    public int numberCells() throws FileNotFoundException, IOException 
    {
        FileReader fileReader = new FileReader("cells.db");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int n = 0;
        while ((line = bufferedReader.readLine()) != null) {
            n++;
        }
        return n;
    }
    
    public ArrayList returnNameCell() throws FileNotFoundException, IOException 
    {
        ArrayList<String> nameCell = new ArrayList();
        ArrayList<String[]> cells = returnCellss();

        
        for (int i = 0; i < numberCells(); i++) {
            String p = cells.get(i)[0];
            nameCell.add(p);
        }

        return nameCell;
    }
}





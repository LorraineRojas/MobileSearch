/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author JULIO
 */
@Entity
@Table(name="celulares")
public class cell implements Serializable
{    
    
    private String company,processor;
    private double ram;
    private double rom;
    private double camera;
    private double batery;
    private double cost;
    private Boolean plan;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    public cell(){}
    
    public cell(String company, String processor, double ram, double rom, double camera,
                      double batery, double cost, boolean plan)
    {
        this.company = company;
        this.processor = processor;
        this.ram = ram;
        this.rom = rom;
        this.camera = camera;
        this.batery = batery;
        this.cost = cost;
        this.plan = plan;
    }
    /*
    private String company,processor,ram,rom,camera,batery,cost,plan;
    public cell(){}
    public cell(String company, String processor, String ram, 
                String rom, String camera, String batery, String cost, String plan){
        this.company = company;
        this.processor = processor;
        this.ram = ram;
        this.rom = rom;
        this.camera = camera;
        this.batery = batery;
        this.cost = cost;
        this.plan = plan;
    }
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public double getRom() {
        return rom;
    }

    public void setRom(double rom) {
        this.rom = rom;
    }

    public double getCamera() {
        return camera;
    }

    public void setCamera(double camera) {
        this.camera = camera;
    }

    public double getBatery() {
        return batery;
    }

    public void setBatery(double batery) {
        this.batery = batery;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Boolean isPlan() {
        return plan;
    }

    public void setPlan(Boolean plan) {
        this.plan = plan;
    }
    
    @Override
    public String toString() {
        return company;
    }
 
}

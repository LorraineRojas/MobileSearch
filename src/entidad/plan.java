/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

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
@Table(name="planes")
public class plan {
  private String GB;
  private int secondLine;
  private int messages;
  private double cost;
  private String operator;
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public plan() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getGB() {
        return GB;
    }

    public void setGB(String GB) {
        this.GB = GB;
    }

    public float getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(int secondLine) {
        this.secondLine = secondLine;
    }

    public int getMessages() {
        return messages;
    }

    public void setMessages(int messages) {
        this.messages = messages;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public plan(  String GB, int secondLine, int messages, double cost, String operator) {
        this.GB = GB;
        this.secondLine = secondLine;
        this.messages = messages;
        this.cost = cost;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "plan{" + "GB=" + GB + ", secondLine=" + secondLine + ", messages=" + messages + ", cost=" + cost + ", operator=" + operator + '}';
    }

}

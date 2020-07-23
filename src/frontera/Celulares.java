/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontera;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author JULIO
 */
@Entity
@Table(name = "CELULARES", catalog = "", schema = "MBADMIN")
@NamedQueries({
    @NamedQuery(name = "Celulares.findAll", query = "SELECT c FROM Celulares c")
    , @NamedQuery(name = "Celulares.findById", query = "SELECT c FROM Celulares c WHERE c.id = :id")
    , @NamedQuery(name = "Celulares.findByBatery", query = "SELECT c FROM Celulares c WHERE c.batery = :batery")
    , @NamedQuery(name = "Celulares.findByCamera", query = "SELECT c FROM Celulares c WHERE c.camera = :camera")
    , @NamedQuery(name = "Celulares.findByCompany", query = "SELECT c FROM Celulares c WHERE c.company = :company")
    , @NamedQuery(name = "Celulares.findByCost", query = "SELECT c FROM Celulares c WHERE c.cost = :cost")
    , @NamedQuery(name = "Celulares.findByPlan", query = "SELECT c FROM Celulares c WHERE c.plan = :plan")
    , @NamedQuery(name = "Celulares.findByProcessor", query = "SELECT c FROM Celulares c WHERE c.processor = :processor")
    , @NamedQuery(name = "Celulares.findByRam", query = "SELECT c FROM Celulares c WHERE c.ram = :ram")
    , @NamedQuery(name = "Celulares.findByRom", query = "SELECT c FROM Celulares c WHERE c.rom = :rom")})
public class Celulares implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BATERY")
    private Double batery;
    @Column(name = "CAMERA")
    private Double camera;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "COST")
    private Double cost;
    @Column(name = "PLAN")
    private Short plan;
    @Column(name = "PROCESSOR")
    private String processor;
    @Column(name = "RAM")
    private Double ram;
    @Column(name = "ROM")
    private Double rom;

    public Celulares() {
    }

    public Celulares(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Double getBatery() {
        return batery;
    }

    public void setBatery(Double batery) {
        Double oldBatery = this.batery;
        this.batery = batery;
        changeSupport.firePropertyChange("batery", oldBatery, batery);
    }

    public Double getCamera() {
        return camera;
    }

    public void setCamera(Double camera) {
        Double oldCamera = this.camera;
        this.camera = camera;
        changeSupport.firePropertyChange("camera", oldCamera, camera);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        String oldCompany = this.company;
        this.company = company;
        changeSupport.firePropertyChange("company", oldCompany, company);
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        Double oldCost = this.cost;
        this.cost = cost;
        changeSupport.firePropertyChange("cost", oldCost, cost);
    }

    public Short getPlan() {
        return plan;
    }

    public void setPlan(Short plan) {
        Short oldPlan = this.plan;
        this.plan = plan;
        changeSupport.firePropertyChange("plan", oldPlan, plan);
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        String oldProcessor = this.processor;
        this.processor = processor;
        changeSupport.firePropertyChange("processor", oldProcessor, processor);
    }

    public Double getRam() {
        return ram;
    }

    public void setRam(Double ram) {
        Double oldRam = this.ram;
        this.ram = ram;
        changeSupport.firePropertyChange("ram", oldRam, ram);
    }

    public Double getRom() {
        return rom;
    }

    public void setRom(Double rom) {
        Double oldRom = this.rom;
        this.rom = rom;
        changeSupport.firePropertyChange("rom", oldRom, rom);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Celulares)) {
            return false;
        }
        Celulares other = (Celulares) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frontera.Celulares[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

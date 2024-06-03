package com.example.gastos.domain.model;

import java.util.Date;
import java.util.List;

import com.example.gastos.domain.Enum.ETypeTitle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Title {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTitle")
    private Long id;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;
    private ETypeTitle type;
    @ManyToMany
    @JoinTable(
        name = "title_costcenter",
        joinColumns = @JoinColumn(name = "idTitle"),
        inverseJoinColumns = @JoinColumn(name = "idCostCenter")
    )
    private List<CostCenter> costCenters;
    @Column(nullable = false)
    private Double value;
    private Date registerDate;
    private Date referenceDate;
    private Date maturityDate;
    private Date payDate;
    @Column(columnDefinition = "TEXT")
    private String observation;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
    public ETypeTitle getType() {
        return type;
    }
    public void setType(ETypeTitle type) {
        this.type = type;
    }
    public List<CostCenter> getCostCenters() {
        return costCenters;
    }
    public void setCostCenters(List<CostCenter> costCenters) {
        this.costCenters = costCenters;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public Date getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    public Date getReferenceDate() {
        return referenceDate;
    }
    public void setReferenceDate(Date referenceDate) {
        this.referenceDate = referenceDate;
    }
    public Date getMaturityDate() {
        return maturityDate;
    }
    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }
    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    public String getObservation() {
        return observation;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }

}

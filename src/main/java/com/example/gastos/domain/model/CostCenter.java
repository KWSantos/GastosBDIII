package com.example.gastos.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class CostCenter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCostCenter")
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(columnDefinition = "TEXT")
    private String observation;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;
    @ManyToMany(mappedBy = "costCenters")
    @JsonBackReference
    private List<Title> titles;

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
    public String getObservation() {
        return observation;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
    public List<Title> getTitles() {
        return titles;
    }
    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }


}

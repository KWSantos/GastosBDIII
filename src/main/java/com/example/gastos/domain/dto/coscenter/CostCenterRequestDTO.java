package com.example.gastos.domain.dto.coscenter;

public class CostCenterRequestDTO {
    
    private String description;
    private String observation;
    
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
}

package com.example.gastos.domain.dto.title;

import java.util.Date;
import java.util.List;

import com.example.gastos.domain.Enum.ETypeTitle;
import com.example.gastos.domain.dto.coscenter.CostCenterResponseDTO;

public class TitleResponseDTO {

    private Long id;
    private String description;
    private ETypeTitle type;
    private List<CostCenterResponseDTO> costCenters;
    private Double value;
    private Date registerDate;
    private Date referenceDate;
    private Date validateDate;
    private Date paymentDate;
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
    public ETypeTitle getType() {
        return type;
    }
    public void setType(ETypeTitle type) {
        this.type = type;
    }
    public List<CostCenterResponseDTO> getCostCenters() {
        return costCenters;
    }
    public void setCostCenters(List<CostCenterResponseDTO> costCenters) {
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
    public Date getValidateDate() {
        return validateDate;
    }
    public void setValidateDate(Date validateDate) {
        this.validateDate = validateDate;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public String getObservation() {
        return observation;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }
    
}

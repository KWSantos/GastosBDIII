package com.example.gastos.domain.dto.dashboard;

import java.util.List;

import com.example.gastos.domain.dto.title.TitleResponseDTO;

public class DashboardResponseDTO {
    
    private Double totalPay;
    private Double totalReceive;
    private Double balance;
    private List<TitleResponseDTO> titlesPay;
    private List<TitleResponseDTO> titlesReceive;

    public DashboardResponseDTO() {}

    public DashboardResponseDTO(Double totalPay, Double totalReceive, Double balance, List<TitleResponseDTO> titlesPay, List<TitleResponseDTO> titlesReceive) {
        this.totalPay = totalPay;
        this.totalReceive = totalReceive;
        this.balance = balance;
        this.titlesPay = titlesPay;
        this.titlesReceive = titlesReceive;
    }

    public Double getTotalPay() {
        return totalPay;
    }
    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }
    public Double getTotalReceive() {
        return totalReceive;
    }
    public void setTotalReceive(Double totalReceive) {
        this.totalReceive = totalReceive;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public List<TitleResponseDTO> getTitlesPay() {
        return titlesPay;
    }
    public void setTitlesPay(List<TitleResponseDTO> titlesPay) {
        this.titlesPay = titlesPay;
    }
    public List<TitleResponseDTO> getTitlesReceive() {
        return titlesReceive;
    }
    public void setTitlesReceive(List<TitleResponseDTO> titlesReceive) {
        this.titlesReceive = titlesReceive;
    }
    
}

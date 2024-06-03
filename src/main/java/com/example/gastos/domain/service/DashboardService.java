package com.example.gastos.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gastos.domain.Enum.ETypeTitle;
import com.example.gastos.domain.dto.dashboard.DashboardResponseDTO;
import com.example.gastos.domain.dto.title.TitleResponseDTO;

@Service
public class DashboardService {
    
    @Autowired
    private TitleService titleService;

    public DashboardResponseDTO getCashFlow(String initialPeriod, String finalPeriod) {
        List<TitleResponseDTO> titles = titleService.getByMaturityDate(initialPeriod, finalPeriod);
        Double totalPay = 0.0;
        Double totalReceive = 0.0;
        Double balance = 0.0;
        List<TitleResponseDTO> titlesPay = new ArrayList<>();
        List<TitleResponseDTO> titlesReceive = new ArrayList<>();
        for(TitleResponseDTO title : titles) {
            if(title.getType() == ETypeTitle.TOPAY) {
                totalPay += title.getValue();
                titlesPay.add(title);
            }
            else {
                totalReceive += title.getValue();
            }
        }
        balance = totalReceive - totalPay;
        return new DashboardResponseDTO(totalPay, totalReceive, balance, titlesPay, titlesReceive);
    }
}

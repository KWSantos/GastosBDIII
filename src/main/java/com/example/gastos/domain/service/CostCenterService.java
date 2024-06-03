package com.example.gastos.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.gastos.domain.dto.coscenter.CostCenterRequestDTO;
import com.example.gastos.domain.dto.coscenter.CostCenterResponseDTO;
import com.example.gastos.domain.exception.ResourceNotFoundException;
import com.example.gastos.domain.model.CostCenter;
import com.example.gastos.domain.model.Users;
import com.example.gastos.domain.repository.CostCenterRepository;

@Service
public class CostCenterService implements ICRUDService<CostCenterRequestDTO, CostCenterResponseDTO>{

    @Autowired
    private CostCenterRepository centerRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CostCenterResponseDTO> getAll() {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<CostCenter> list = centerRepository.findByUser(user);
        return list.stream().map(costCenter -> mapper.map(costCenter, CostCenterResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CostCenterResponseDTO getById(Long id) {
        Optional<CostCenter> optCostCenter = centerRepository.findById(id);
        if(optCostCenter.isEmpty()) {
            throw new ResourceNotFoundException("Nao foi possivel encontrar o centro de custo com o id " + id);
        }
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(optCostCenter.get().getUser().getId() != user.getId()) {
            throw new ResourceNotFoundException("O centro de custos com id" + id + " nao pertence a esse usuario");
        }
        return mapper.map(optCostCenter.get(), CostCenterResponseDTO.class);
    }

    @Override
    public CostCenterResponseDTO register(CostCenterRequestDTO dto) {
        CostCenter costCenter = mapper.map(dto, CostCenter.class);
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        costCenter.setUser(user);
        costCenter.setId(null);
        costCenter = centerRepository.save(costCenter);
        return mapper.map(costCenter, CostCenterResponseDTO.class);
    }

    @Override
    public CostCenterResponseDTO update(Long id, CostCenterRequestDTO dto) {
        getById(id);
        CostCenter costCenter = mapper.map(dto, CostCenter.class);
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        costCenter.setUser(user);
        costCenter.setId(id);
        costCenter = centerRepository.save(costCenter);
        return mapper.map(costCenter, CostCenterResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        centerRepository.deleteById(id);
    }
    
}

package com.example.gastos.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.gastos.domain.dto.title.TitleRequestDTO;
import com.example.gastos.domain.dto.title.TitleResponseDTO;
import com.example.gastos.domain.exception.ResourceBadRequestException;
import com.example.gastos.domain.exception.ResourceNotFoundException;
import com.example.gastos.domain.model.Title;
import com.example.gastos.domain.model.Users;
import com.example.gastos.domain.repository.TitleRepository;

@Service
public class TitleService implements ICRUDService<TitleRequestDTO, TitleResponseDTO>{

    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TitleResponseDTO> getAll() {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Title> titles = titleRepository.findByUser(user);
        return titles.stream().map(title -> modelMapper.map(title, TitleResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TitleResponseDTO getById(Long id) {
        Optional<Title> optTitle = titleRepository.findById(id);
        if(optTitle.isEmpty()) {
            throw new ResourceNotFoundException("Nao foi possivel encontrar o titulo com o id " + id);
        }
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(optTitle.get().getUser().getId() != user.getId()) {
            throw new ResourceNotFoundException("O titulo com id" + id + " nao pertence a esse usuario");
        }
        return modelMapper.map(optTitle.get(), TitleResponseDTO.class);
    }

    @Override
    public TitleResponseDTO register(TitleRequestDTO dto) {
        validateTitle(dto);
        Title title = modelMapper.map(dto, Title.class);
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        title.setUser(user);
        title.setId(null);
        title.setRegisterDate(new Date());
        title = titleRepository.save(title);
        return modelMapper.map(title, TitleResponseDTO.class);
    }

    @Override
    public TitleResponseDTO update(Long id, TitleRequestDTO dto) {
        validateTitle(dto);
        getById(id);
        Title title = modelMapper.map(dto, Title.class);
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        title.setUser(user);
        title.setId(id);
        title = titleRepository.save(title);
        return modelMapper.map(title, TitleResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        titleRepository.deleteById(id);
    }

    private void validateTitle(TitleRequestDTO dto) {
        if(dto.getType() == null || dto.getValidateDate() == null || dto.getValue() == null || dto.getDescription() == null) {
            throw new ResourceBadRequestException("Titulo invalido");
        }
    }

    public List<TitleResponseDTO> getByMaturityDate(String initialPeriod, String finalPeriod) {
        List<Title> titles = titleRepository.getByMaturityDate(initialPeriod, finalPeriod);
        return titles.stream().map(title -> modelMapper.map(title, TitleResponseDTO.class)).collect(Collectors.toList());
    }
    
}

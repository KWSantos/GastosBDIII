package com.example.gastos.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gastos.domain.dto.user.UserRequestDTO;
import com.example.gastos.domain.dto.user.UserResponseDTO;
import com.example.gastos.domain.exception.ResourceBadRequestException;
import com.example.gastos.domain.exception.ResourceNotFoundException;
import com.example.gastos.domain.model.Users;
import com.example.gastos.domain.repository.UserRepository;

@Service
public class UserService implements ICRUDService <UserRequestDTO, UserResponseDTO>{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UserResponseDTO> getAll() {
        List<Users> users = userRepository.findAll();
        return users.stream().map(user -> mapper.map(user, UserResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getById(Long id) {
        Optional<Users> optUser = userRepository.findById(id);
        if(optUser.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível obter o usuário com o id " + id);
        }
        return mapper.map(optUser.get(), UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO register(UserRequestDTO dto) {
        
        if(dto.getEmail() == null || dto.getPassword() == null) {
            throw new ResourceBadRequestException("Email e senha são obrigatórios");
        }
        Optional<Users> optUser = userRepository.findByEmail(dto.getEmail());
        if(optUser.isPresent()) {
            throw new ResourceBadRequestException("Este usuário já está cadastrado");
        }
        Users user = mapper.map(dto, Users.class);
        user.setRegisterDate(new Date());
        String password = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        user = userRepository.save(user);
        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        UserResponseDTO userData = getById(id);
        if(dto.getEmail() == null || dto.getPassword() == null) {
            throw new ResourceBadRequestException("Email e senha são obrigatórios");
        }
        Users user = mapper.map(dto, Users.class);
        user.setId(id);
        user.setPassword(dto.getPassword());
        user.setRegisterDate(userData.getRegisterDate());
        user.setInactivateDate(userData.getInactivateDate());
        user = userRepository.save(user);
        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Users> optUser = userRepository.findById(id);
        if(optUser.isEmpty()) {
            throw new ResourceBadRequestException("Não foi possível encontrar o usuário com id " + id);
        }
        Users user = optUser.get();
        user.setInactivateDate(new Date());
        userRepository.save(user);
    }
    
}

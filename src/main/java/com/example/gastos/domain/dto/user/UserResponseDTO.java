package com.example.gastos.domain.dto.user;

import java.util.Date;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String photo;
    private Date registerDate;
    private Date inactivateDate;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Date getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    public Date getInactivateDate() {
        return inactivateDate;
    }
    public void setInactivateDate(Date inactivateDate) {
        this.inactivateDate = inactivateDate;
    }

}

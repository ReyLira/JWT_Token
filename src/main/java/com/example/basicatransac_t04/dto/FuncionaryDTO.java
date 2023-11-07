package com.example.basicatransac_t04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionaryDTO {
    private Integer id_funcionary;
    private String name;
    private String surname;
    private String dni;
    private String phonenumber;
    private String rank;
    private String department;
    private String address;
    private String email;
    private String estado;

    // Getters y setters
}


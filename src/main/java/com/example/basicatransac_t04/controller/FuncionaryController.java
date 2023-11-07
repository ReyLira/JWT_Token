package com.example.basicatransac_t04.controller;

import com.example.basicatransac_t04.dto.FuncionaryDTO;
import com.example.basicatransac_t04.entity.Funcionary;
import com.example.basicatransac_t04.service.FuncionaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class FuncionaryController {
    private final FuncionaryService funcionaryService;

    public FuncionaryController(FuncionaryService funcionaryService) {
        this.funcionaryService = funcionaryService;
    }

    @PostMapping("/create")
    public Funcionary create(@RequestBody Funcionary funcionary){
        return funcionaryService.create(funcionary);
    }

    @GetMapping("/{id}")
    public Funcionary listar(@PathVariable Integer id){
        return funcionaryService.listar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionaryDTO> updateFuncionary(
            @PathVariable Integer id,
            @RequestBody FuncionaryDTO updatedFuncionaryDTO
    ) {
        Funcionary existingFuncionary = funcionaryService.findById(id);

        if (existingFuncionary == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualiza los campos del funcionario existente con los nuevos valores del DTO
        existingFuncionary.setName(updatedFuncionaryDTO.getName());
        existingFuncionary.setSurname(updatedFuncionaryDTO.getSurname());
        existingFuncionary.setDni(updatedFuncionaryDTO.getDni());
        existingFuncionary.setPhonenumber(updatedFuncionaryDTO.getPhonenumber());
        existingFuncionary.setRank(updatedFuncionaryDTO.getRank());
        existingFuncionary.setDepartment(updatedFuncionaryDTO.getDepartment());
        existingFuncionary.setAddress(updatedFuncionaryDTO.getAddress());
        existingFuncionary.setEmail(updatedFuncionaryDTO.getEmail());
        existingFuncionary.setEstado(updatedFuncionaryDTO.getEstado());

        // Actualiza otros campos según sea necesario

        // Realiza la actualización en el servicio y obtén el resultado
        Funcionary updatedFuncionary = funcionaryService.update(existingFuncionary);

        // Crea un nuevo DTO con los datos actualizados
        FuncionaryDTO responseDTO = new FuncionaryDTO();
        responseDTO.setId_funcionary(updatedFuncionary.getId_funcionary());
        responseDTO.setName(updatedFuncionary.getName());
        responseDTO.setSurname(updatedFuncionary.getSurname());
        responseDTO.setDni(updatedFuncionary.getDni());
        responseDTO.setPhonenumber(updatedFuncionary.getPhonenumber());
        responseDTO.setRank(updatedFuncionary.getRank());
        responseDTO.setDepartment(updatedFuncionary.getDepartment());
        responseDTO.setAddress(updatedFuncionary.getAddress());
        responseDTO.setEmail(updatedFuncionary.getEmail());
        responseDTO.setEstado(updatedFuncionary.getEstado());

        // Devuelve el DTO actualizado en la respuesta
        return ResponseEntity.ok(responseDTO);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        funcionaryService.delete(id);
    }


    @GetMapping("/list")
    public List<Funcionary> findAll(){
        return funcionaryService.findAll();
    }
}
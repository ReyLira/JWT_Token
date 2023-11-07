package com.example.basicatransac_t04.service;

import com.example.basicatransac_t04.entity.Funcionary;
import com.example.basicatransac_t04.repository.FuncionaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionaryService {
    private final FuncionaryRepository funcionaryRepository;

    public FuncionaryService(FuncionaryRepository funcionaryRepository) {
        this.funcionaryRepository = funcionaryRepository;
    }

    public Funcionary listar(Integer id){
        return funcionaryRepository.findById(id).get();
    }

    public Funcionary create(Funcionary funcionary){
        return funcionaryRepository.save(funcionary);
    }

    public Funcionary update(Funcionary funcionary) {
        return funcionaryRepository.save(funcionary);
    }

    public Funcionary findById(Integer id) {
        return funcionaryRepository.findById(id).orElse(null);
    }

    public Funcionary delete(Integer id) {
        Funcionary buscar = funcionaryRepository.findById(id).get();
        buscar.setEstado("I");
        return funcionaryRepository.save(buscar);
    }

    public List<Funcionary> findAll(){
        return funcionaryRepository.findAll();
    }

}

package com.projeto.ChinaEstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.ChinaEstore.entidade.Conta;
import com.projeto.ChinaEstore.repository.ContaRepository;

@Service
public class CadastroContaService {
    @Autowired
    private ContaRepository contaRepository;
    @Transactional
        public Conta salvar(Conta conta){
            return contaRepository.save(conta);
        }
    
        public List<Conta> listaConta(){
            return contaRepository.findAll();
        }
    
        public Optional<Conta> buscarPorId(Long id){
            return contaRepository.findById(id);
        }
    
        public void removePorId(Long id){
            contaRepository.deleteById(id);
        }
}

package com.projeto.ChinaEstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.ChinaEstore.entidade.Venda;
import com.projeto.ChinaEstore.repository.VendaRepository;

@Service
public class CadastroVendaService {
    @Autowired
    private VendaRepository vendaRepository;
    @Transactional
    
        public Venda salvar(Venda venda){
            return vendaRepository.save(venda);
        }
    
        public List<Venda> listaVenda(){
            return vendaRepository.findAll();
        }
    
        public Optional<Venda> buscarPorId(Long id){
            return vendaRepository.findById(id);
        }
        public Venda listaPorId(Long id){
            return vendaRepository.findById(id).get();
        }
    
        public void removePorId(Long id){
            vendaRepository.deleteById(id);
        }
}

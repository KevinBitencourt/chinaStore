package com.projeto.ChinaEstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.ChinaEstore.entidade.Cliente;
import com.projeto.ChinaEstore.repository.ClienteRepository;

@Service
public class CadastroClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
        @Transactional
        public Cliente salvar(Cliente cliente){
            return clienteRepository.save(cliente);
        }
    
        public List<Cliente> listaCliente(){
            return clienteRepository.findAll();
        }
    
        public Optional<Cliente> buscarPorId(Long id){
            return clienteRepository.findById(id);
        }
        public Cliente listaPorId(Long id){
            return clienteRepository.findById(id).get();
        }
        public void removePorId(Long id){
            clienteRepository.deleteById(id);
        }
}

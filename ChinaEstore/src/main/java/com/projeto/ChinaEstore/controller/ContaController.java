package com.projeto.ChinaEstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.ChinaEstore.entidade.Conta;
import com.projeto.ChinaEstore.service.CadastroContaService;



@Controller
public class ContaController {
    @Autowired
    private CadastroContaService cadastroConta;

    @PostMapping("/contas")
    @ResponseBody
    public Conta salvarConta(@RequestBody Conta conta){
      cadastroConta.salvar(conta);
        return conta;
    }
    @GetMapping("/contas/lista")
    @ResponseBody
    public List<Conta> listarContas(){
        List<Conta > ct = new ArrayList<>();
       ct = cadastroConta.listaConta();
        return ct;
    }
    @RequestMapping(path="/conta/delete/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletarContaPorId(@PathVariable ("Id")Long id){
        cadastroConta.removePorId(id);
        return "Conta Deletada";
    } 
 
    @RequestMapping(path="/conta/lista/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Conta> listaContaPorId(@PathVariable ("Id")Long id){
       Optional<Conta> obj = cadastroConta.buscarPorId(id);
        return obj;
    }

    @GetMapping("/conta/saldo/{id}")
    @ResponseBody
    public String saldoConta(@PathVariable("id")Long id){
        Optional<Conta> ct = cadastroConta.buscarPorId(id);
        if(ct.isEmpty()){
        throw new IllegalArgumentException("Conta não existe");
        }
        return ct.get().getSaldo();
    }
    

}   


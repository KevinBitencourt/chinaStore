package com.projeto.ChinaEstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.ChinaEstore.entidade.Cliente;
import com.projeto.ChinaEstore.entidade.Produto;
import com.projeto.ChinaEstore.entidade.Venda;
import com.projeto.ChinaEstore.service.CadastroClienteService;
import com.projeto.ChinaEstore.service.CadastroProdutoService;
import com.projeto.ChinaEstore.service.CadastroVendaService;

@Controller
public class VendaController {
    @Autowired
   
    private CadastroClienteService cadastroCliente;
    private CadastroVendaService cadastroVenda;
    private CadastroProdutoService cadastroProduto;
    @RequestMapping(value="/venda/{id1}/{id2}", method=RequestMethod.GET)
   @ResponseBody
   public Venda salvarVenda(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2){

    Venda venda = new Venda();

    Cliente cliente = cadastroCliente.listaPorId(id1);
   // Produto produto = cadastroProduto.listaPorId(id2);
   
    cliente.getId();
   // produto.getId();
    venda.setCliente(cliente);
   // venda.setProduto(produto);
   // cadastroVenda.salvar(venda);
    return venda;



}
@RequestMapping(path="venda/produto/lista/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Produto> listaProdutoPorId(@PathVariable ("Id")Long id){
       Optional<Produto> obj = cadastroProduto.buscarPorId(id);
        return obj;
    }

   @GetMapping("/vendas/lista")
   @ResponseBody
   public List<Venda> listarVendas(){
       List<Venda > vd = new ArrayList<>();
      vd = cadastroVenda.listaVenda();
       return vd;
   }
   @RequestMapping(path="/venda/delete/{Id}", method = RequestMethod.DELETE)
   @ResponseBody
   public String deletarVendaPorId(@PathVariable ("Id")Long id){
       cadastroVenda.removePorId(id);
       return "Venda Deletada";
   }

   @RequestMapping(path="/venda/lista/{Id}", method = RequestMethod.GET)
   @ResponseBody
   public Optional<Venda> listaVendaPorId(@PathVariable ("Id")Long id){
      Optional<Venda> obj = cadastroVenda.buscarPorId(id);
       return obj;
   }

}

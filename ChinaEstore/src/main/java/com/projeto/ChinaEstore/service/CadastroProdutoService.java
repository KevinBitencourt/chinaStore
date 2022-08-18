package com.projeto.ChinaEstore.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projeto.ChinaEstore.entidade.Produto;
import com.projeto.ChinaEstore.repository.ProdutoRepository;

@Service
public class CadastroProdutoService {
   
    @Autowired
    private ProdutoRepository produtoRepository;
    @Transactional
        public Produto salvar(Produto produto){
            return produtoRepository.save(produto);
        }
    
        public List<Produto> listaProduto(){
            return produtoRepository.findAll();
        }
    
        public Optional<Produto> buscarPorId(Long id){
            return produtoRepository.findById(id);
        }
        
        public Produto listaPorId(Long id){
            return produtoRepository.findById(id).get();
        }
    
        public void removePorId(Long id){
            produtoRepository.deleteById(id);
        }
    
}

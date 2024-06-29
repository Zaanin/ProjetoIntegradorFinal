package proBarber.proBarber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proBarber.proBarber.dto.ProdutoDTO;
import proBarber.proBarber.dto.ProdutoDTORequest;
import proBarber.proBarber.model.Produto;
import proBarber.proBarber.Repositories.ProdutoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduto(@RequestBody ProdutoDTORequest produtoRequestDTO) {
        Produto produto = new Produto();
        produto.setNomeProduto(produtoRequestDTO.nomeProduto());
        produto.setDescricao(produtoRequestDTO.descricao());
        produto.setPreco(produtoRequestDTO.preco());
        produto.setQuantidadeEstoque(produtoRequestDTO.quantidadeEstoque());
        produto.setCategoria(produtoRequestDTO.categoria());
        produto.setImagemProduto(produtoRequestDTO.imagemProduto());

        Produto savedProduto = produtoRepository.save(produto);
        ProdutoDTO produtoDTO = new ProdutoDTO(savedProduto);
        return new ResponseEntity<>(produtoDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoDTO> produtoDTOs = produtos.stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(produtoDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        return optionalProduto.map(produto ->
                        new ResponseEntity<>(new ProdutoDTO(produto), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTORequest produtoRequestDTO) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);

        if (optionalProduto.isPresent()) {
            Produto existingProduto = optionalProduto.get();
            existingProduto.setNomeProduto(produtoRequestDTO.nomeProduto());
            existingProduto.setDescricao(produtoRequestDTO.descricao());
            existingProduto.setPreco(produtoRequestDTO.preco());
            existingProduto.setQuantidadeEstoque(produtoRequestDTO.quantidadeEstoque());
            existingProduto.setCategoria(produtoRequestDTO.categoria());
            existingProduto.setImagemProduto(produtoRequestDTO.imagemProduto());

            Produto updatedProduto = produtoRepository.save(existingProduto);
            ProdutoDTO produtoDTO = new ProdutoDTO(updatedProduto);
            return new ResponseEntity<>(produtoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);

        if (optionalProduto.isPresent()) {
            produtoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

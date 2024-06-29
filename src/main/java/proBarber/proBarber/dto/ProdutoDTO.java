package proBarber.proBarber.dto;

import proBarber.proBarber.model.Produto;

public record ProdutoDTO(long id, String nomeProduto, String descricao, int preco, int quantidadeEstoque, String categoria, String imagemProduto) {
    public ProdutoDTO(Produto produto) {
        this(produto.getId(), produto.getNomeProduto(), produto.getDescricao(), produto.getPreco(), produto.getQuantidadeEstoque(), produto.getCategoria(), produto.getImagemProduto());
    }
}


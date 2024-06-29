package proBarber.proBarber.dto;


public record ProdutoDTORequest(String nomeProduto, String descricao, int preco, int quantidadeEstoque, String categoria, String imagemProduto) {
}

package proBarber.proBarber.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Produto{

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;

    @Column(
            name = "nomeProduto", length = 50
    )
    private String nomeProduto;

    @Column(
            name = "Descricao", length = 100
    )
    private String Descricao;

    @Column(
            name = "Preco"
    )
    private int Preco;

    @Column(
            name = "quantidadeEstoque"
    )
    private int quantidadeEstoque;
    @Column(
            name = "Categoria", length = 50
    )
    private String Categoria;
    @Column(
            name = "imagemProduto", columnDefinition = "TEXT"
    )
    private String imagemProduto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getPreco() {
        return Preco;
    }

    public void setPreco(int preco) {
        Preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }
}


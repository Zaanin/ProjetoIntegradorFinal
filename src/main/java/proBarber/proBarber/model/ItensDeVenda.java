package proBarber.proBarber.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItensDeVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Usuario", length = 50)
    private String Usuario;

    @Column(name = "Codigo", length = 50)
    private String Codigo;

    @Column(name = "Preco")
    private int Preco;

    @Column(name = "Quantidade")
    private int Quantidade;

    @Column(name = "Total")
    private int Total;

    @Column(name = "Tipo", length = 1)
    private String Tipo;

    @Column(name = "PedidoNumero")
    private Long pedidoNumero; // Assuming this field exists to link with the order

    public ItensDeVenda(long id, String usuario, String codigo, int preco, int quantidade, int total, String tipo, Long pedidoNumero) {
        this.id = id;
        Usuario = usuario;
        Codigo = codigo;
        Preco = preco;
        Quantidade = quantidade;
        Total = total;
        Tipo = tipo;
        this.pedidoNumero = pedidoNumero;
    }

    public ItensDeVenda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public int getPreco() {
        return Preco;
    }

    public void setPreco(int preco) {
        Preco = preco;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Long getPedidoNumero() {
        return pedidoNumero;
    }

    public void setPedidoNumero(Long pedidoNumero) {
        this.pedidoNumero = pedidoNumero;
    }
}

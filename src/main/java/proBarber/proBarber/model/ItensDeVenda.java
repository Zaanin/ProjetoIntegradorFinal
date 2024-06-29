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
}

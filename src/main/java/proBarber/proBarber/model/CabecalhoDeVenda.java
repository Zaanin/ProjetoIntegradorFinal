package proBarber.proBarber.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import proBarber.proBarber.dto.CabecalhoDTO;

import java.util.Date;

@Setter
@Table(name = "cabecalho")
@Entity(name = "cabecalho")
@EqualsAndHashCode(of = "id")
public class CabecalhoDeVenda {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private int pedidoNumero;
    @Getter
    private Date data;
    @Getter
    private String usuario;  //pegar da classe usuário
    @Getter
    private static float valorTotal; //pegar valor total do pedido


    public CabecalhoDeVenda(Long id, int pedidoNumero, Date data, String usuario, float valorTotal) {
        this.id = id;
        this.pedidoNumero = pedidoNumero;
        this.data = data;
        this.usuario = usuario;
        this.valorTotal = valorTotal;
    }

    public CabecalhoDeVenda(){

    }

    public CabecalhoDeVenda(CabecalhoDTO data){
        this.pedidoNumero =data.pedidoNumero();
        this.data = data.data();
        this.usuario = data.usuario();
        this.valorTotal = data.valorTotal();
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}

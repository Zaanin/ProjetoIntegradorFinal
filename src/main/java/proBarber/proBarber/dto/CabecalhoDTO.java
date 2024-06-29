package proBarber.proBarber.dto;

import proBarber.proBarber.model.CabecalhoDeVenda;

import java.util.Date;

public record CabecalhoDTO(Long id, int pedidoNumero, Date data, String usuario, float valorTotal) {
    public CabecalhoDTO(CabecalhoDeVenda cabecalho){
        this(cabecalho.getId(),cabecalho.getPedidoNumero(),cabecalho.getData(),cabecalho.getUsuario(),cabecalho.getValorTotal());

    }

    public double getValorTotal() {
        return valorTotal;
    }
}

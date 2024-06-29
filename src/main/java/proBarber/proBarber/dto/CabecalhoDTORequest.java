package proBarber.proBarber.dto;

import java.util.Date;

public record CabecalhoDTORequest(int pedidoNumero, Date data, String usuario, float valorTotal) {
}


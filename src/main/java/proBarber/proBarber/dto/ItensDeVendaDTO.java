package proBarber.proBarber.dto;

import proBarber.proBarber.model.Produto;
import java.util.List;

public record ItensDeVendaDTO(
        int id,
        int pedidoNumero,
        List<Produto> produtos
) {}


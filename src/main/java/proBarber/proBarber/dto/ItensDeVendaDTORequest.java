package proBarber.proBarber.dto;

import java.util.List;

public record ItensDeVendaDTORequest(
        int pedidoNumero,
        Double valorRecebido,
        List<Long> servicosIds,
        List<Long> produtosIds
) {}

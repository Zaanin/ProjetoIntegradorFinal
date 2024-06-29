package proBarber.proBarber.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proBarber.proBarber.Repositories.ItensRepository;
import proBarber.proBarber.model.ItensDeVenda;

import java.util.List;
import java.util.Optional;

@Service
public class ItensDeVendaService {

    private final ItensRepository itensDeVendaRepository;

    @Autowired
    public ItensDeVendaService(ItensRepository itensDeVendaRepository) {
        this.itensDeVendaRepository = itensDeVendaRepository;
    }

    public List<ItensDeVenda> getItensDeVendaPorPedido(Long idPedido) {
        // Implement the logic to fetch sale items by order id
        // Example:
        return itensDeVendaRepository.findByPedidoNumero(idPedido);
    }

    public ItensDeVenda adicionarItensDeVenda(Long idPedido, ItensDeVenda itensDeVenda) {
        // Implement the logic to add sale items to an order
        // Example:
        itensDeVenda.setPedidoNumero(idPedido);
        return itensDeVendaRepository.save(itensDeVenda);
    }

    public ItensDeVenda atualizarItensDeVenda(Long idPedido, Long id, ItensDeVenda itensDeVenda) {
        // Implement the logic to update sale items of an order
        // Example:
        Optional<ItensDeVenda> existingItem = itensDeVendaRepository.findById(Math.toIntExact(id));
        if (existingItem.isPresent()) {
            ItensDeVenda updatedItem = existingItem.get();
            updatedItem.setUsuario(itensDeVenda.getUsuario());
            updatedItem.setCodigo(itensDeVenda.getCodigo());
            updatedItem.setPreco(itensDeVenda.getPreco());
            updatedItem.setQuantidade(itensDeVenda.getQuantidade());
            updatedItem.setTotal(itensDeVenda.getTotal());
            updatedItem.setTipo(itensDeVenda.getTipo());
            updatedItem.setPedidoNumero(idPedido);
            return itensDeVendaRepository.save(updatedItem);
        } else {
            throw new RuntimeException("Item not found");
        }
    }

    public void deletarItensDeVenda(Long idPedido, Long id) {
        // Implement the logic to delete sale items of an order
        // Example:
        Optional<ItensDeVenda> existingItem = itensDeVendaRepository.findById(Math.toIntExact(id));
        if (existingItem.isPresent() && existingItem.get().getPedidoNumero().equals(idPedido)) {
            itensDeVendaRepository.deleteById(Math.toIntExact(id));
        } else {
            throw new RuntimeException("Item not found or does not belong to the specified order");
        }
    }
}

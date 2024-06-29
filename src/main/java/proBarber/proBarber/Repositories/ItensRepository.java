package proBarber.proBarber.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proBarber.proBarber.model.ItensDeVenda;

import java.util.List;

@Repository
public interface ItensRepository extends JpaRepository<ItensDeVenda, Integer> {

    List<ItensDeVenda> findByPedidoNumero(Long idPedido);

    // Outros métodos de consulta podem ser adicionados conforme necessário
}
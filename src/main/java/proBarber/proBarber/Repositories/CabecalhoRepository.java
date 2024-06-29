package proBarber.proBarber.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proBarber.proBarber.model.CabecalhoDeVenda;

public interface CabecalhoRepository extends JpaRepository<CabecalhoDeVenda, Long> {
}

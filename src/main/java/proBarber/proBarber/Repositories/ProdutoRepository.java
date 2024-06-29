package proBarber.proBarber.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import proBarber.proBarber.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto,Long> {
}

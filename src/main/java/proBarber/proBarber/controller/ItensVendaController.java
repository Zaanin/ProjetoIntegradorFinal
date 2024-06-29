package proBarber.proBarber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proBarber.proBarber.model.ItensDeVenda;
import proBarber.proBarber.services.ItensDeVendaService;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos/{idPedido}/itens")
public class ItensVendaController {

    private final ItensDeVendaService itensDeVendaService;

    @Autowired
    public ItensVendaController(ItensDeVendaService itensDeVendaService) {
        this.itensDeVendaService = itensDeVendaService;
    }

    // Endpoint para buscar todos os itens de venda de um pedido específico
    @GetMapping
    public ResponseEntity<List<ItensDeVenda>> getItensDeVendaPorPedido(@PathVariable Long idPedido) {
        List<ItensDeVenda> itensDeVenda = itensDeVendaService.getItensDeVendaPorPedido(idPedido);
        return ResponseEntity.ok(itensDeVenda);
    }

    // Endpoint para adicionar itens de venda a um pedido específico
    @PostMapping
    public ResponseEntity<ItensDeVenda> adicionarItensDeVenda(@PathVariable int idPedido, @RequestBody ItensDeVenda itensDeVenda) {
        ItensDeVenda itensCriado = itensDeVendaService.adicionarItensDeVenda((long) idPedido, itensDeVenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(itensCriado);
    }

    // Endpoint para atualizar itens de venda de um pedido específico
    @PutMapping("/{id}")
    public ResponseEntity<ItensDeVenda> atualizarItensDeVenda(@PathVariable int idPedido, @PathVariable int id, @RequestBody ItensDeVenda itensDeVenda) {
        ItensDeVenda itensAtualizado = itensDeVendaService.atualizarItensDeVenda((long) idPedido, (long) id, itensDeVenda);
        return ResponseEntity.ok(itensAtualizado);
    }

    // Endpoint para deletar itens de venda de um pedido específico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItensDeVenda(@PathVariable int idPedido, @PathVariable int id) {
        itensDeVendaService.deletarItensDeVenda((long) idPedido, (long) id);
        return ResponseEntity.noContent().build();
    }
}

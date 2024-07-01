package proBarber.proBarber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proBarber.proBarber.Repositories.CabecalhoRepository;
import proBarber.proBarber.dto.CabecalhoDTO;
import proBarber.proBarber.dto.CabecalhoDTORequest;
import proBarber.proBarber.dto.ProdutoDTO;
import proBarber.proBarber.dto.ProdutoDTORequest;
import proBarber.proBarber.model.CabecalhoDeVenda;
import proBarber.proBarber.model.Produto;

import java.util.List;

@RestController
@RequestMapping("cabecalho")
public class CabecalhoController {

    @Autowired
    private CabecalhoRepository cabRepository;
    // Get e Post do Cabeçalho
    @GetMapping
    public List<CabecalhoDTO> getAllCab (){
        List<CabecalhoDTO> cabList =cabRepository.findAll().stream().map(CabecalhoDTO::new).toList();
        return cabList;}

    @PostMapping
    public ResponseEntity<CabecalhoDTO> createCabecalho(@RequestBody CabecalhoDTORequest cabecalhoDTORequest) {
        CabecalhoDeVenda cabecalhoDeVenda = new CabecalhoDeVenda();
        cabecalhoDeVenda.setPedidoNumero(cabecalhoDTORequest.pedidoNumero());
        cabecalhoDeVenda.setData(cabecalhoDTORequest.data());
        cabecalhoDeVenda.setUsuario(cabecalhoDTORequest.usuario());
        cabecalhoDeVenda.setValorTotal(cabecalhoDTORequest.valorTotal());

        CabecalhoDeVenda savedCabecalho = cabRepository.save(cabecalhoDeVenda);
        CabecalhoDTO cabecalhoDTO = new CabecalhoDTO(savedCabecalho);
        return new ResponseEntity<>(cabecalhoDTO, HttpStatus.CREATED);
    }

}

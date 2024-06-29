package proBarber.proBarber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import proBarber.proBarber.Repositories.CabecalhoRepository;
import proBarber.proBarber.dto.CabecalhoDTO;
import proBarber.proBarber.dto.CabecalhoDTORequest;
import proBarber.proBarber.model.CabecalhoDeVenda;

import java.util.List;

public class CabecalhoController {

    @Autowired
    private CabecalhoRepository cabRepository;
    // Get e Post do Cabeçalho
    @GetMapping("/cabecalho")
    public List<CabecalhoDTO> getAllCab (){
        List<CabecalhoDTO> cabList =cabRepository.findAll().stream().map(CabecalhoDTO::new).toList();
        return cabList;}

    @PostMapping("/cabecalho")
    public  void saveCabecalho(@RequestBody CabecalhoDTORequest data){
        CabecalhoDeVenda cabData = new CabecalhoDeVenda();
        cabRepository.save(cabData);
        return;
    }

}

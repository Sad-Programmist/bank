package vsu.solodovnikova.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.solodovnikova.bank.data.dto.*;
import vsu.solodovnikova.bank.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/bank/client")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @PostMapping
    public void addClient(@RequestBody ClientCreateDto clientCreateDto){
        clientService.addClient(clientCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients(){
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }

    @PutMapping
    public void changeClient(@RequestParam Integer id, @RequestBody ClientChangeDto clientChangeDto){
        clientService.changeClient(id, clientChangeDto);
    }

    @DeleteMapping
    public void deleteClient(@RequestParam Integer id){
        clientService.deleteClient(id);
    }
}

package vsu.solodovnikova.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.solodovnikova.bank.data.dto.*;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;
import vsu.solodovnikova.bank.data.entity.ClientEntity;
import vsu.solodovnikova.bank.service.BankService;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
@AllArgsConstructor
public class BankController {
    private BankService bankService;

    @PostMapping("/client")
    public ResponseEntity<ClientEntity> addClient(@RequestBody ClientCreateDto clientCreateDto){
        ClientEntity client = bankService.addClient(clientCreateDto);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/client")
    public List<ClientDto> getClients(){
        return bankService.getClients();
    }

    @PostMapping("/clerk")
    public ResponseEntity<ClerkEntity> addClerk(@RequestBody ClerkCreateDto clerkCreateDto){
        ClerkEntity clerk = bankService.addClerk(clerkCreateDto);
        return new ResponseEntity<>(clerk, HttpStatus.OK);
    }

    @GetMapping("/clerk")
    public List<ClerkDto> getClerks(){
        return bankService.getClerks();
    }
}

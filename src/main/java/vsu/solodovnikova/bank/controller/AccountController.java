package vsu.solodovnikova.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.solodovnikova.bank.data.dto.AccountCreateDto;
import vsu.solodovnikova.bank.data.dto.AccountDto;
import vsu.solodovnikova.bank.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/bank/account")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public void addAccount(@RequestBody AccountCreateDto accountCreateDto){
        accountService.addAccount(accountCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccounts(){
        return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteAccount(@RequestParam Integer number){
        accountService.deleteAccount(number);
    }
}

package vsu.solodovnikova.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.solodovnikova.bank.data.dto.ClerkChangeDto;
import vsu.solodovnikova.bank.data.dto.ClerkCreateDto;
import vsu.solodovnikova.bank.data.dto.ClerkDto;
import vsu.solodovnikova.bank.service.ClerkService;

import java.util.List;

@RestController
@RequestMapping("/api/bank/clerk")
@AllArgsConstructor
public class ClerkController {
    private final ClerkService clerkService;

    @PostMapping
    public void addClerk(@RequestBody ClerkCreateDto clerkCreateDto){
        clerkService.addClerk(clerkCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<ClerkDto>> getClerks(){
        return new ResponseEntity<>(clerkService.getClerks(), HttpStatus.OK);
    }

    @PutMapping
    public void changeWorkspace(@RequestParam Integer id, @RequestBody ClerkChangeDto clerkChangeDto){
        clerkService.changeWorkspace(id, clerkChangeDto);
    }

    @DeleteMapping
    public void deleteClerk(@RequestParam Integer id){
        clerkService.deleteClerk(id);
    }
}

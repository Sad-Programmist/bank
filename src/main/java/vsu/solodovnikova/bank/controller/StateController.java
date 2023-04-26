package vsu.solodovnikova.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.solodovnikova.bank.data.dto.StateDto;
import vsu.solodovnikova.bank.service.StateService;

import java.util.List;

@RestController
@RequestMapping("/api/bank/state")
@AllArgsConstructor
public class StateController {
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<StateDto>> getStates(){
        return new ResponseEntity<>(stateService.getStates(), HttpStatus.OK);
    }
}

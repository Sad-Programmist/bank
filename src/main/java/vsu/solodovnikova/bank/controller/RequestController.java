package vsu.solodovnikova.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.solodovnikova.bank.data.dto.RequestCreateDto;
import vsu.solodovnikova.bank.data.dto.RequestDto;
import vsu.solodovnikova.bank.service.RequestService;

import java.util.List;

@RestController
@RequestMapping("/api/bank/request")
@AllArgsConstructor
public class RequestController {
    private RequestService requestService;

    @PostMapping
    public void addRequest(@RequestBody RequestCreateDto requestCreateDto){
        requestService.addRequest(requestCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<RequestDto>> getRequests(){
        return new ResponseEntity<>(requestService.getRequests(), HttpStatus.OK);
    }
}

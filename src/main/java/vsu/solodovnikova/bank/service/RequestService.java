package vsu.solodovnikova.bank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.solodovnikova.bank.data.dto.RequestCreateDto;
import vsu.solodovnikova.bank.data.dto.RequestDto;
import vsu.solodovnikova.bank.data.storage.RequestStorage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RequestService {
    private final RequestStorage requestStorage;

    @Transactional
    public void addRequest(RequestCreateDto requestCreateDto) {
        requestStorage.addRequest(requestCreateDto.getAccountNumber(), requestCreateDto.getClerkId(), requestCreateDto.getAmount(),
                requestCreateDto.getPercent(), requestCreateDto.getDate(), requestCreateDto.getPeriod());
    }

    @Transactional
    public List<RequestDto> getRequests() {
        return requestStorage.getRequests()
                .stream()
                .map(request -> new RequestDto(request.getId(), request.getAmount(), request.getPercent(),
                        request.getDate(), request.getPeriod()))
                .collect(Collectors.toList());
    }
}

package vsu.solodovnikova.bank.data.mapper;

import org.mapstruct.Mapper;
import vsu.solodovnikova.bank.data.dto.ClientChangeDto;
import vsu.solodovnikova.bank.data.dto.ClientCreateDto;
import vsu.solodovnikova.bank.data.dto.ClientDto;
import vsu.solodovnikova.bank.data.entity.ClientEntity;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(ClientEntity client);
    ClientEntity toEntity(ClientCreateDto clientCreateDto);
    ClientEntity toEntity(Integer id, ClientChangeDto clientChangeDto);

}

package vsu.solodovnikova.bank.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vsu.solodovnikova.bank.data.dto.AccountCreateDto;
import vsu.solodovnikova.bank.data.dto.AccountDto;
import vsu.solodovnikova.bank.data.entity.AccountEntity;
import vsu.solodovnikova.bank.data.entity.ClientEntity;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(source = "client.id", target = "clientId")
    AccountDto toDto(AccountEntity account);
    @Mapping(source = "client", target = "client")
    AccountEntity toEntity(AccountCreateDto accountCreateDto, ClientEntity client);
}

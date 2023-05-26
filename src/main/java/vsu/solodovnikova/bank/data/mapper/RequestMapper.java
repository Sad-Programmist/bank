package vsu.solodovnikova.bank.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vsu.solodovnikova.bank.data.dto.RequestCreateDto;
import vsu.solodovnikova.bank.data.dto.RequestDto;
import vsu.solodovnikova.bank.data.entity.AccountEntity;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;
import vsu.solodovnikova.bank.data.entity.RequestEntity;

@Mapper(componentModel = "spring")
public interface RequestMapper {
    @Mapping(source = "account.number", target = "accountNumber")
    @Mapping(source = "clerk.id", target = "clerkId")
    RequestDto toDto(RequestEntity request);
    @Mapping(source = "account", target = "account")
    @Mapping(source = "clerk", target = "clerk")
    RequestEntity toEntity(RequestCreateDto requestCreateDto, AccountEntity account, ClerkEntity clerk);
}

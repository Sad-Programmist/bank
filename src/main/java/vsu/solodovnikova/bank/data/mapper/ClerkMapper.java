package vsu.solodovnikova.bank.data.mapper;

import org.mapstruct.Mapper;
import vsu.solodovnikova.bank.data.dto.ClerkCreateDto;
import vsu.solodovnikova.bank.data.dto.ClerkDto;
import vsu.solodovnikova.bank.data.entity.ClerkEntity;

@Mapper(componentModel = "spring")
public interface ClerkMapper {
    ClerkDto toDto(ClerkEntity clerk);
    ClerkEntity toEntity(ClerkCreateDto clerkCreateDto);
}

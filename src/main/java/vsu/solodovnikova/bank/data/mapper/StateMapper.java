package vsu.solodovnikova.bank.data.mapper;

import org.mapstruct.Mapper;
import vsu.solodovnikova.bank.data.dto.StateDto;
import vsu.solodovnikova.bank.data.entity.StateEntity;

@Mapper(componentModel = "spring")
public interface StateMapper {
    StateDto toDto(StateEntity state);
}

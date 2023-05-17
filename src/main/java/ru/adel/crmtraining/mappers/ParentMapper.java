package ru.adel.crmtraining.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.adel.crmtraining.dto.GroupDTO;
import ru.adel.crmtraining.dto.ParentDTO;
import ru.adel.crmtraining.models.Group;
import ru.adel.crmtraining.models.Parent;

@Component
@AllArgsConstructor
public class ParentMapper {
    private final ModelMapper modelMapper;

    public ParentDTO toDTO(Parent parent){
        return modelMapper.map(parent,ParentDTO.class);
    }
    public Parent toEntity(ParentDTO parentDTO){
        return modelMapper.map(parentDTO , Parent.class);
    }
//    public void updateEntityFromDTO(ParentDTO parentDTO, Parent parent) {
//        modelMapper.map(parentDTO, parent);
//    }
}


package ru.adel.crmtraining.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.adel.crmtraining.dto.GroupDTO;
import ru.adel.crmtraining.models.Group;

@AllArgsConstructor
@Component
public class GroupMapper {
    private final ModelMapper modelMapper;

    public GroupDTO toDTO(Group group) {
        return modelMapper.map(group, GroupDTO.class);
    }

    public Group toEntity(GroupDTO groupDTO) {
        return modelMapper.map(groupDTO, Group.class);
    }

    public void updateEntityFromDTO(GroupDTO groupDTO, Group group) {
        modelMapper.map(groupDTO, group);
    }
}



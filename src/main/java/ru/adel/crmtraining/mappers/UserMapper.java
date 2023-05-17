package ru.adel.crmtraining.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.adel.crmtraining.dto.UserDTO;
import ru.adel.crmtraining.models.User;

@Component
@AllArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserDTO toDTO(User user){
        return modelMapper.map(user,UserDTO.class);

    }
    public User toEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
    public void updateEntityFromDTO(UserDTO userDTO, User user) {
        modelMapper.map(userDTO, user);
    }
}

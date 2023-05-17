package ru.adel.crmtraining.services;

import ru.adel.crmtraining.dto.UserDTO;
import ru.adel.crmtraining.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void updateUser(Long id,UserDTO userDTO);
    void deleteUser(Long userId);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long userId);
    UserDTO findUserByUsername(String username);

}

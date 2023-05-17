package ru.adel.crmtraining.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.adel.crmtraining.dto.UserDTO;
import ru.adel.crmtraining.mappers.UserMapper;
import ru.adel.crmtraining.models.User;
import ru.adel.crmtraining.repositories.UserRepository;
import ru.adel.crmtraining.services.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
        User updatedUser = userMapper.toEntity(userDTO);
        updatedUser.setId(existingUser.getId());
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Не существует пользователя с таким id : " + userId));
        return userMapper.toDTO(user);

    }

    @Override
    public UserDTO findUserByUsername(String username) throws EntityNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username: " + username));

        return userMapper.toDTO(user);
    }
}

package ru.adel.crmtraining.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.adel.crmtraining.dto.UserDTO;
import ru.adel.crmtraining.mappers.UserMapper;
import ru.adel.crmtraining.models.User;
import ru.adel.crmtraining.models.UserRole;
import ru.adel.crmtraining.repositories.UserRepository;
import ru.adel.crmtraining.services.RegistrationService;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void registerUser(UserDTO userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new RuntimeException("Пользователь с таким именем : "+ userDto.getUsername()+"  уже существует");
        }

        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(UserRole.TRAINER); // по умолчанию создаем тренера, можно изменить
        userRepository.save(user);
    }
}

package ru.adel.crmtraining.services.impl;

import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.adel.crmtraining.dto.GroupDTO;
import ru.adel.crmtraining.mappers.GroupMapper;
import ru.adel.crmtraining.models.Group;
import ru.adel.crmtraining.models.User;
import ru.adel.crmtraining.repositories.GroupRepository;
import ru.adel.crmtraining.repositories.UserRepository;
import ru.adel.crmtraining.services.GroupService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final UserRepository userRepository;

    @Override
    public void createGroup(GroupDTO groupDto) {
        Group group = groupMapper.toEntity(groupDto);
        groupRepository.save(group);
    }
    @Override
    public GroupDTO getGroupById(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Не существует группы с таким id : " + id));
        return groupMapper.toDTO(group);
    }
    @Override
    public List<GroupDTO> getAllGroups() {
        return groupRepository.findAll().stream()
                .map(groupMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public void updateGroup(Long id, GroupDTO groupDto) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Не существует группы с таким id : " + id));
        Group updatedGroup = groupMapper.toEntity(groupDto);
        updatedGroup.setId(group.getId());
        groupRepository.save(updatedGroup);
    }
    @Override
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);
    }
    @Override
    public GroupDTO findGroupByName(String name) {
        return groupRepository.findByName(name)
                .map(groupMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<GroupDTO> getGroupsByTrainer(Long trainerId) {
        User trainer = userRepository.findById(trainerId)
                .orElseThrow(() -> new EntityNotFoundException("Тренер не найден"));
        List<Group> groups = groupRepository.findGroupByTrainer(trainer);
        return groups.stream()
                .map(groupMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void assignTrainerToGroup(Long groupId, Long trainerId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException("Группа не найдена"));
        User trainer = userRepository.findById(trainerId)
                .orElseThrow(() -> new EntityNotFoundException("Тренер не найден"));
        group.setTrainer(trainer);
        groupRepository.save(group);

    }

    @Override
    public void removeTrainerFromGroup(Long groupId, Long trainerId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException("Группа не найдена"));
        group.setTrainer(null);
        groupRepository.save(group);

    }
}

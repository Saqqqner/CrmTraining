package ru.adel.crmtraining.services;

import ru.adel.crmtraining.dto.GroupDTO;

import java.util.List;

public interface GroupService {
        void createGroup(GroupDTO groupDto);

        GroupDTO getGroupById(Long id);

        void updateGroup(Long id, GroupDTO groupDTO);

        List<GroupDTO> getAllGroups();

        GroupDTO findGroupByName(String name);
        List<GroupDTO> getGroupsByTrainer(Long trainerId);

        void assignTrainerToGroup(Long groupId, Long trainerId);

        void removeTrainerFromGroup(Long groupId, Long trainerId);

        void deleteGroupById(Long groupId);
    }

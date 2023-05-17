package ru.adel.crmtraining.services;

import ru.adel.crmtraining.dto.ParentDTO;
import ru.adel.crmtraining.dto.ParticipantDTO;
import ru.adel.crmtraining.models.Group;
import ru.adel.crmtraining.models.Participant;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {
    ParticipantDTO getParticipantById(Long id);

    List<ParticipantDTO> getAllParticipants();

    void saveParticipant(ParticipantDTO participant);

    void deleteParticipantById(Long id);
    void updateParticipant(Long id,ParticipantDTO participant);

    Optional<ParticipantDTO> findByIdAndGroupId(Long id, Long groupId);

    List<ParticipantDTO> findByLastName(String lastName);

    List<ParticipantDTO> getAllParticipantsByGroupId(Long groupId);
    void addParentToParticipant(Long participantId, Long parentId);

    void removeParentFromParticipant(Long participantId, Long parentId);
}

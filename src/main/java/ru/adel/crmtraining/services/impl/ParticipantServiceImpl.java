package ru.adel.crmtraining.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.adel.crmtraining.dto.ParticipantDTO;
import ru.adel.crmtraining.mappers.ParticipantMapper;
import ru.adel.crmtraining.models.Group;
import ru.adel.crmtraining.models.Parent;
import ru.adel.crmtraining.models.Participant;
import ru.adel.crmtraining.repositories.ParentRepository;
import ru.adel.crmtraining.repositories.ParticipantRepository;
import ru.adel.crmtraining.services.ParticipantService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantMapper participantMapper;
    private final ParticipantRepository participantRepository;
    private final ParentRepository parentRepository;

    @Override
    public ParticipantDTO getParticipantById(Long id) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Ученик с таким Id : " + id + " не найден"));
        return participantMapper.toDTO(participant);
    }

    @Override
    public List<ParticipantDTO> getAllParticipants() {
        List<Participant> participants = participantRepository.findAll();
        return participants.stream()
                .map(participantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveParticipant(ParticipantDTO participantDTO) {
        Participant participant = participantMapper.toEntity(participantDTO);
        participantRepository.save(participant);

    }

    @Override
    public void deleteParticipantById(Long id) {
        participantRepository.deleteById(id);

    }

    @Override
    public void updateParticipant(Long id, ParticipantDTO participantDTO) {
        Participant existingParticipant = participantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ученик с таким Id : " + id + " не найден"));
        Participant updatedParticipant = participantMapper.toEntity(participantDTO);
        updatedParticipant.setId(existingParticipant.getId());
        participantRepository.save(updatedParticipant);
    }
    @Override
    public Optional<ParticipantDTO> findByIdAndGroupId(Long id, Long groupId) {
        return participantRepository.findByIdAndGroupId(id, groupId)
                .map(participantMapper::toDTO);
    }

    @Override
    public List<ParticipantDTO> findByLastName(String lastName) {
        return participantRepository.findByLastName(lastName)
                .stream().map(participantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ParticipantDTO> getAllParticipantsByGroupId(Long groupId) {
        return participantRepository.findAllByGroupId(groupId)
                .stream()
                .map(participantMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public void addParentToParticipant(Long participantId, Long parentId) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new EntityNotFoundException("Ученик с таким Id : " + participantId + " не найден"));
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Родитель с таким Id : " + parentId + " не найден"));

        parent.setParticipant(participant);
        participant.getParents().add(parent);
        participantRepository.save(participant);
    }

    @Override
    public void removeParentFromParticipant(Long participantId, Long parentId) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new EntityNotFoundException("Ученик с таким Id : " + participantId + " не найден"));

        participant.getParents().removeIf(parent -> parent.getId().equals(parentId));
        participantRepository.save(participant);
    }


}

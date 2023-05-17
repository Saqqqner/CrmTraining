package ru.adel.crmtraining.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.adel.crmtraining.dto.ParticipantDTO;
import ru.adel.crmtraining.models.Participant;

@Component
@AllArgsConstructor
public class ParticipantMapper {
    private final ModelMapper modelMapper;


    public ParticipantDTO toDTO(Participant participant) {
        return modelMapper.map(participant, ParticipantDTO.class);
    }

    public Participant toEntity(ParticipantDTO participantDto) {
        return modelMapper.map(participantDto, Participant.class);
    }
    public void updateEntityFromDTO(ParticipantDTO participantDto, Participant participant) {
        modelMapper.map(participantDto, participant);
    }
}


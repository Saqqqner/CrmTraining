package ru.adel.crmtraining.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.adel.crmtraining.dto.TrainingDTO;
import ru.adel.crmtraining.models.Training;

@Component
@AllArgsConstructor
public class TrainingMapper {
    private final ModelMapper modelMapper;

    public TrainingDTO toDTO(Training training){
        return modelMapper.map(training , TrainingDTO.class);

    }

    public Training toEntity(TrainingDTO trainingDTO ){
        return modelMapper.map(trainingDTO , Training.class);
    }
}

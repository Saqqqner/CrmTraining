package ru.adel.crmtraining.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParticipantDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private Long groupId;
    private List<ParentDTO> parents;

}

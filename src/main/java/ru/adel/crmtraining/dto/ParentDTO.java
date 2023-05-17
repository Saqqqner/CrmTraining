package ru.adel.crmtraining.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParentDTO {
    private Long id;
    private String firstName;
    private String lastName;
}

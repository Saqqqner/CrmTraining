package ru.adel.crmtraining.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "Имя родителя не должно быть пустым")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Фамилия родителя не должно быть пустым")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

}
package ru.adel.crmtraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.adel.crmtraining.models.Group;
import ru.adel.crmtraining.models.Participant;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant , Long> {
    Optional<Participant> findByIdAndGroupId(Long id, Long groupId);

    List<Participant> findByLastName(String lastName);

    List<Participant> findAllByGroupId(Long groupId);
}

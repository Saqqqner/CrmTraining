package ru.adel.crmtraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.adel.crmtraining.dto.GroupDTO;
import ru.adel.crmtraining.models.Group;
import ru.adel.crmtraining.models.Participant;
import ru.adel.crmtraining.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group , Long> {
    Optional<Group> findByName(String name);
    List<Group> findGroupByTrainer(User trainer);
}

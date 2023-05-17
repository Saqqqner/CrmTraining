package ru.adel.crmtraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.adel.crmtraining.models.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training , Long> {
}

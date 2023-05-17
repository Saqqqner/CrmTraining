package ru.adel.crmtraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.adel.crmtraining.models.Parent;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
    List<Parent> findByLastName(String lastName);
}

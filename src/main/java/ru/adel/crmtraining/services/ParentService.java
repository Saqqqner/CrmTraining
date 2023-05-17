package ru.adel.crmtraining.services;

import ru.adel.crmtraining.dto.ParentDTO;

import java.util.List;

public interface ParentService {


    ParentDTO getParentById(Long id);

    List<ParentDTO> getAllParents();

    void createParent(ParentDTO parentDTO);

    void updateParent(Long id, ParentDTO parentDTO);

    void deleteParentById(Long id);

    List<ParentDTO> getParentByLastName(String lastname);
}

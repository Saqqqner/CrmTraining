package ru.adel.crmtraining.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.adel.crmtraining.dto.ParentDTO;
import ru.adel.crmtraining.mappers.ParentMapper;
import ru.adel.crmtraining.models.Parent;
import ru.adel.crmtraining.repositories.ParentRepository;
import ru.adel.crmtraining.services.ParentService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentMapper parentMapper;
    private final ParentRepository parentRepository;

    @Override
    public ParentDTO getParentById(Long id) {
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Родитель с таким Id : " + id + " не найден"));
        return parentMapper.toDTO(parent);
    }

    @Override
    public List<ParentDTO> getAllParents() {
        List<Parent> parents = parentRepository.findAll();
        return parents.stream()
                .map(parentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createParent(ParentDTO parentDTO) {
        Parent parent = parentMapper.toEntity(parentDTO);
        parentRepository.save(parent);
    }

    @Override
    public void updateParent(Long id, ParentDTO parentDTO) {
        Parent existingParent = parentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Родитель с таким Id : " + id + " не найден"));
        Parent updatedParent = parentMapper.toEntity(parentDTO);
        updatedParent.setId(existingParent.getId());
        parentRepository.save(updatedParent);
    }

    @Override
    public void deleteParentById(Long id) {
        parentRepository.deleteById(id);
    }

    @Override
    public List<ParentDTO> getParentByLastName(String lastname) {
        return parentRepository.findByLastName(lastname)
                .stream()
                .map(parentMapper::toDTO)
                .collect(Collectors.toList());
    }
}

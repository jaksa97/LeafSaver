package com.github.jaksa97.LeafSaver.service;

import com.github.jaksa97.LeafSaver.exception.ErrorInfo;
import com.github.jaksa97.LeafSaver.exception.ResourceNotFoundException;
import com.github.jaksa97.LeafSaver.exception.UniqueViolationException;
import com.github.jaksa97.LeafSaver.model.api.cure.CureDto;
import com.github.jaksa97.LeafSaver.model.api.cure.CureSaveDto;
import com.github.jaksa97.LeafSaver.model.api.cure.CureSearchOptions;
import com.github.jaksa97.LeafSaver.model.entity.CureEntity;
import com.github.jaksa97.LeafSaver.model.entity.DiseaseEntity;
import com.github.jaksa97.LeafSaver.model.entity.DrugEntity;
import com.github.jaksa97.LeafSaver.model.mapper.CureMapper;
import com.github.jaksa97.LeafSaver.repository.CureRepository;
import com.github.jaksa97.LeafSaver.repository.DiseaseRepository;
import com.github.jaksa97.LeafSaver.repository.DrugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CureService {

    private final CureRepository _cureRepository;

    private final DrugRepository _drugRepository;

    private final DiseaseRepository _diseaseRepository;

    private final CureMapper _cureMapper;

    public CureDto getOne(int id) throws ResourceNotFoundException {
        CureEntity cureEntity = _cureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorInfo.ResourceType.CURE));

        return _cureMapper.toDto(cureEntity);
    }

    public Page<CureDto> getAll(CureSearchOptions cureSearchOptions) {
        int page = 0;
        if (cureSearchOptions.getPage() != null && cureSearchOptions.getPage() >= 0) {
            page = cureSearchOptions.getPage() - 1;
        }

        int pageSize = 10;
        if (cureSearchOptions.getPageSize() != null && cureSearchOptions.getPageSize() >= 0) {
            pageSize = cureSearchOptions.getPageSize();
        }

        return _cureRepository.findAll(PageRequest.of(page, pageSize)).map(_cureMapper::toDto);
    }

    public List<CureDto> getAllByDrugId(int drugId) throws ResourceNotFoundException {
        if (!_drugRepository.existsById(drugId)) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG);
        }
        if (_cureRepository.findAllByDrugId(drugId).isEmpty()) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.CURE);
        }
        return _cureRepository.findAllByDrugId(drugId).stream().map(_cureMapper::toDto).collect(Collectors.toList());
    }

    public List<CureDto> getAllByDiseaseId(int diseaseId) throws ResourceNotFoundException {
        if (!_diseaseRepository.existsById(diseaseId)) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE);
        }
        if (_cureRepository.findAllByDiseaseId(diseaseId).isEmpty()) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.CURE);
        }
        return _cureRepository.findAllByDiseaseId(diseaseId).stream().map(_cureMapper::toDto).collect(Collectors.toList());
    }

    public CureDto save(CureSaveDto cureSaveDto) throws ResourceNotFoundException, UniqueViolationException {
        if (!_drugRepository.existsById(cureSaveDto.getDrugId())) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG);
        }
        if (!_diseaseRepository.existsById(cureSaveDto.getDiseaseId())) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE);
        }

        if (checkCure(cureSaveDto.getDrugId(), cureSaveDto.getDiseaseId())) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.CURE, "Cure already exists");
        }

        CureEntity cureEntity = _cureMapper.toEntity(cureSaveDto);
        DrugEntity drugEntity = _drugRepository.findById(cureSaveDto.getDrugId())
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG, "Drug with id '" + cureSaveDto.getDrugId() + "' don't exist"));
        DiseaseEntity diseaseEntity = _diseaseRepository.findById(cureSaveDto.getDiseaseId())
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE, "Disease with id '" + cureSaveDto.getDiseaseId() + "' don't exist"));

        cureEntity.setDrug(drugEntity);
        cureEntity.setDisease(diseaseEntity);

        return _cureMapper.toDto(_cureRepository.save(cureEntity));
    }

    public CureDto update(int id, CureSaveDto updatedCure) throws ResourceNotFoundException, UniqueViolationException {
        CureEntity originalCureEntity = _cureRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.CURE));

        if (!(originalCureEntity.getDisease().getId() == updatedCure.getDiseaseId()) && !(originalCureEntity.getDrug().getId() == updatedCure.getDrugId()) && checkCure(updatedCure.getDrugId(), updatedCure.getDiseaseId())) {
            throw new UniqueViolationException(ErrorInfo.ResourceType.CURE, "Cure already exists");
        }

        CureEntity cureEntity = _cureMapper.toEntity(updatedCure);
        DrugEntity drugEntity = _drugRepository.findById(updatedCure.getDrugId())
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DRUG, "Drug with id '" + updatedCure.getDrugId() + "' don't exist"));
        DiseaseEntity diseaseEntity = _diseaseRepository.findById(updatedCure.getDiseaseId())
                .orElseThrow( () -> new ResourceNotFoundException(ErrorInfo.ResourceType.DISEASE, "Disease with id '" + updatedCure.getDiseaseId() + "' don't exist"));

        cureEntity.setDrug(drugEntity);
        cureEntity.setDisease(diseaseEntity);

        cureEntity.setId(id);

        _cureRepository.save(cureEntity);

        return _cureMapper.toDto(cureEntity);

    }

    public void remove(int id) throws ResourceNotFoundException {
        if (!_cureRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorInfo.ResourceType.CURE);
        }

        _cureRepository.deleteById(id);
    }

    private Boolean checkCure(int drugId, int diseaseId) {
        List<CureEntity> cureEntitiesByDrugId = _cureRepository.findAllByDrugId(drugId);

        if (!cureEntitiesByDrugId.isEmpty()) {
            for (CureEntity cure: cureEntitiesByDrugId) {
                if (cure.getDisease().getId() == diseaseId) {
                    return true;
                }
            }
        }

        return false;
    }
}

package com.github.jaksa97.LeafSaver.repository.specification;

import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseSearchOptions;
import com.github.jaksa97.LeafSaver.model.entity.DiseaseEntity;
import com.github.jaksa97.LeafSaver.model.entity.DiseaseEntity_;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DiseaseSearchSpecification implements Specification<DiseaseEntity> {
    private final DiseaseSearchOptions _diseaseSearchOptions;

    @Override
    public Predicate toPredicate(Root<DiseaseEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        Path<String> name = root.get(DiseaseEntity_.name);
        Path<String> niceName = root.get(DiseaseEntity_.niceName);

        DiseaseSearchOptions.SortByField sortBy = _diseaseSearchOptions.getSortBy();
        if (sortBy != null) {
            Path<?> propertyToSortBy = null;

            switch (sortBy) {
                case name:
                    propertyToSortBy = name;
                    break;
                case niceName:
                    propertyToSortBy = niceName;
                    break;
            }

            Sort.Direction direction = _diseaseSearchOptions.getSortDirection();
            if (direction == null || direction.isAscending()) {
                query.orderBy(criteriaBuilder.asc(propertyToSortBy));
            } else {
                query.orderBy(criteriaBuilder.desc(propertyToSortBy));
            }
        }

        if (_diseaseSearchOptions.getName() != null) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(name),
                    "%" + _diseaseSearchOptions.getName().toLowerCase() + "%"));
        }

        if (_diseaseSearchOptions.getNiceName() != null) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(niceName),
                    "%" + _diseaseSearchOptions.getNiceName().toLowerCase() + "%"));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}

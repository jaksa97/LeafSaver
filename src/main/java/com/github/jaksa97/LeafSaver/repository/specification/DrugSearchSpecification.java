package com.github.jaksa97.LeafSaver.repository.specification;

import com.github.jaksa97.LeafSaver.model.api.drug.DrugSearchOptions;
import com.github.jaksa97.LeafSaver.model.entity.DrugEntity;
import com.github.jaksa97.LeafSaver.model.entity.DrugEntity_;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DrugSearchSpecification implements Specification<DrugEntity> {
    private final DrugSearchOptions _drugSearchOptions;

    @Override
    public Predicate toPredicate(Root<DrugEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        Path<String> name = root.get(DrugEntity_.name);

        DrugSearchOptions.SortByField sortBy = _drugSearchOptions.getSortBy();
        if (sortBy != null) {
            Path<?> propertyToSortBy = null;

            switch (sortBy) {
                case name:
                    propertyToSortBy = name;
                    break;
            }

            Sort.Direction direction = _drugSearchOptions.getSortDirection();
            if (direction == null || direction.isAscending()) {
                query.orderBy(criteriaBuilder.asc(propertyToSortBy));
            } else {
                query.orderBy(criteriaBuilder.desc(propertyToSortBy));
            }
        }

        if (_drugSearchOptions.getName() != null) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(name),
                    "%" + _drugSearchOptions.getName().toLowerCase() + "%"));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}

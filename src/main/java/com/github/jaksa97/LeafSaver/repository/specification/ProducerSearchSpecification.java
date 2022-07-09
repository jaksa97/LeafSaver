package com.github.jaksa97.LeafSaver.repository.specification;

import com.github.jaksa97.LeafSaver.model.api.producer.ProducerSearchOptions;
import com.github.jaksa97.LeafSaver.model.entity.ProducerEntity;
import com.github.jaksa97.LeafSaver.model.entity.ProducerEntity_;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ProducerSearchSpecification implements Specification<ProducerEntity> {
    private final ProducerSearchOptions _producerSearchOptions;

    @Override
    public Predicate toPredicate(Root<ProducerEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        Path<String> name = root.get(ProducerEntity_.name);

        ProducerSearchOptions.SortByField sortBy = _producerSearchOptions.getSortBy();
        if (sortBy != null) {
            Path<?> propertyToSortBy = null;

            switch (sortBy) {
                case name:
                    propertyToSortBy = name;
                    break;
            }

            Sort.Direction direction = _producerSearchOptions.getSortDirection();
            if (direction == null || direction.isAscending()) {
                query.orderBy(criteriaBuilder.asc(propertyToSortBy));
            } else {
                query.orderBy(criteriaBuilder.desc(propertyToSortBy));
            }
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}

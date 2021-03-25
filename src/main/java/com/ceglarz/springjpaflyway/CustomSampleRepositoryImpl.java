package com.ceglarz.springjpaflyway;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@RequiredArgsConstructor
public class CustomSampleRepositoryImpl implements CustomSampleRepository {

    private final EntityManager entityManager;

    @Override
    public List<Sample> findCustom(String name) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sample> builderQuery = criteriaBuilder.createQuery(Sample.class);

        Root<Sample> entity = builderQuery.from(Sample.class);
        Predicate namePredicate = criteriaBuilder.equal(entity.get("name"), name);
        builderQuery.where(namePredicate);

        TypedQuery<Sample> query = entityManager.createQuery(builderQuery);
        return query.getResultList();
    }
}

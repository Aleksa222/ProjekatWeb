package com.Projekat.Dostava.dao;

import com.Projekat.Dostava.dto.RestoranPrikazDto;
import com.Projekat.Dostava.entity.Komentar;
import com.Projekat.Dostava.entity.Restoran;
import com.Projekat.Dostava.repository.KomentarRepository;
import com.Projekat.Dostava.util.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestoranDAO implements  IRestoranDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private KomentarRepository komentarRepository;

    @Override
    public List<RestoranPrikazDto> search(final List<SearchCriteria> params) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Restoran> query = builder.createQuery(Restoran.class);
        final Root r = query.from(Restoran.class);

        Predicate predicate = builder.conjunction();
        RestoranSearchQueryCriteriaConsumer searchConsumer = new RestoranSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        List<RestoranPrikazDto> list = new ArrayList<>();

        List<Komentar> komentari = new ArrayList<>();

        for(Restoran restoran : entityManager.createQuery(query).getResultList()){
            komentari = komentarRepository.getByRestoran(restoran).get();
            list.add(new RestoranPrikazDto(restoran, komentari));

        }
        return list;
    }

    @Override
    public void save(final Restoran entity) {
        entityManager.persist(entity); }
}

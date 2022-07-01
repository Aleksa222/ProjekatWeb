package com.Projekat.Dostava.dao;

import com.Projekat.Dostava.dto.RestoranPrikazDto;
import com.Projekat.Dostava.entity.Restoran;
import com.Projekat.Dostava.util.SearchCriteria;

import java.util.List;

public interface IRestoranDAO {
    List<RestoranPrikazDto> search(List<SearchCriteria> params);

    void save(Restoran entity);
}

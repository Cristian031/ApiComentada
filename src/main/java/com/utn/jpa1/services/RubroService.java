package com.utn.jpa1.services;

import com.utn.jpa1.entities.Rubro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RubroService extends BaseService<Rubro, Long> {
    List<Rubro> search(String filtro) throws Exception;
    Page<Rubro> search(String filtro, Pageable pageable) throws Exception;

}

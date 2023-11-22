package com.utn.jpa1.services;

import com.utn.jpa1.entities.EmpleadoEntity;
import com.utn.jpa1.repositories.EmpleadoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService extends BaseService<EmpleadoEntity, Long> {
    List<EmpleadoEntity> search(String filtro) throws Exception;
    Page<EmpleadoEntity> search(String filtro, Pageable pageable) throws Exception;
}

package com.utn.jpa1.services;

import com.utn.jpa1.entities.ClienteEntity;
import com.utn.jpa1.repositories.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService extends BaseService<ClienteEntity, Long> {
    List<ClienteEntity> search(String filtro) throws Exception;
    Page<ClienteEntity> search(String filtro, Pageable pageable) throws Exception;
}

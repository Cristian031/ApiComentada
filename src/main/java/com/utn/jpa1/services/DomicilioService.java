package com.utn.jpa1.services;

import com.utn.jpa1.entities.DetallePedido;
import com.utn.jpa1.entities.DomicilioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService extends BaseService<DomicilioEntity, Long>{
    List<DomicilioEntity> search(String filtro) throws Exception;
    Page<DomicilioEntity> search(String filtro, Pageable pageable) throws Exception;
}

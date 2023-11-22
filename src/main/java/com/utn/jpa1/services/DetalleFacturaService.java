package com.utn.jpa1.services;

import com.utn.jpa1.entities.DetalleArticuloManufacturado;
import com.utn.jpa1.entities.DetalleFacturaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleFacturaService extends BaseService<DetalleFacturaEntity, Long>{
    List<DetalleFacturaEntity> search(String filtro) throws Exception;
    Page<DetalleFacturaEntity> search(String filtro, Pageable pageable) throws Exception;
}

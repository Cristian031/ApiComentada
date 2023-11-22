package com.utn.jpa1.services;

import com.utn.jpa1.entities.ClienteEntity;
import com.utn.jpa1.entities.DetalleArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleArticuloManufacturadoService extends BaseService<DetalleArticuloManufacturado, Long> {
    List<DetalleArticuloManufacturado> search(String filtro) throws Exception;
    Page<DetalleArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception;
}

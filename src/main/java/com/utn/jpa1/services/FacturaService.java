package com.utn.jpa1.services;

import com.utn.jpa1.entities.EmpleadoEntity;
import com.utn.jpa1.entities.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacturaService extends BaseService<Factura, Long> {
    List<Factura> search(String filtro) throws Exception;
    Page<Factura> search(String filtro, Pageable pageable) throws Exception;
}

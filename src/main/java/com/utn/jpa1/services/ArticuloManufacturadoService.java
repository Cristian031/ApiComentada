package com.utn.jpa1.services;

import com.utn.jpa1.entities.ArticuloManufacturadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturadoEntity, Long> {
    List<ArticuloManufacturadoEntity> search(String string) throws Exception;

    Page<ArticuloManufacturadoEntity> search(String string, Pageable pageable) throws Exception;

    List<ArticuloManufacturadoEntity> searchByTipo(String string) throws Exception;
}

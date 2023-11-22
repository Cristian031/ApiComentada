package com.utn.jpa1.repositories;

import com.utn.jpa1.entities.ArticuloManufacturadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturadoEntity, Long> {

    @Query(value = "SELECT a FROM ArticuloManufacturadoEntity a WHERE a.denominacion LIKE %:filtro%")
    List<ArticuloManufacturadoEntity> search(@Param("filtro") String filtro);



}
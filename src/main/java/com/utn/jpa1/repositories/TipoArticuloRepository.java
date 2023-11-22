package com.utn.jpa1.repositories;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.utn.jpa1.entities.TipoArticulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoArticuloRepository extends BaseRepository<TipoArticulo, Long> {
    @Query(value = "SELECT t FROM TipoArticulo t WHERE t.nombreCategoria LIKE %:filtro%")
    TipoArticulo searchTipo(@Param("filtro") String filtro);
}

package com.utn.jpa1.repositories;

import com.utn.jpa1.entities.DomicilioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DomicilioRepository extends BaseRepository<DomicilioEntity, Long> {
    @Query(value = "SELECT d FROM DomicilioEntity d WHERE d.calle LIKE %:filtro% AND d.numero = cast(:filtro2 as int)")
    DomicilioEntity search(@Param("filtro") String filtro, int filtro2);

}

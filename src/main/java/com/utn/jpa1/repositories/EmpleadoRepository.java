package com.utn.jpa1.repositories;

import com.utn.jpa1.entities.EmpleadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends BaseRepository<EmpleadoEntity, Long> {
    List<EmpleadoEntity> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<EmpleadoEntity> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);
    boolean existsByDni(@Param("dni") Integer dni);
    @Query(value = "SELECT e FROM EmpleadoEntity e WHERE e.nombre LIKE %:filtro% OR e.apellido LIKE %:filtro%")
    List<EmpleadoEntity> search(@Param("filtro") String filtro);
    @Query(value = "SELECT e FROM EmpleadoEntity e WHERE e.nombre LIKE %:filtro% OR e.apellido LIKE %:filtro%")
    Page<EmpleadoEntity> search(@Param("filtro") String filtro, Pageable pageable);
}

package com.utn.jpa1.repositories;

import com.utn.jpa1.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepositorio extends BaseRepository <Factura, Long> {
}

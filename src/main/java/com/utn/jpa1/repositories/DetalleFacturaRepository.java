package com.utn.jpa1.repositories;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.utn.jpa1.entities.DetalleFacturaEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends BaseRepository<DetalleFacturaEntity, Long> {
}

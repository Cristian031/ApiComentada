package com.utn.jpa1.repositories;

import com.utn.jpa1.entities.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {
    @Query(
            value = "SELECT * FROM ARTICULO_INSUMO ai ORDER BY ai.STOCK_MINIMO - ai.STOCK_ACTUAL  DESC",
            nativeQuery = true)
    Page<ArticuloInsumo> searchStock(Pageable pageable);
}

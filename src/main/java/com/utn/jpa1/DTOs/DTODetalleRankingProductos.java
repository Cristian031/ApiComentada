package com.utn.jpa1.DTOs;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTODetalleRankingProductos {
    private int cantidad;
    private String nombreArticulo;
}

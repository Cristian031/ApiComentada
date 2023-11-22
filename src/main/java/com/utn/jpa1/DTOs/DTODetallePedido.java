package com.utn.jpa1.DTOs;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTODetallePedido {

    private Integer cantidad;
    private Long id_ArticuloManufacturado;
}

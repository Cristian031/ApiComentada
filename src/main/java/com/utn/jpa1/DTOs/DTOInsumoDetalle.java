package com.utn.jpa1.DTOs;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOInsumoDetalle {
    private int cantidad;
    private Long articuloInsumoId;
}

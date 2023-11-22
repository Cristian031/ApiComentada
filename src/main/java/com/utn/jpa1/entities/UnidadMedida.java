package com.utn.jpa1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "unidad_medida")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UnidadMedida extends BaseDate{
    @Column(name = "abreviatura")
    private String abreviatura;
    @Column(name = "denominacion")
    private String denominacion;
}

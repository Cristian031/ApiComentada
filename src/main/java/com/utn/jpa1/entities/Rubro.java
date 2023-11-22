package com.utn.jpa1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Rubro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
    public class Rubro extends BaseDate {

        @Column(name = "Denominacion")
        private String denominacion;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        @JoinColumn(name = "rubro_id")
        private List<ArticuloManufacturadoEntity> articuloManufacturadoEntities = new ArrayList<ArticuloManufacturadoEntity>();

    }



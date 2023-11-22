package com.utn.jpa1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utn.jpa1.ennumerations.EstadoBasico;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ArticuloManufacturado")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class ArticuloManufacturadoEntity extends BaseDate {

    @Column(name = "TiempoEstimadoCocina")
    private Integer tiempoEstimadoCocina;
    @Column(name = "Denominacion")
    private String denominacion;
    @Column(name = "PrecioVenta")
    private BigDecimal precioVenta;
    @Column(name = "Receta")
    private String receta;
    @Column(name = "costo")
    private BigDecimal costo;
    @Column(name = "url_imagen")
    private String urlImagen;

    @OneToMany(mappedBy = "articuloManufacturado")
    @JsonIgnore
    private List<DetalleArticuloManufacturado> detallesArticuloManufacturado = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "id_tipoArticulo")
    private TipoArticulo tipoArticulo;

    private EstadoBasico estado;
    public void addDetalleArticuloManufacturado (DetalleArticuloManufacturado detalleArticuloManufacturado){
        detallesArticuloManufacturado.add(detalleArticuloManufacturado);
    }

}

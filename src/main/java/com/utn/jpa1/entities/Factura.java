package com.utn.jpa1.entities;

import com.utn.jpa1.ennumerations.FormadePago;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Pedido")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Factura extends BaseDate {

    @Column(name = "fecha_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    private FormadePago formadePago;

    @Column(name = "total_venta", precision = 10, scale = 2)
    private BigDecimal totalVenta;

    @OneToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    private Pedido pedido;

    @OneToMany(mappedBy = "factura")
    private List<DetalleFacturaEntity> detallesFactura = new ArrayList<>();

    public void addDetallesFactura(DetalleFacturaEntity detalleFactura){
        detallesFactura.add(detalleFactura);
    }

}

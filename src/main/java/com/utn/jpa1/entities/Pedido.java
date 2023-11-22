package com.utn.jpa1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utn.jpa1.ennumerations.EstadoPedido;
import com.utn.jpa1.ennumerations.FormadePago;
import com.utn.jpa1.ennumerations.TipoEnvio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Pedido extends BaseDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "desc_aplicado")
    private Double descAplicado;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "formadePago")
    @Enumerated(EnumType.STRING)
    private FormadePago formadePago;

    @Column(name = "tipo_envio")
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @NotNull
    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "id_domicilio_entrega")
    private DomicilioEntity domicilio;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;


    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detallesPedido;

    public void addDetallesPedido(DetallePedido detallePedido){
        detallesPedido.add(detallePedido);
    }

    public void setDetallesPedido(List<DetallePedido> detalles){this.detallesPedido = detalles;}

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonIgnore
    private Factura factura;

}

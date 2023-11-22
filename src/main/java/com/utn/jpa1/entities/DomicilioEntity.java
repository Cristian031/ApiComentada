package com.utn.jpa1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "domicilio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DomicilioEntity extends BaseDate {

    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "numeroDpto")
    private Integer numeroDpto;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "codigoPostal")
    private Integer codigoPostal;
    @Column(name = "pisoDpto")
    private Integer pisoDpto;

    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @OneToMany(mappedBy="domicilio")
    private List<Pedido> pedidos;

    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }


}

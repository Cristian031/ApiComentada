package com.utn.jpa1.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utn.jpa1.ennumerations.Rol;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder

@Setter
public class ClienteEntity extends BaseDate {

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    public Rol rol;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy="cliente")
    private List<DomicilioEntity> domicilios = new ArrayList<>();

    //AGREGAR AL DIAGRAMA
    @OneToMany(mappedBy="cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    public void addPedido(Pedido pedido){pedidos.add(pedido);}
    public void addDomicilio(DomicilioEntity domicilio){
        domicilios.add(domicilio);
    }
}
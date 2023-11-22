package com.utn.jpa1.entities;


import com.utn.jpa1.ennumerations.RolEmpleado;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity  //Con esta etiqueta indico a la unidad de persistencia que esta entidad se debe guardar en la bd
@Table(name = "empleado")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class EmpleadoEntity extends BaseDate  {

    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Dni")
    private Integer dni;
    @Column(name = "Rol")
    @Enumerated
    private RolEmpleado rolEmpleado;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "empleado_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<Pedido>();

}
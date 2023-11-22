package com.utn.jpa1.DTOs;

import com.utn.jpa1.ennumerations.EstadoPedido;
import com.utn.jpa1.entities.Pedido;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOMostrarPedidos {
    public List<Pedido> pedidos = new ArrayList<>();
    //pedido.getElementById
    private EstadoPedido estadoPedido;

}

package com.utn.jpa1.DTOs;

import com.utn.jpa1.ennumerations.FormadePago;
import com.utn.jpa1.ennumerations.TipoEnvio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOCrearPedido {
    private List<DTODetallePedido> articulos = new ArrayList<>();
    private TipoEnvio tipoEnvio;
    private FormadePago formadePago;
    private String domicilioCalle;
    private int domicilioNumero;
    private String username;

    public  void setArticulos(List<DTODetallePedido> articulos){
        this.articulos = articulos;
    }
}

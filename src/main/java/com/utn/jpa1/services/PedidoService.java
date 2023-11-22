package com.utn.jpa1.services;

import com.utn.jpa1.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{
    Page<Pedido> buscarCliente(Long idCliente, Pageable pageable) throws Exception;
    List<Pedido> buscarCliente(Long idCliente) throws Exception;
}

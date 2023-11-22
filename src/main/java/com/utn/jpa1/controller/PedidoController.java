package com.utn.jpa1.controller;

import com.utn.jpa1.DTOs.DTOCrearPedido;
import com.utn.jpa1.entities.Pedido;
import com.utn.jpa1.services.PedidoServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {

    @GetMapping("/buscarCliente")
    public ResponseEntity<?> buscar(@RequestParam Long idCliente){
        try {
            return ResponseEntity.status(HttpStatus.OK).body((servicio.buscarCliente(idCliente)));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/buscarPedidoCocina")
    public ResponseEntity<?> buscarPedidoCocina(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPedidoCocina());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @PostMapping("/createPedido")
    public ResponseEntity<?> createCarrito(@RequestBody DTOCrearPedido dtoPedido){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.savePedido(dtoPedido));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/rankingProductos")
    public ResponseEntity<?> rankingProductos(@RequestParam String date1, String date2){
        try{
            System.out.println("adentro del controller");
            return ResponseEntity.status(HttpStatus.OK).body(servicio.rankingProductos(date1, date2));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}

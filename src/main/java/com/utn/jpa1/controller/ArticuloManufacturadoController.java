package com.utn.jpa1.controller;

import com.utn.jpa1.ennumerations.EstadoBasico;
import com.utn.jpa1.entities.ArticuloManufacturadoEntity;
import com.utn.jpa1.services.ArticuloManufacturadoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/v1/articuloManufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturadoEntity, ArticuloManufacturadoServiceImpl> {
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try{
            System.out.println("sas\n\n\n");
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchByTipo")
    public ResponseEntity<?> searchByTipo(@RequestParam String filtro){
        try{
//            System.out.println("searchByTipo\n\n\n");
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByTipo(filtro));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @PutMapping("/cambiarEstado")
    public ResponseEntity<?> cambiarEstado(@RequestParam Long artId, EstadoBasico estadoRubro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarEstado(artId, estadoRubro));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}

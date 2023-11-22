package com.utn.jpa1.controller;
import com.utn.jpa1.ennumerations.Rol;
import com.utn.jpa1.entities.Usuario;
import com.utn.jpa1.services.UsuarioServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }


    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/exist")
    public ResponseEntity<?> existeUsuario(@RequestParam String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.existeUsuario(username));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/sign_in")
    public ResponseEntity<?> altaUsuarioForm(@RequestParam String Email, String Clave, Rol Rol) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.altaUsuarioForm(Email, Clave, Rol));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/admin_user_sign_in")
    public ResponseEntity<?> adminAltaUsuarioForm(@RequestParam String Email, String Clave, Rol Rol) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.altaUsuarioForm( Email, Clave, Rol));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/log_in")
    public ResponseEntity<?> loginUsuario(@RequestParam String Email, String Clave) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.log_in(Email, Clave));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/admin_user_delete")
    public ResponseEntity<?> adminBajaUsuario(@RequestParam String Email, String Clave, Rol Rol) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.bajaUsuario( Email));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/admin_user_modify")
    public ResponseEntity<?> adminModifUsuario(@RequestParam Boolean activo, Date fecha_alta, Date fecha_baja, Date fecha_mod, String password,Rol rol, String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.adminModifUsuario(activo, fecha_alta, fecha_baja, fecha_mod, password, rol, username));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/user_modify")
    public ResponseEntity<?> modifUsuario(@RequestParam Boolean activo, Date fecha_alta, Date fecha_baja, Date fecha_mod, String password, String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.modifUsuario(activo, fecha_alta, fecha_baja, fecha_mod, password, username));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
/* ME FALTA HACER LOS UPDATES NOMAS
EL UPDATE USUARIO
EL UPDATE USUARIO POR EL ADMIN -- ES BAJA Y ES MODIFIACION
    @GetMapping("/exist")
    public ResponseEntity<?> existeUsuario(@RequestParam String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.existeUsuario(username));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/exist")
    public ResponseEntity<?> existeUsuario(@RequestParam String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.existeUsuario(username));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    */
}

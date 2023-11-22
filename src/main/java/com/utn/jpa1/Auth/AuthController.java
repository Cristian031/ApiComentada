package com.utn.jpa1.Auth; //importa las clases y anotaciones necesarias de Spring Framework, como RestController, RequestMapping, PostMapping, RequestBody, ResponseEntity

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //controlador de springBoot gestiona solicitudes relacionadas con la autenticacion  y registro de user.
@RequestMapping("/auth") //Esta anotación especifica que todas las solicitudes a este controlador deben comenzar con el prefijo /auth
@RequiredArgsConstructor //: Esta anotación es parte de Lombok y se utiliza para generar un constructor que inyecta automáticamente los campos marcados como final.
@CrossOrigin(origins = "*") //permite el acceso a este controlador desde cualquier dominio.
public class AuthController {

    private final AuthService authService;
    @PostMapping(value = "login") //Este controlador define  endpoints para manejar las solicitudes de inicio de sesión (/auth/login)
    // y registro de usuarios (/auth/register). Estas solicitudes se procesan a través de métodos
    // que interactúan con un servicio de autenticación (AuthService).

    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }
    //Toma un objeto LoginRequest en el cuerpo de la solicitud (@RequestBody) y devuelve una respuesta ResponseEntity
    // que contiene un objeto AuthResponse, el cual es devuelto por el método authService.login(request

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}

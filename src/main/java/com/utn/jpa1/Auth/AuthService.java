package com.utn.jpa1.Auth;

import com.utn.jpa1.Jwt.JwtService;
import com.utn.jpa1.ennumerations.Rol;
import com.utn.jpa1.entities.Usuario;
import com.utn.jpa1.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;//representa un repo que interactua con la BD para operaciones relacionadas al user
    private final JwtService jwtService; //servicio encargado de generar y gestionar token
    private final PasswordEncoder passwordEncoder; //componente proporciona funcionalidad para el cifrado y descifrado de password.
    private final AuthenticationManager authenticationManager; //Gestiona la autenticacion de usuarios.
    public AuthResponse login(LoginRequest request) { //maneja la logica de inicio se sesion
        authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())));
        UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token).build();
    }

    //Autentica al usuario utilizando el AuthenticationManager,
    // verificando las credenciales proporcionadas en la solicitud (request.getUsername() y request.getPassword()).
    //Busca al usuario en el repositorio (usuarioRepository) basándose en el nombre de usuario proporcionado en la solicitud.
    //Genera un token JWT para el usuario autenticado utilizando el JwtService.
    //Retorna una instancia de AuthResponse que contiene el token generado

    public AuthResponse register(RegisterRequest request) { //maneja la logica de registro
        Usuario user = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(request.rol)
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .build();
        usuarioRepository.save(user);

        return AuthResponse.builder().
                token(jwtService.getToken(user)).build();
        //    Crea una nueva instancia de Usuario utilizando los datos proporcionados en la solicitud (request) para el registro.
        //    Cifra la contraseña del usuario utilizando el passwordEncoder.
        //    Guarda el nuevo usuario en la base de datos a través del usuarioRepository.
        //    Genera un token JWT para el usuario registrado utilizando el JwtService.
        //    Retorna una instancia de AuthResponse que contiene el token generado.
    }
}
//AuthService contiene la lógica para autenticar usuarios, verificar credenciales, registrar nuevos usuarios en la base de datos,
// generar tokens JWT y devolverlos como parte de la respuesta de autenticación o registro.
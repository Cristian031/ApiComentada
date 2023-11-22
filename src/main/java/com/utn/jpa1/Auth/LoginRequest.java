package com.utn.jpa1.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    String username;
    String password;
}
// LoginRequest proporciona una estructura simple para contener el nombre de usuario
// y la contraseña que se enviarán al servidor al intentar iniciar sesión.
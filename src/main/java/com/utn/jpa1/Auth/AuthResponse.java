package com.utn.jpa1.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Genera automáticamente los métodos toString(), equals(), hashCode(), getters y setters para todos los campos de la clase.
@Builder //Proporciona un constructor de estilo fluente que permite la creación de objetos AuthResponse utilizando el patrón de diseño Builder.
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    String token;//Este campo almacenará el token de autenticación que se devolverá
    // como parte de la respuesta al realizar una solicitud de autenticación exitosa.
}

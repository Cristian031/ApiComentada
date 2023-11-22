package com.utn.jpa1.DTOs;

import com.utn.jpa1.ennumerations.Rol;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOIniciarSesion {

    private String username;
    private String password;
    private Rol rol;
    private Boolean activo;

}

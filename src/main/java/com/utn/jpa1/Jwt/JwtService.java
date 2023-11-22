package com.utn.jpa1.Jwt;

import com.utn.jpa1.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class JwtService {

    //Una cadena que representa la clave secreta utilizada para firmar y verificar los tokens JWT.
    // Es importante mantener esta clave segura y privada, ya que se utiliza para la generación y verificación de tokens.
    private static final String SECRET_KEY="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }
    //genera un token utilizando los detalles del usuario, esblece claim predeterminado y time de expiracion de 24hs

    //Método sobrecargado que permite agregar claims adicionales al token JWT,
    //junto con los detalles del usuario para la generación del token.
    private String getToken(Map<String, Object> extraClaims, UserDetails user) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getKey(),SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() { //devuelve la clave utilizada para firmar y verificar tokens.
        //Convirtiendo  una cadena codificada a una clave.
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //obtiene el nombre del token
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }


    //verifica si el token es valido comprobando si el nombre del token es igual al proporcionado por
    // el detalle del usuario y si ese token a expirado.
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }


    //obtiene todos los claims del token JWT.
    private Claims getAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }

    //obtiene un claim especifico
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return  claimsResolver.apply(claims);
    }

    //obtiene la fecha de expiracion del token.
    private Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }

    //Verifica si el token JWT ha expirado comparando la fecha de expiración con la fecha actual.
    private Boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }
}

// JwtService proporciona métodos para generar tokens JWT, extraer información del token,
// verificar la validez del token para un usuario específico y manejar la lógica de expiración del token.
// Este servicio utiliza la biblioteca io.jsonwebtoken para operaciones relacionadas con los tokens JWT.
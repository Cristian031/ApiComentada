package com.utn.jpa1.Jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

@Component //indica que la clase es un componente de Spring
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {  //significa que esta clase se ejecutara una  por cada solicitud HTTP entrante.
    private final JwtService jwtService; //servicio encargado de la manipulacion de tokens jwt.
    private final UserDetailsService userDetailsService; //Servicio provisto por SpringSecurity para cargar los detalles del usuario.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String token = getTokenFromRequest(request);
        final String username;
        if (token==null){
            filterChain.doFilter(request,response);
            return;
        }
        username = jwtService.getUsernameFromToken(token);
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtService.isTokenValid(token, userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
    private String getTokenFromRequest(HttpServletRequest request){ //Un método privado que extrae el token del encabezado de autorización de la solicitud HTTP.
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer "))
        {
            return authHeader.substring(7);
        }
        return null;
    }
}

//Este filtro intercepta todas las solicitudes entrantes y verifica si contienen un token JWT válido en el encabezado de autorización.
// Si se encuentra un token válido, autentica al usuario y establece la información de autenticación en el contexto de seguridad de Spring.
// Esto permite asegurar rutas específicas o recursos en función de la autenticación proporcionada por los tokens JWT.

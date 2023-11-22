package com.utn.jpa1.Config;

import com.utn.jpa1.Jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity //habilita la seguridad web de spring
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter; //filtro de autenticacion personalizado
    private final AuthenticationProvider authProvider; //Proveedor de Authentication
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{  //configura la cadena de filtros de seguridad.
        return http  //especifica la configuracion de seguridad para las rutas
                .csrf(AbstractHttpConfigurer::disable) //deshabilita la proteccion de CSRF.
                .authorizeHttpRequests(authRequest ->  //define las reglas de autorizacion para diferentes rutas
                        authRequest
                                .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                                //permitAll(): Permite el acceso sin restricciones a ciertas rutas, como /auth/**, /api/v1/** y la consola H2.
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/**")).permitAll()

                                //Consola H2:
                                .requestMatchers(PathRequest.toH2Console()).permitAll()

                                //Autorizacion de acceso a la url:
                                //hasAuthority("ADMINISTRADOR") y .hasAuthority("USER"): Requiere autorización basada en roles para ciertas rutas específicas.
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/demoAdmin/**")).hasAuthority("ADMINISTRADOR")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/demoUser/**")).hasAuthority("USER")
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/clientes/**")).hasAuthority("USER")
                )
                //.headers(headers -> ...): Configura los encabezados de seguridad.
                //    .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable): Deshabilita las opciones de frame para la consola H2.
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2

                //sessionManagement(sessionManager -> ...): Configura la gestión de sesiones.
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS): Indica que la aplicación no creará sesiones de usuario (sesiones sin estado).
                .sessionManagement(sessionManager->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //.authenticationProvider(authProvider): Configura el proveedor de autenticación que se utilizará para la autenticación de usuarios.
                .authenticationProvider(authProvider)
                //.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class):
                // Agrega el filtro JwtAuthenticationFilter antes del filtro de autenticación
                // por nombre de usuario y contraseña (UsernamePasswordAuthenticationFilter).
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}//esta configuración establece las reglas de seguridad para diferentes rutas de la aplicación,
// incluyendo la configuración de permisos de acceso, deshabilitación de CSRF, configuración de encabezados de seguridad,
// gestión de sesiones sin estado y la incorporación de un filtro personalizado (JwtAuthenticationFilter)
// para la autenticación basada en tokens JWT antes del proceso de autenticación por nombre de usuario y contraseña.

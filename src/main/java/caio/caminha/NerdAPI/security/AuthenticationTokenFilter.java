package caio.caminha.NerdAPI.security;

import caio.caminha.NerdAPI.models.Usuario;
import caio.caminha.NerdAPI.repositories.UsuarioRepository;
import caio.caminha.NerdAPI.securityServices.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationTokenFilter extends OncePerRequestFilter {
    private UsuarioRepository usuarioRepository;
    private TokenService tokenService;
    private static final int POSICAO_BEARER = 7;

    public AuthenticationTokenFilter(UsuarioRepository repository, TokenService service){
        this.usuarioRepository = repository;
        this.tokenService = service;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean valid = this.tokenService.isTokenValid(token);
        if(valid){
            autenticarCliente(token);
        }
        filterChain.doFilter(request, response);
    }


    public void autenticarCliente(String token){
        Long usuarioId = this.tokenService.getUserId(token);
        Usuario usuario = this.usuarioRepository.findById(usuarioId).get();
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }



    public String recuperarToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(POSICAO_BEARER, token.length());
    }
}

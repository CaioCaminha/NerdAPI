package caio.caminha.NerdAPI.securityServices;

import caio.caminha.NerdAPI.models.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private static final String expiration = "86400000";

    private static final String secret = "RT&KH%h$yjx5*c*lxMrvGA24VG5Vg&zUjQ";

    public String generateToken(Authentication authentication){
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        Date today = new Date();
        Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));


        return Jwts.builder()
                .setIssuer("API para avaliação Loja Do Mecanico")
                .setSubject(usuarioLogado.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValid(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Long getUserId(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

}

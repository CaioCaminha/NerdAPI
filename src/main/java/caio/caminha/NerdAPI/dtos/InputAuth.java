package caio.caminha.NerdAPI.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class InputAuth {
    @JsonProperty("email")
    @NotNull @NotEmpty
    private String email;
    @JsonProperty("senha")
    @NotNull @NotEmpty
    private String senha;

    public InputAuth(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken convert(){
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}

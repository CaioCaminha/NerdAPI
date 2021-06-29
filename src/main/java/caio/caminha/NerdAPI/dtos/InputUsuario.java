package caio.caminha.NerdAPI.dtos;

import caio.caminha.NerdAPI.models.Usuario;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class InputUsuario {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String senha;

    public InputUsuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario convert(){
        return new Usuario(this.nome, this.email, new BCryptPasswordEncoder().encode(this.senha));
    }
}

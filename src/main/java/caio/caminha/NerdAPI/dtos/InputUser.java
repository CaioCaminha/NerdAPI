package caio.caminha.NerdAPI.dtos;

import caio.caminha.NerdAPI.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class InputUser {
    @JsonProperty("nome")
    @NotNull @NotEmpty
    private String nome;
    @JsonProperty("email")
    @NotNull @NotEmpty
    private String email;
    @JsonProperty("senha")
    @NotNull @NotEmpty
    private String senha;

    public InputUser(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }



    public User convertToEntity(){
        return new User(this.nome, this.email, new BCryptPasswordEncoder().encode(this.senha));
    }
}

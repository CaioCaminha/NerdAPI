package caio.caminha.NerdAPI.dtos;

import caio.caminha.NerdAPI.model.User;
import lombok.Data;

@Data
public class OutputUser {
    private Long id;
    private String nome;
    private String email;

    public OutputUser(User usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

}

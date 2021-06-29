package caio.caminha.NerdAPI.dtos;

import caio.caminha.NerdAPI.models.Usuario;
import lombok.Data;

@Data
public class OutputUsuario {
    private Long id;
    private String nome;
    private String email;

    public OutputUsuario(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

}

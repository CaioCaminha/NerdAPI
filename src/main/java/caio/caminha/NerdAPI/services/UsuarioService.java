package caio.caminha.NerdAPI.services;

import caio.caminha.NerdAPI.dtos.InputUsuario;
import caio.caminha.NerdAPI.dtos.OutputUsuario;
import caio.caminha.NerdAPI.models.Usuario;
import caio.caminha.NerdAPI.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public OutputUsuario saveUsuario(InputUsuario input){
        Usuario usuario = this.usuarioRepository.save(input.convert());
        return new OutputUsuario(usuario);
    }


}

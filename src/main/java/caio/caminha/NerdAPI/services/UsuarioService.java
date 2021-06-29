package caio.caminha.NerdAPI.services;

import caio.caminha.NerdAPI.dtos.InputAuth;
import caio.caminha.NerdAPI.dtos.InputUsuario;
import caio.caminha.NerdAPI.dtos.OutputUsuario;
import caio.caminha.NerdAPI.models.Usuario;
import caio.caminha.NerdAPI.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public OutputUsuario saveUsuario(InputUsuario input){
        Usuario usuario = this.usuarioRepository.save(input.convert());
        return new OutputUsuario(usuario);
    }

    public OutputUsuario editaSenha(InputAuth input){
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(input.getEmail());
        if(usuario.isPresent()){
            usuario.get().setSenha(new BCryptPasswordEncoder().encode(input.getSenha()));
            Usuario usuarioEditado = this.usuarioRepository.save(usuario.get());
            return new OutputUsuario(usuarioEditado);
        }else{
            throw new UsernameNotFoundException("Usuário Inválido");
        }
    }


}

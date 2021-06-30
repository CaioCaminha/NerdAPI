package caio.caminha.NerdAPI.services;

import caio.caminha.NerdAPI.dtos.InputUser;
import caio.caminha.NerdAPI.dtos.OutputUser;
import caio.caminha.NerdAPI.model.User;
import caio.caminha.NerdAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    public OutputUser saveUser(InputUser input){
        User user = this.userRepository.save(input.convertToEntity());
        return new OutputUser(user);
    }


    public OutputUser updatePassword(InputUser input, Long id){
        Optional<User> user = this.userRepository.findById(id);
            if(user.isPresent()) {
                user.get().setSenha(new BCryptPasswordEncoder().encode(input.getSenha()));
                return new OutputUser(this.userRepository.save(user.get()));
            }else{
                throw new UsernameNotFoundException("Dados inválidos");
            }
    }


}

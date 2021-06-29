package caio.caminha.NerdAPI.controllers;

import caio.caminha.NerdAPI.dtos.InputAuth;
import caio.caminha.NerdAPI.dtos.InputUsuario;
import caio.caminha.NerdAPI.dtos.OutputUsuario;
import caio.caminha.NerdAPI.models.Usuario;
import caio.caminha.NerdAPI.repositories.UsuarioRepository;
import caio.caminha.NerdAPI.securityServices.TokenService;
import caio.caminha.NerdAPI.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> cadastroUsuario(@RequestBody @Valid InputUsuario input,
                                                         UriComponentsBuilder builder){
        try{
            OutputUsuario output = this.usuarioService.saveUsuario(input);
            URI uri = builder.path("/user/{id}").buildAndExpand(output.getId()).toUri();
            return ResponseEntity.created(uri).body(output);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Não foi possível cadastrar o usuário, verifique os campos e tente novamente");
        }
    }

    @PutMapping
    public ResponseEntity<?> editaSenha( @RequestBody @Valid InputAuth input){

            try {
                Optional<Usuario> usuario = this.usuarioRepository.findByEmail(input.getEmail());
                if(usuario.isPresent()) {
                    usuario.get().setSenha(new BCryptPasswordEncoder().encode(input.getSenha()));
                    Usuario usuarioEditado = this.usuarioRepository.save(usuario.get());
                    return ResponseEntity.ok(new OutputUsuario(usuarioEditado) + " Senha alterada com sucesso!");
                }
                    return ResponseEntity.badRequest().body("Dados inválidos, tente novamente");
            }catch (Exception e){
                return ResponseEntity.badRequest().body("Dados inválidos, tente novamente");
            }
    }


}

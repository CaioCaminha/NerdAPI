package caio.caminha.NerdAPI.controllers;

import caio.caminha.NerdAPI.dtos.InputUser;
import caio.caminha.NerdAPI.dtos.OutputUser;
import caio.caminha.NerdAPI.securityServices.TokenService;
import caio.caminha.NerdAPI.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    private static final int POSICAO_BEARER = 7;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody @Valid InputUser input,
                                      UriComponentsBuilder builder){
        try{
            OutputUser output = this.usuarioService.saveUser(input);
            URI uri = builder.path("/user/{id}").buildAndExpand(output.getId()).toUri();
            return ResponseEntity.created(uri).body(output);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Não foi possível cadastrar o usuário, verifique os campos e tente novamente");
        }
    }

    @PatchMapping
    public ResponseEntity<?> updatePassword(@RequestBody InputUser input, @RequestHeader("Authorization") String token){
              try {
                  Long id = this.tokenService.getUserId(token.substring(POSICAO_BEARER, token.length()));
                  return ResponseEntity.ok(this.usuarioService.updatePassword(input, id));
              }catch (Exception e){
                  return ResponseEntity.badRequest().body("Dados inválidos, tente novamente");
              }
    }


}

package caio.caminha.NerdAPI.controllers;

import caio.caminha.NerdAPI.dtos.InputAuth;
import caio.caminha.NerdAPI.dtos.OutputToken;
import caio.caminha.NerdAPI.securityServices.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid InputAuth input){
        UsernamePasswordAuthenticationToken dadosLogin = input.convertToUserNameAuthenticationToken();
        try{
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = this.tokenService.generateToken(authentication);
            return ResponseEntity.ok(new OutputToken(token, "Bearer "));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Usuário inválido, tente novamente!");
        }
    }
}

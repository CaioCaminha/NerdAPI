package caio.caminha.NerdAPI.dtos;

import lombok.Data;

@Data
public class OutputToken {
    private String token;
    private String type;

    public OutputToken(String token, String type){
        this.token = token;
        this.type = type;
    }
}

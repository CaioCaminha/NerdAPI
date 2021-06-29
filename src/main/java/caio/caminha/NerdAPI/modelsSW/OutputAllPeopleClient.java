package caio.caminha.NerdAPI.modelsSW;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;

@Data
public class OutputAllPeopleClient {
    @JsonProperty("count")
    private int count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("results")
    private ArrayList<OutputPessoaClient> results;
}

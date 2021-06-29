package caio.caminha.NerdAPI.modelsSW;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class OutputAllFilms {
    @JsonProperty("count")
    private int count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("results")
    private ArrayList<OutputFilmeClient> results;
}

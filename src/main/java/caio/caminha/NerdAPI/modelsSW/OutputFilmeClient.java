package caio.caminha.NerdAPI.modelsSW;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OutputFilmeClient {
    @JsonProperty("title")
    private String tile;
    @JsonProperty("episode_id")
    private Integer episode_id;
    @JsonProperty("opening_crawl")
    private String opening_crawl;
    @JsonProperty("director")
    private String director;
    @JsonProperty("producer")
    private String producer;
    @JsonProperty("release_date")
    private Date release_date;
    @JsonProperty("species")
    private List<String> species;
    @JsonProperty("starships")
    private List<String> starships;
    @JsonProperty("vehicles")
    private List<String> vehicles;
    @JsonProperty("planets")
    private List<String> planets;
    @JsonProperty("characters")
    private List<String> characters;
    @JsonProperty("url")
    private String url;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
}

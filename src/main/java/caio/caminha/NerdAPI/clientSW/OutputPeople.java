package caio.caminha.NerdAPI.clientSW;

import lombok.Data;

import java.util.List;

@Data
public class OutputPeople {
    private String nome;
    private String data_nascimento;
    private String cor_olho;
    private String genero;
    private String cor_cabelo;
    private String altura;
    private String peso;
    private String cor_pele;
    private String planeta_natal;
    private List<String> filmes;
    private List<String> especies;
    private List<String> naves;
    private List<String> veiculos;
    private String link;
    private String criado;
    private String editado;

    public OutputPeople(OutputPeopleClient outputPeopleClient){
        this.nome = outputPeopleClient.getName();
        this.data_nascimento = outputPeopleClient.getBirth_year();
        this.cor_olho = outputPeopleClient.getEye_color();
        this.genero = outputPeopleClient.getGender();
        this.cor_cabelo = outputPeopleClient.getHair_color();;
        this.altura = outputPeopleClient.getHeight();
        this.peso = outputPeopleClient.getMass();
        this.cor_pele = outputPeopleClient.getSkin_color();
        this.planeta_natal = outputPeopleClient.getHomeworld();
        this.filmes = outputPeopleClient.getFilms();
        this.especies = outputPeopleClient.getSpecies();
        this.naves = outputPeopleClient.getStarships();
        this.veiculos = outputPeopleClient.getVehicles();
        this.link = outputPeopleClient.getUrl();
        this.criado = outputPeopleClient.getCreated();
        this.editado = outputPeopleClient.getEdited();
    }

}

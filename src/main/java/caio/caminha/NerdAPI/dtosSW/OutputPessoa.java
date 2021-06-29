package caio.caminha.NerdAPI.dtosSW;

import lombok.Data;

import java.util.List;

@Data
public class OutputPessoa {
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

    public OutputPessoa(OutputPessoaClient outputPessoaClient){
        this.nome = outputPessoaClient.getName();
        this.data_nascimento = outputPessoaClient.getBirth_year();
        this.cor_olho = outputPessoaClient.getEye_color();
        this.genero = outputPessoaClient.getGender();
        this.cor_cabelo = outputPessoaClient.getHair_color();;
        this.altura = outputPessoaClient.getHeight();
        this.peso = outputPessoaClient.getMass();
        this.cor_pele = outputPessoaClient.getSkin_color();
        this.planeta_natal = outputPessoaClient.getHomeworld();
        this.filmes = outputPessoaClient.getFilms();
        this.especies = outputPessoaClient.getSpecies();
        this.naves = outputPessoaClient.getStarships();
        this.veiculos = outputPessoaClient.getVehicles();
        this.link = outputPessoaClient.getUrl();
        this.criado = outputPessoaClient.getCreated();
        this.editado = outputPessoaClient.getEdited();
    }

}

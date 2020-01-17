package pt.ipleiria.estg.dei.hospitalestg.modelo;

public class Pessoa {

    String nome;
    String datanascimento;
    String morada;
    String numutentesaude;
    String numidcivil;
    String tipoutilizador;


    public Pessoa (String nome,String datanascimento, String morada, String numutentesaude, String numidcivil,String tipoutilizador){

        this.nome = nome;
        this.datanascimento = datanascimento;
        this.morada= morada;
        this.numutentesaude = numutentesaude;
        this.numidcivil = numidcivil;
        this.tipoutilizador= tipoutilizador;

    }

    public String getNome() {
        return nome;
    }
    public String getDatanascimento() {
        return datanascimento;
    }
    public String getMorada() {
        return morada;
    }
    public String getNumutentesaude() {
        return numutentesaude;
    }
    public String getNumidcivil() {
        return numidcivil;
    }
    public String getTipoutilizador() {
        return tipoutilizador;
    }
}

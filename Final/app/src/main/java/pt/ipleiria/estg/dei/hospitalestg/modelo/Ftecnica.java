package pt.ipleiria.estg.dei.hospitalestg.modelo;

public class Ftecnica {
    private static int autoIncrement=1;

    private int idFtecnica;
    private String Ficheiro, Observacoes;

    public Ftecnica (int idFtecnica,String Ficheiro, String Observacoes) {
        this.idFtecnica = idFtecnica;
        this.Ficheiro = Ficheiro;
        this.Observacoes = Observacoes;
    }

    public int getIdFtecnica() {
        return idFtecnica;
    }

    public void setIdFtecnica(int idFtecnica) {
        this.idFtecnica = idFtecnica;
    }

    public String getFicheiro() {
        return Ficheiro;
    }

    public String getObservacoes() {
        return Observacoes;
    }
}

package pt.ipleiria.estg.dei.hospitalestg.modelo;

public class Receita {
    private static int autoIncrement=1;

    private int idReceita, Consulta_idConsulta;
    private String Prescricao, DataReceita;

    public Receita(int idReceita, String Prescricao, String DataReceita, int Consulta_idConsulta) {
        this.idReceita = idReceita;
        this.DataReceita = DataReceita;
        this.Prescricao = Prescricao;
        this.Consulta_idConsulta = Consulta_idConsulta;
    }


    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getConsulta_idConsulta() {
        return Consulta_idConsulta;
    }

    public void setConsulta_idConsulta(int consulta_idConsulta) {
        Consulta_idConsulta = consulta_idConsulta;
    }

    public String getPrescricao() {
        return Prescricao;
    }

    public void setPrescricao(String prescricao) {
        Prescricao = prescricao;
    }

    public String getDataReceita() {
        return DataReceita;
    }

    public void setDataReceita(String dataReceita) {
        DataReceita = dataReceita;
    }
}

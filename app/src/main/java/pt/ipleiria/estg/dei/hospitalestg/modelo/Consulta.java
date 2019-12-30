package pt.ipleiria.estg.dei.hospitalestg.modelo;

public class Consulta {
    private static int autoIncrement=1;
    private int id;
    private String medico, motivo, hora, data;


    public Consulta (int id, String medico, String motivo, String data, String hora){

      this.id = id;
        this.medico = medico;
        this.motivo= motivo;
        this.data = data;
        this.hora =hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedico() {
        return medico;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getHora() {
        return hora;
    }

    public String getData() {
        return data;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setData(String data) {
        this.data = data;
    }
}

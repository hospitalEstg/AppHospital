package pt.ipleiria.estg.dei.hospitalestg.modelo;

public class Pedido {
    private static int autoIncrement=1;
     int idPedido;
     String Descricao;
     boolean Urgente;

    public Pedido (int idPedido, String Descricao, boolean Urgente){

        this.idPedido = idPedido;
        this.Descricao = Descricao;
        this.Urgente= Urgente;

    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public boolean isUrgente() {
        return Urgente;
    }

    public void setUrgente(boolean urgente) {
        Urgente = urgente;
    }
}

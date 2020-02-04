package pt.ipleiria.estg.dei.hospitalestg.modelo;

public class Pedido {
    private static int autoIncrement=1;
     int idPedido;
     String Descricao;
     int Urgente;

     int Estado ;
     int idPessoa;

    public Pedido (int idPedido, String Descricao, int Urgente, int Estado, int idPessoa){

        this.idPedido = idPedido;
        this.Descricao = Descricao;
        this.Urgente= Urgente;

        this.Estado = Estado;
        this.idPessoa = idPessoa;

    }



    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
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

    public int getUrgente() {
        return Urgente;
    }

    public void setUrgente(int urgente) {
        Urgente = urgente;
    }
}

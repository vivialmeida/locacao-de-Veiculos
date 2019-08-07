package modelo;

public enum StatusReserva {
    ABERTA("aberta"),
    FECHADA("fechada");


    private String situacao;


    private StatusReserva(String situacao) {
        this.situacao = situacao;
    }


    public String getSituacao() {
        return this.situacao;
    }

}

package modelo;

public enum Situacao {
    DISPONIVEL ("situação"),
    ALUGADO("alugado"),
    FORADAORIGEM ("fora da origem");

private String situacao;


private Situacao(String situacao){
    this.situacao = situacao;
}


    public String getSituacao() {
        return this.situacao;
    }

}

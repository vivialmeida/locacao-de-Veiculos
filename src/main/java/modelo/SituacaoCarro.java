package modelo;

public enum SituacaoCarro {

    DISPONIVEL("situação"),
    ALUGADO("alugado"),
    FORADAORIGEM("fora da origem");

    private String situacao;


    private SituacaoCarro(String situacao) {
        this.situacao = situacao;
    }


    public String getSituacao() {
        return this.situacao;
    }

}

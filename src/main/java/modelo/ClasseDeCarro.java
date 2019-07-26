package modelo;

public enum ClasseDeCarro {

    SUBCOMPACTO("50"),
    COMPACTO("75"),
    MÉDIO("90"),
    GRANDE("150"),
    LUXO("200");


    private final String classe;

    private ClasseDeCarro(String classe) {
        this.classe = classe;
    }

    public String getTipo() {
        return classe;
    }
}



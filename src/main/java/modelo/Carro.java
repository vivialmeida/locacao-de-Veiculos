package modelo;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Carro {

    private String placa;
    private String modelo;
    private String ano;
    private float Km;
    private String descricao;
    private ClasseDeCarro classeDeCarro;
    private Sede locacaoDeOrigem;
    private Sede localizacaoAtual;
    private List<Reserva> historicoDeReservas;

    @Id @NotNull
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public float getKm() {
        return Km;
    }

    public void setKm(float km) {
        Km = km;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Enumerated @Column(name = "classe_combustível")
    public ClasseDeCarro getClasseDeCarro() {
        return classeDeCarro;
    }

    public void setClasseDeCarro(ClasseDeCarro classeDeCarro) {
        this.classeDeCarro = classeDeCarro;
    }

    @OneToOne
    public Sede getLocacaoDeOrigem() {
        return locacaoDeOrigem;
    }

    public void setLocacaoDeOrigem(Sede locacaoDeOrigem) {
        this.locacaoDeOrigem = locacaoDeOrigem;
    }
    @OneToOne
    public Sede getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public void setLocalizacaoAtual(Sede localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return placa.equals(carro.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }
}

package modelo;


import com.sun.istack.NotNull;
import org.hibernate.dialect.Cache71Dialect;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Carro {

    @Id @NotNull @Column(length = 45)
    private String placa;

     @Column(length = 45, nullable = false)
    private String modelo;

    @Column(length = 15)
    private String ano;

    private float Km;

    private String descricao;

    @Enumerated @NotNull
    private ClasseDeCarro classeDeCarro;

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    private Sede sedeOrigem;

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    private Sede sedeAtual;

    @OneToMany (mappedBy = "carro", cascade = CascadeType.ALL)
    private List<Reserva> historicoDeReservas;


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

    public ClasseDeCarro getClasseDeCarro() {
        return classeDeCarro;
    }

    public void setClasseDeCarro(ClasseDeCarro classeDeCarro) {
        this.classeDeCarro = classeDeCarro;
    }

    public Sede getLocacaoDeOrigem() {
        return sedeOrigem;
    }

    public void setLocacaoDeOrigem(Sede locacaoDeOrigem) {
        this.sedeOrigem = locacaoDeOrigem;
    }

    public Sede getLocalizacaoAtual() {
        return sedeAtual;
    }

    public void setLocalizacaoAtual(Sede localizacaoAtual) {
        this.sedeAtual = localizacaoAtual;
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

    @Override
    public String toString() {
        return  '\n' +"----------- Carro ------------------     "  + "\n "+
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano='" + ano + '\'' +
                ", Km=" + Km +
                ", descricao='" + descricao + '\'' +
                ", classeDeCarro=" + classeDeCarro +
                ", sedeOrigem=" + sedeOrigem.getNome() + " Código: " + sedeOrigem.getCodigo() +
                ", sedeAtual=" + sedeAtual.getNome() + " Código: "  + sedeAtual.getCodigo() +
                ", historicoDeReservas=" + historicoDeReservas +
                 + '\n' ;
    }
}





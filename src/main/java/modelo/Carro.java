package modelo;


import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Carro {

    private String placa;
    private String modelo;
    private String ano;
    private float Km;
    private String descricao;
    private ClasseDeCarro classeDeCarro;

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

    @OneToOne
    public ClasseDeCarro getClasseDeCarro() {
        return classeDeCarro;
    }

    public void setClasseDeCarro(ClasseDeCarro classeDeCarro) {
        this.classeDeCarro = classeDeCarro;
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

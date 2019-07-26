package modelo;


import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;
import java.util.Objects;

@Entity
public class Carros {

    private String placa;
    private String modelo;
    private String ano;
    private float Km;
    private String descricao;
    private ClasseDeCarro classeDoCarro;

    @NotNull
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

    public ClasseDeCarro getClasseDoCarro() {
        return classeDoCarro;
    }

    public void setClasseDoCarro(ClasseDeCarro classeDoCarro) {
        this.classeDoCarro = classeDoCarro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carros carros = (Carros) o;
        return Objects.equals(placa, carros.placa) &&
                Objects.equals(modelo, carros.modelo) &&
                Objects.equals(ano, carros.ano) &&
                Objects.equals(Km, carros.Km) &&
                Objects.equals(descricao, carros.descricao) &&
                classeDoCarro == carros.classeDoCarro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa, modelo, ano, Km, descricao, classeDoCarro);
    }
}

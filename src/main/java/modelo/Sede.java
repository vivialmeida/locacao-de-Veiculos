package modelo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Sede {
    private int codigoSede;
    private String nome;
    private Endereco endereco;
    private String telefone;
    private String nomeDoGerente;
    private float multaPorAtraso;
    private List<Carro> carros;
    private List<Reserva> reservas;


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "codigo_sede")
    public int getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(int codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeDoGerente() {
        return nomeDoGerente;
    }

    public void setNomeDoGerente(String nomeDoGerente) {
        this.nomeDoGerente = nomeDoGerente;
    }

    public float getMultaPorAtraso() {
        return multaPorAtraso;
    }

    public void setMultaPorAtraso(float multaPorAtraso) {
        this.multaPorAtraso = multaPorAtraso;
    }

    @OneToMany
    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    @OneToMany
    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sede sede = (Sede) o;
        return codigoSede == sede.codigoSede;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoSede);
    }
}




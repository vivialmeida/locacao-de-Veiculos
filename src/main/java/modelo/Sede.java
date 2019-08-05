package modelo;

import javax.persistence.*;
import java.util.*;

@Entity
public class Sede {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(length = 45,nullable = false)
    private String nome;

    @OneToOne (optional = false, cascade = CascadeType.ALL)
    private Endereco endereco;

    @Column(length = 45)
    private String telefone;

    @Column(length = 60)
    private String nomeDoGerente;

    private float multaPorAtraso;

    @OneToMany (mappedBy = "sedeOrigem" , cascade = CascadeType.ALL)
    private List<Carro> carros = new ArrayList<>();

    @OneToMany (mappedBy = "sedeOrigem", cascade =  CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigoSede) {
        this.codigo = codigo;
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

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

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
        return codigo == sede.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}




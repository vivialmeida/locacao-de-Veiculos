package modelo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Sedes {
    private int codigoSede;
    private String nome;
    private Endereco endereco;
    private String telefone;
    private String nomeDoGerente;
    private float multaPorAtraso;
    private List<Carros> carrosDaSede;
    private List<Reservas> reservasDaSede;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sedes sedes = (Sedes) o;
        return Float.compare(sedes.multaPorAtraso, multaPorAtraso) == 0 &&
                Objects.equals(nome, sedes.nome) &&
                Objects.equals(endereco, sedes.endereco) &&
                Objects.equals(telefone, sedes.telefone) &&
                Objects.equals(nomeDoGerente, sedes.nomeDoGerente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, endereco, telefone, nomeDoGerente, multaPorAtraso);
    }
}




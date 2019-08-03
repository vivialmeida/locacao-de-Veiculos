package modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {
    private  Integer id;
    private String nome;
    private String CPF;
    private String numeroDaCNH;
    private Date validadeDaCNH;
    private String categoria;
    private List<Reserva> reservas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Column (name = "numero_CNH")
    public String getNumeroDaCNH() {
        return numeroDaCNH;
    }

    public void setNumeroDaCNH(String numeroDaCNH) {
        this.numeroDaCNH = numeroDaCNH;
    }

    @Column (name = "validade_CNH")
    public Date getValidadeDaCNH() {
        return validadeDaCNH;
    }

    public void setValidadeDaCNH(Date validadeDaCNH) {
        this.validadeDaCNH = validadeDaCNH;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) &&
                Objects.equals(CPF, cliente.CPF) &&
                Objects.equals(numeroDaCNH, cliente.numeroDaCNH) &&
                Objects.equals(validadeDaCNH, cliente.validadeDaCNH) &&
                Objects.equals(categoria, cliente.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, CPF, numeroDaCNH, validadeDaCNH, categoria);
    }
}

package modelo;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class CNH {
    @Id
    @NotNull
    private String CPF;

    @Column(length = 45)
    private String numeroDaCNH;

    private LocalDate validadeDaCNH;

    @Column(length = 15)
    private String categoria;


    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNumeroDaCNH() {
        return numeroDaCNH;
    }

    public void setNumeroDaCNH(String numeroDaCNH) {
        this.numeroDaCNH = numeroDaCNH;
    }

    public LocalDate getValidadeDaCNH() {
        return validadeDaCNH;
    }

    public void setValidadeDaCNH(LocalDate validadeDaCNH) {
        this.validadeDaCNH = validadeDaCNH;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @OneToOne(mappedBy = "cnh", optional = false)
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public boolean cnhDentroDaValidade() {
        if (LocalDate.now().isBefore(this.getValidadeDaCNH())){

            return true;
        }
            return false;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CNH cnh = (CNH) o;
        return Objects.equals(CPF, cnh.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPF);
    }

    @Override
    public String toString() {
        return "CNH{" +
                "CPF='" + CPF + '\'' +
                ", numeroDaCNH='" + numeroDaCNH + '\'' +
                ", validadeDaCNH=" + validadeDaCNH +
                ", categoria='" + categoria + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}

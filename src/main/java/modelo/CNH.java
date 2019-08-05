package modelo;



import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class CNH {
    @Id @NotNull
    private String CPF;

    @Column(length = 45)
    private String numeroDaCNH;

    private Date validadeDaCNH;

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

    @OneToOne(mappedBy = "cnh", optional = false)
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

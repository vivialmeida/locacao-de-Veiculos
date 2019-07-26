package modelo;

import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reservas {

    private Integer codigo;
    private String numeroDaReserva;
    private int quantidadeDeDiarias;
    private Date dataDaLocacao;
    private Date dataRetorno;
    private float kmRodados;
    private float multa;
    private String situacao;
    private float valorTotal;
    private Carros carro;
    private Sedes sede;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column (name = "cod_reserva")
    public Integer getCodigo() {
        return codigo;
    }
    public String getNumeroDaReserva() {
        return numeroDaReserva;
    }

    public void setNumeroDaReserva(String numeroDaReserva) {
        this.numeroDaReserva = numeroDaReserva;
    }

    public int getQuantidadeDeDiarias() {
        return quantidadeDeDiarias;
    }

    public void setQuantidadeDeDiarias(int quantidadeDeDiarias) {
        this.quantidadeDeDiarias = quantidadeDeDiarias;
    }

    public Date getDataDaLocacao() {
        return dataDaLocacao;
    }

    public void setDataDaLocacao(Date dataDaLocacao) {
        this.dataDaLocacao = dataDaLocacao;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public float getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(float kmRodados) {
        this.kmRodados = kmRodados;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservas reservas = (Reservas) o;
        return quantidadeDeDiarias == reservas.quantidadeDeDiarias &&
                Float.compare(reservas.kmRodados, kmRodados) == 0 &&
                Float.compare(reservas.multa, multa) == 0 &&
                Float.compare(reservas.valorTotal, valorTotal) == 0 &&
                Objects.equals(numeroDaReserva, reservas.numeroDaReserva) &&
                Objects.equals(dataDaLocacao, reservas.dataDaLocacao) &&
                Objects.equals(dataRetorno, reservas.dataRetorno) &&
                Objects.equals(situacao, reservas.situacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDaReserva, quantidadeDeDiarias, dataDaLocacao, dataRetorno, kmRodados, multa, situacao, valorTotal);
    }
}


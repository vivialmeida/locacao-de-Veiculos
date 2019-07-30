package modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reserva {

    private Integer codigo;
    private Long numeroDaReserva;
    private int quantidadeDeDiarias;
    private Date dataDaLocacao;
    private Date dataRetorno;
    private float kmRodados;
    private float multa;
    private String situacao;
    private float valorTotal;
    private Carro carro;
    private Sede sedeOrigem;
    private Sede sedeDevolução;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_reserva")
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Long getNumeroDaReserva() {
        return numeroDaReserva;
    }

    public void setNumeroDaReserva(Long numeroDaReserva) {
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

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Sede getSedeOrigem() {
        return sedeOrigem;
    }

    public void setSedeOrigem(Sede sedeOrigem) {
        this.sedeOrigem = sedeOrigem;
    }

    public Sede getSedeDevolução() {
        return sedeDevolução;
    }

    public void setSedeDevolução(Sede sedeDevolução) {
        this.sedeDevolução = sedeDevolução;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return codigo.equals(reserva.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}




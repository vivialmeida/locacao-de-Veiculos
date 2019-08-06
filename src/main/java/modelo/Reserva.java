package modelo;

import com.sun.istack.NotNull;

import javax.crypto.Mac;
import javax.persistence.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private int quantidadeDeDiarias;

    @Column(nullable = false)
    private Date dataDaLocacao;

    @Column(nullable = false)
    private Date dataRetorno;

    private float kmRodados;
    private float multa;
    private float valorTotal;

    @Enumerated @NotNull
    private Situacao situacao;

    @ManyToOne (cascade = CascadeType.ALL)
    private Carro carro;

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    private Cliente cliente;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Sede sedeOrigem;

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    private Sede sedeDevolucao;


    public Integer getCodigo() {
        return codigo;
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

    public float getKmRodados(int i) {
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


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Sede getSedeOrigem() {
        return sedeOrigem;
    }

    public void setSedeOrigem(Sede sedeOrigem) {
        this.sedeOrigem = sedeOrigem;
    }


    public Sede getSedeDevolucao() {
        return sedeDevolucao;
    }

    public void setSedeDevolucao(Sede sedeDevolucao) {
        this.sedeDevolucao = sedeDevolucao;
    }

    public  int diferencaDeDataEmDias () throws ParseException {
        Date dtInicial = this.getDataDaLocacao();
        Date dtFinal = this.dataRetorno;
        return
                (int) ((dtFinal.getTime() - dtInicial.getTime() + 3600000L) / 86400000L);
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




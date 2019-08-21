package modelo;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    private LocalDate dataDaLocacao;

    @Column(nullable = false)
    private LocalDate dataRetorno;

    private BigDecimal kmRodados;
    private BigDecimal multa;
    private BigDecimal valorTotal;
    private BigDecimal valorDiarias;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusReserva statusReserva;

    @ManyToOne(cascade = CascadeType.ALL)
    private Carro carro;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Cliente cliente;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Sede sedeOrigem;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
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

    public LocalDate getDataDaLocacao() {
        return dataDaLocacao;
    }

    public void setDataDaLocacao(LocalDate dataDaLocacao) {
        this.dataDaLocacao = dataDaLocacao;
    }

    public LocalDate getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDate dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public BigDecimal getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(BigDecimal kmRodados) {
        this.kmRodados = kmRodados;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }


    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
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

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(StatusReserva statusReserva) {
        this.statusReserva = statusReserva;
    }




   public BigDecimal calculaValorDaLocação(Sede sede){
        this.valorTotal = carro.getValorDiaria().multiply((new BigDecimal(quantidadeDeDiarias)));
            if(!getSedeOrigem().equals(sede)) {
                this.getCarro().setSituacao(SituacaoCarro.foraDaOrigem);
                this.setMulta(sede.getMultaPorAtraso());
                return valorTotal;
            }
            return valorTotal ;
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

    @Override
    public String toString() {
        return "------ Reserva --------" + "\n" +

                "Quantidade De Diarias= " + quantidadeDeDiarias +
                " \n Data da Locacao= " + dataDaLocacao +
                "\n Data Retorno= " + dataRetorno +
                "\n km Rodados = " + kmRodados +
                "\n Multa= " + multa +
                "\n Valor Total= " + valorTotal +
                "\n Situacao= " + statusReserva +
                "\n Carro= " + "Modelo: " + carro.getModelo() + "  Placa: " + carro.getPlaca() +
                "\n Cliente= " + "Nome: " + cliente.getNome() + "  CPF: " + cliente.getCnh().getCPF() +
                "\n Sede Origem= " + "Nome: " + sedeOrigem.getNome() + "  Gerente: " + sedeOrigem.getNomeDoGerente() +
                "\n Sede Devolucao= " + "Nome: " + sedeDevolucao.getNome() + "  Gerente: " + sedeDevolucao.getNomeDoGerente() +
                '\n';
    }
}




package modelo;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Carro {

    @Id
    @NotNull
    @Column(length = 45)
    private String placa;

    @Column(length = 45, nullable = false)
    private String modelo;

    @Column(length = 15)
    private String ano;

    private float Km;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private SituacaoCarro situacao;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ClasseDeCarro classeDeCarro;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Sede sedeOrigem;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Sede sedeAtual;

    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL)
    private List<Reserva> historicoDeReservas;

    private BigDecimal valorDiaria;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public float getKm() {
        return Km;
    }

    public void setKm(float km) {
        Km = km;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ClasseDeCarro getClasseDeCarro() {
        return classeDeCarro;
    }

    public void setClasseDeCarro(ClasseDeCarro classeDeCarro) {
        this.classeDeCarro = classeDeCarro;
    }

    public Sede getLocacaoDeOrigem() {
        return sedeOrigem;
    }

    public void setLocacaoDeOrigem(Sede locacaoDeOrigem) {
        this.sedeOrigem = locacaoDeOrigem;
    }

    public Sede getLocalizacaoAtual() {
        return sedeAtual;
    }

    public SituacaoCarro getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCarro situacao) {
        this.situacao = situacao;
    }

    public Sede getSedeOrigem() {
        return sedeOrigem;
    }

    public void setSedeOrigem(Sede sedeOrigem) {
        this.sedeOrigem = sedeOrigem;
    }

    public Sede getSedeAtual() {
        return sedeAtual;
    }

    public void setSedeAtual(Sede sedeAtual) {
        this.sedeAtual = sedeAtual;
    }

    public List<Reserva> getHistoricoDeReservas() {
        return historicoDeReservas;
    }

    public void setHistoricoDeReservas(List<Reserva> historicoDeReservas) {
        this.historicoDeReservas = historicoDeReservas;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void alugarCarro(Reserva reserva) {
        //this.historicoDeReservas.add(reserva);
        this.setSituacao(SituacaoCarro.ALUGADO);
        this.setLocacaoDeOrigem(reserva.getSedeOrigem());
    }

    public void tranferenciaDeVeiculo(Carro carro, Sede sede) throws Exception {

        if (this.getSituacao().equals(SituacaoCarro.DISPONIVEL)) {
            this.setSedeAtual(sede);
            return;
        } else {
            throw new Exception("Não foi possivel concluir a tranferencia do veiculo");

        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return placa.equals(carro.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    @Override
    public String toString() {
        return '\n' + "----------- Carro ------------------     " + "\n " +
                "\n Placa='" + placa + '\'' +
                "\n Modelo='" + modelo + '\'' +
                "\n Ano='" + ano + '\'' +
                "\n Km=" + Km +
                "\n Descricao='" + descricao + '\'' +
                "\n Situacao do Veiculo ='" + situacao + '\'' +
                "\n ClasseDeCarro=" + classeDeCarro +
                "\n Sede Origem=" + sedeOrigem.getNome() + " Código: " + sedeOrigem.getCodigo() +
                "\n sedeAtual=" + sedeAtual.getNome() + " Código: " + sedeAtual.getCodigo() +
                "\n Historico De Reservas=" + historicoDeReservas +
                +'\n';
    }
}





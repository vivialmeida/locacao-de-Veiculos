package modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
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

    private BigDecimal multaPorAtraso;

    @OneToMany (mappedBy = "sedeOrigem" , cascade = CascadeType.ALL)
    private List<Carro> carros = new ArrayList<>();

    @OneToMany (mappedBy = "sedeOrigem", cascade =  CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();


    public int getCodigo() {
        return codigo;
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

    public BigDecimal    getMultaPorAtraso() {
        return multaPorAtraso;
    }

    public void setMultaPorAtraso(BigDecimal multaPorAtraso) {
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

    public Reserva realizarReserva(Cliente cliente, Carro carro, int qtdDiarias) throws Exception {
        if (cliente.getCnh().cnhDentroDaValidade() && (carro.getSituacao().equals(SituacaoCarro.disponivel) || carro.getSituacao().equals(SituacaoCarro.foraDaOrigem)) && (!cliente.reservaEmAberto()))
        {
                Reserva reserva = new Reserva();
                reserva.setDataDaLocacao(LocalDate.now());
                reserva.setQuantidadeDeDiarias(qtdDiarias);
                reserva.setSedeOrigem(this);
                reserva.setCliente(cliente);
                cliente.adicionarReserva(reserva);
                carro.setSituacao(SituacaoCarro.alugado);
                reserva.setStatusReserva(StatusReserva.aberta);
                reserva.setCarro(carro);
                carro.alugarCarro(reserva);

              //  carro.setHistoricoDeReservas();
                this.reservas.add(reserva);
                return  reserva;
        }

        else {

            throw new IllegalStateException("Não foi possivel realizar reserva");

        }
    }

    public void encerrarReserva (Reserva reserva){

        reserva.calculaValorDaLocação(this);
        reserva.getCarro().setSituacao(SituacaoCarro.disponivel);
        reserva.setDataRetorno(LocalDate.now());
        reserva.getCarro().setSedeAtual(this);
        reserva.setSedeDevolucao(this);
        reserva.setStatusReserva(StatusReserva.fechada);
        reserva.setValorTotal(reserva.calculaValorDaLocação(this).add(getMultaPorAtraso()));
    }



    public List<Reserva> recuperarReservasEmAberto(){
        List <Reserva> reservas = new LinkedList<>();
        for (Reserva r : this.getReservas()) {
            if(!r.getStatusReserva().equals(StatusReserva.aberta)){
                reservas.add(r);
            }
        }
        return reservas;
    }
    
    
    public Carro carroComMenosQuantidadeDeReservas(){
        int quantidade =2000;
        Carro carro = null;
        for (Carro c : this.carros){
            if (c.getHistoricoDeReservas().size() < quantidade){
                quantidade = c.getHistoricoDeReservas().size();
                carro =c;
            }
        }
        return carro;
    }
        @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "\n"+ " ------------- Sede - -----------------" +
                "Codigo = " + codigo  +
                "Nome = " + nome + '\n' +
                "Endereco = " + endereco +  '\n' +
                "Telefone = " + telefone + '\n' +
                "Nome Do Gerente = " + nomeDoGerente + '\n' +
                "Multa Por Atraso = " + multaPorAtraso + '\n' +
                "Carros =" + carros.listIterator() + '\n' +
                "Reservas =" + reservas.listIterator() +
                "\n";

    }


}




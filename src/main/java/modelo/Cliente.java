package modelo;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60, nullable = false)
    private String nome;

    @OneToOne(optional =  false, cascade = CascadeType.ALL)
    private CNH cnh;

    @OneToOne (optional = false, cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany (mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public CNH getCnh() {
        return cnh;
    }

    public void setCnh(CNH cnh) {
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return "\n " +
                "Id = " + id + "\n " +
                "Nome = '" + nome + '\'' + "\n " +
                "CNH = " + cnh.getNumeroDaCNH() +" / Categoria: " + cnh.getCategoria() + "\n " +
                "Endereco =  Bairro: " + endereco.getBairro() + "Logadouro:  " + endereco.getRua() +"Numero:" + endereco.getNumero() +
                "Reservas =  " + reservas +
                '\n';
    }
}





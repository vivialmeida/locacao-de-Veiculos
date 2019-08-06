package teste;

import Repository.ClienteRepository;
import modelo.CNH;
import modelo.Cliente;
import modelo.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TesteCliente {

    public static void main(String[] args) throws ParseException {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("locacaoDeVeiculos");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transacao = manager.getTransaction();

        ClienteRepository  clienteRepository = new ClienteRepository(manager);
        transacao.begin();


        /*CNH cnh = new CNH();
        cnh.setCPF("1815");
        cnh.setNumeroDaCNH("12654");
        cnh.setValidadeDaCNH(new SimpleDateFormat("dd/mm/yyyy").parse("30/11/2022"));
        cnh.setCategoria("AB");


        Endereco endereco = new Endereco();

        endereco.setRua("Rua das Flores");
        endereco.setBairro("Florença");
        endereco.setCidade("Raposa");
        endereco.setEstado("MA");
        endereco.setCep("5665486");
        endereco.setNumero("58");

        manager.persist(endereco);

        Cliente cliente = new Cliente();
        cnh.setCliente(cliente);
        manager.persist(cnh);

        cliente.setCnh(cnh);
        cliente.setEndereco(endereco);
        cliente.setNome("Paula Tarsis");
        cnh.setCliente(cliente);

        manager.merge(cnh);

        manager.persist(cliente);


        clienteRepository.remove(cliente); */

       System.out.println(clienteRepository.buscaPor("Paula").toString());

        System.out.println(clienteRepository.buscaPor(1));
        transacao.commit();

        manager.close();

        factory.close();

    }

}

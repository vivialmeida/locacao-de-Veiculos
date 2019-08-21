package util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

    public class EMFactory {

        private static EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("locacaoDeVeiculos");


        public static EntityManager getEntityManager() {
            return factory.createEntityManager();

        }

        public void close() {
            factory.close();
        }
    }


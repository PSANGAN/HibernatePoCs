package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entites.ProductTbl;
import org.example.persistance.CustomPersistenceUnit;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Approach - 1, Using Persistence.xml
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("pcgs-persistence-unit");

        // Approach - 2, Using Custom Persistence class
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnit(), new HashMap<>());

        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            ProductTbl tbl = new ProductTbl();
            tbl.setId(2L);
            tbl.setDescription("Super");
            em.persist(tbl);

            em.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally {
        }{
            em.close();
        }
    }
}
package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entites.Employee;
import org.example.entites.ProductTbl;
import org.example.persistance.CustomPersistenceUnit;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Approach - 1, Using Persistence.xml
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("pcgs-persistence-unit");

        // Approach - 2, Using Custom Persistence class
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hdm2ddl.auto","create");

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnit(),props);

        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            ///region
//            ProductTbl tbl = new ProductTbl();
//            tbl.setId(3L);
//            tbl.setDescription("Super Nova");
//            em.persist(tbl);

//            Employee emp = em.find(Employee.class,101L);
//            System.out.println(emp.toString());
//
//            Employee emp2 =  new Employee();
//            emp2.setId(500L);
//            emp2.setName("NASDAQ");
//            emp2.setAddress("NY,USA");
//            em.merge(emp2); // if new Id then insert or update...
//
//            emp.setAddress("PKT");
//            em.merge(emp); // Update (since existing entity)
            ///endregion

            em.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally {
        }{
            em.close();
        }
    }
}
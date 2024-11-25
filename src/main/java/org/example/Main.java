package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entites.Employee;
import org.example.entites.ProductTbl;
import org.example.entites.Student;
import org.example.entites.relationships.Passport;
import org.example.entites.relationships.Person;
import org.example.id.generators.keys.StudentKey;
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
        props.put("hibernate.hbm2ddl.auto", "create"); // create, none, update

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

//            Employee emp = em.getReference(Employee.class,101L);
//            System.out.println(emp.toString());
//            emp.setName("Adam");
//
//            Employee emp2 =  new Employee();
//            emp2.setName("NASDAQ");
//            emp2.setAddress("NY,USA");
//            em.persist(emp2);
//
//            emp.setAddress("PKT");
//            em.merge(emp); // Update (since existing entity)


//            Employee emp = new Employee();
//            emp.setName("SAN");
//            emp.setAddress("PKT");
//            em.persist(emp);


//            ProductTbl tbl = new ProductTbl();
//            tbl.setCode("abc");
//            tbl.setNumber(101);
//            tbl.setColor("red");
//            em.persist(tbl);

//            StudentKey key = new StudentKey();
//            key.setCode("VLB");
//            key.setNumber(200120205);
//            Student student = new Student();
//            student.setId(key);
//            student.setName("ECE");
//            em.persist(student);
//
//            student = em.find(Student.class, key);
//            System.out.println(student.toString());

            ///endregion

            Person  person  = new Person();
            person.setName("GAN GAN");

            Passport passport = new Passport();
            passport.setNumber("B1237");

            person.setPassport(passport);
            passport.setPerson(person);

            // No need since CaseCade option is added in the owner
            //em.persist(passport);
            em.persist(person);

            em.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally {
        }{
            em.close();
        }
    }
}
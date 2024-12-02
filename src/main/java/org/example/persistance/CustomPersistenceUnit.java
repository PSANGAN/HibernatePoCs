package org.example.persistance;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;
import org.hibernate.classic.Lifecycle;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class CustomPersistenceUnit implements PersistenceUnitInfo {
    @Override
    public String getPersistenceUnitName() {
        return "pcgs-persistence-unit";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=Adventure;encrypt=true;trustServerCertificate=true");
        dataSource.setUsername("sa");
        dataSource.setPassword("Admin$1");

        return dataSource;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public List<URL> getJarFileUrls() {
        return null;
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {

//        return List.of("org.example.entites.ProductTbl",
//                       "org.example.entites.Employee",
//                        "org.example.entites.Student",
//                "org.example.entites.relationships.Passport",
//                "org.example.entites.relationships.Person",
//                "org.example.entites.relationships.UserInfo",
//                "org.example.entites.relationships.Comment",
//                "org.example.entites.relationships.Post",
//                "org.example.entites.relationships.User",
//                "org.example.entites.relationships.Group",
//                "org.example.entites.relationships.Product",
//                "org.example.entites.relationships.Book",
//                "org.example.entites.relationships.Device");

//        return List.of(
//                "org.example.entites.relationships.Product",
//                "org.example.entites.relationships.Book",
//                "org.example.entites.relationships.Device");

        return List.of("org.example.entites.criteria.Author",
                       "org.example.entites.criteria.Book",
                        "org.example.entites.criteria.BookShop");
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer transformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}

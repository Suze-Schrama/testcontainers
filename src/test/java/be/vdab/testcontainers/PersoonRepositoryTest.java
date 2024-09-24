package be.vdab.testcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
@Testcontainers
@DataJpaTest
@Sql("/insertPersonen.sql")
class PersoonRepositoryTest {
private final PersoonRepository persoonRepository;
@Container
    @ServiceConnection
    private static final MySQLContainer mySQL = new MySQLContainer("mysql:latest")
        .withDatabaseName("testcontainers")
        .withUsername("cursist")
        .withPassword("cursist");

    public PersoonRepositoryTest(PersoonRepository persoonRepository) {
        this.persoonRepository = persoonRepository;
    }

    @Test
    void erIs1PersoonEnDatIsJoe(){
        assertThat(persoonRepository.findAll())
                .singleElement()
                .extracting(Persoon::getVoornaam)
                .isEqualTo("Joe");
    }
}
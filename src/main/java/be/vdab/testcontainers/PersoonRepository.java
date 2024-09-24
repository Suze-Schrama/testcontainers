package be.vdab.testcontainers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersoonRepository extends JpaRepository<Persoon, Long> {
}

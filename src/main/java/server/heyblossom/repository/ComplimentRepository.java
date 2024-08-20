package server.heyblossom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.heyblossom.entity.Compliment;

public interface ComplimentRepository extends JpaRepository<Compliment, Long> {
}

package server.heyblossom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.heyblossom.entity.Blossom;

public interface BlossomRepository extends JpaRepository<Blossom, Long> {
}

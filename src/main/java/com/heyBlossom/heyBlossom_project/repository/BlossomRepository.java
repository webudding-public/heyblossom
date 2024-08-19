package com.heyBlossom.heyBlossom_project.repository;

import com.heyBlossom.heyBlossom_project.domain.Blossom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BlossomRepository extends JpaRepository<Blossom, Long> {

    Blossom save(Blossom blossom);

    List<Blossom> findByCreatedDateAfter(LocalDate date);
}

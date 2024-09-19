package com.heyBlossom.heyBlossom_project.repository;

import com.heyBlossom.heyBlossom_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUserName(String userName);
}

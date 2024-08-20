package server.heyblossom.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import server.heyblossom.entity.User;

import java.util.List;

public class UserRepositoryCustomImpl implements  UserRepositoryCustom{

    @Autowired
    private EntityManager entityManager;
    private JPAQueryFactory queryFactory;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

}

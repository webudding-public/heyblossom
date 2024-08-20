package server.heyblossom.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import server.heyblossom.entity.Compliment;
import server.heyblossom.entity.QCompliment;
import server.heyblossom.entity.QUser;

import java.util.List;

public class ComplimentRepositoryCustomImpl implements  ComplimentRepositoryCustom{

    @Autowired
    private EntityManager entityManager;
    private JPAQueryFactory queryFactory;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Compliment> findGiver() {
        QCompliment compliment = QCompliment.compliment;
        QUser user = QUser.user;
        return null;

//        return queryFactory.selectFrom(compliment)
//                .where(member.memberId.eq(id))
//                .leftJoin(gi)
//                .fetchJoin()
//                .fetchOne();
    }

    @Override
    public List<Compliment> findReceiver() {
        return null;
    }
}

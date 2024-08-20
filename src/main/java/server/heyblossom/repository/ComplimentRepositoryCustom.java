package server.heyblossom.repository;

import server.heyblossom.entity.Compliment;
import server.heyblossom.entity.User;

import java.util.List;

public interface ComplimentRepositoryCustom {

    List<Compliment> findGiver();
    List<Compliment> findReceiver();
}

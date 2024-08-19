package server.heyblossom.service;
import server.heyblossom.entity.User;
import java.util.List;

public interface UserService {

    List<User> findAll();
    List<User> findGivers();
    List<User> findReceviers();

}

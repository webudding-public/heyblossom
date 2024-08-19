package server.heyblossom.service;

import org.springframework.beans.factory.annotation.Autowired;
import server.heyblossom.entity.User;
import server.heyblossom.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final  UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

}

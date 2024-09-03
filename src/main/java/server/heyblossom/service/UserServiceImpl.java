package server.heyblossom.service;

import org.springframework.beans.factory.annotation.Autowired;
import server.heyblossom.entity.Blossom;
import server.heyblossom.entity.User;
import server.heyblossom.repository.BlossomRepository;
import server.heyblossom.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final  UserRepository userRepository;
    private final BlossomRepository blossomRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BlossomRepository blossomRepository) {
        this.userRepository = userRepository;
        this.blossomRepository = blossomRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> findGivers() {
        List<Blossom> blossoms = this.blossomRepository.findAll();
        List<User> users = new ArrayList<>();
        for (Blossom blossom : blossoms){
            Optional<User> user = this.userRepository.findById(blossom.getGiver().getId());
            user.ifPresent(users::add);
        }
        return users;
    }

    @Override
    public List<User> findReceviers() {
        return null;
    }

}

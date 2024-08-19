package server.heyblossom.service;

import org.springframework.beans.factory.annotation.Autowired;
import server.heyblossom.entity.Compliment;
import server.heyblossom.entity.User;
import server.heyblossom.repository.ComplimentRepository;
import server.heyblossom.repository.ComplimentRepositoryCustom;
import server.heyblossom.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final  UserRepository userRepository;
    private final ComplimentRepository complimentRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ComplimentRepository complimentRepository) {
        this.userRepository = userRepository;
        this.complimentRepository = complimentRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> findGivers() {
        List<Compliment> compliments = this.complimentRepository.findAll();
        List<User> users = new ArrayList<>();
        for (Compliment compliment: compliments){
            Optional<User> user = this.userRepository.findById(compliment.getGiver().getId());
            user.ifPresent(users::add);
        }
        return users;
    }

    @Override
    public List<User> findReceviers() {
        return null;
    }

}

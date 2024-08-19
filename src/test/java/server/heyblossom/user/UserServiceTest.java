package server.heyblossom.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import server.heyblossom.entity.Compliment;
import server.heyblossom.entity.User;
import server.heyblossom.repository.ComplimentRepository;
import server.heyblossom.repository.ComplimentRepositoryCustom;
import server.heyblossom.repository.UserRepository;
import server.heyblossom.service.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ComplimentRepository complimentRepository;
    @Mock
    private ComplimentRepositoryCustom complimentRepositoryCustom;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("전체 유저 조회")
    void findAll() {
        // Given
        User user1 = new User("user1@example.com","user1", "1234");
        User user2 = new User("user2@example.com","user2", "1234");
        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        // When
        List<User> result = userService.findAll();

        // Then
        assertEquals(users, result);
        System.out.println("result: " + result);
    }

    @Test
    @DisplayName("칭찬한 사람 목록 조회")
    void findManyGivers() {
        // Given
        User user1 = new User("user1@example.com","user1", "1234");
        User user2 = new User("user2@example.com","user2", "1234");
        User user3 = new User("user3@example.com","user3", "1234");

        Compliment compliment1 = new Compliment(user1, user2, "test message");
        Compliment compliment2 = new Compliment(user2, user3, "test message");

        List<User> givers = Arrays.asList(user1, user2);
        List<Compliment> compliments = Arrays.asList(compliment1, compliment2);

        when(complimentRepository.findAll()).thenReturn(compliments);

        // When
        List<User> result = userService.findGivers();

        // Then
        assertEquals(givers, result);
        System.out.println("result: " + result);
    }
}

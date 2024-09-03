package server.heyblossom.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import server.heyblossom.entity.Blossom;
import server.heyblossom.entity.User;
import server.heyblossom.repository.BlossomRepository;
import server.heyblossom.repository.UserRepository;
import server.heyblossom.service.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private BlossomRepository blossomRepository;
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

        Blossom blossom1 = new Blossom(user1, user2, "test message");
        Blossom blossom2 = new Blossom(user2, user3, "test message");

        List<User> givers = Arrays.asList(user1, user2);
        List<Blossom> blossoms = Arrays.asList(blossom1, blossom2);
        System.out.println("givers: " + givers);
        System.out.println("blossoms: " + blossoms);

        blossomRepository.save(blossom1);
        blossomRepository.save(blossom2);

//        List<Blossom> blossomList = blossomRepository.findAll();
//        System.out.println("blossomList: " + blossomList);

        when(blossomRepository.findAll()).thenReturn(blossoms);

        // When
        List<User> result = userService.findGivers();
        when(userService.findGivers()).thenReturn(givers);

        // Then
        assertEquals(givers, result);
        System.out.println("result: " + result);
    }
}

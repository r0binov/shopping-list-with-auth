package ee.sdacademy.service;

import ee.sdacademy.models.Users;
import ee.sdacademy.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UsersRepository usersRepository;

    private UserService userService;

    @BeforeEach
    public void init() {
        userService = new UserService(usersRepository);
    }

    @Test
    void getAll() {
        var expectedResult = new ArrayList<Users>();
        var users = new Users();
        users.setUsername("TestName");
        users.setPassword("TestSurname");

        expectedResult.add(users);

        when(usersRepository.getAllUsers()).thenReturn(expectedResult);

        var result = userService.getAll();

        assertEquals(expectedResult, result);
    }

    @Test
    void createUser() {
        var users = new Users();
        users.setUsername("TestName");
        users.setPassword("TestPW");

        userService.save(users);

        verify(usersRepository, times(1)).createUser(users);

        var encryptedPW = "07007a9ab7b7c5ffca497c28ddf645312c18e9a96d893e01bd1b5562114312d9fd7e48339055f3447ae0c3b98d537ff03ae84ed1eb45b5835c336c34214ca762";

        assertEquals(encryptedPW, users.getPassword());

    }

    @Test
    void deleteUser() {
        var users = new Users();
        users.setUsername("TestName");
        users.setPassword("TestPW");

        userService.deleteUser(users);

        verify(usersRepository, times(1)).deleteUser(users);
    }

    @Test
    void findUserByIdTest() {
        Users user = new Users();
        user.setId(1L);
        user.setUsername("JohnDoe");
        user.setPassword("password123");

        Long userId = 1L;

        when(usersRepository.findUserById(userId)).thenReturn(user);

        Users foundUser = userService.findUserById(userId);

        verify(usersRepository, times(1)).findUserById(userId);

        assertEquals(user, foundUser);
    }

    @Test
    void updateUserTest() {
        Users user = new Users();
        user.setId(1L);
        user.setUsername("JohnDoe");
        user.setPassword("password123");

        when(usersRepository.updateUser(user)).thenReturn(user);

        Users updatedUser = userService.updateUser(user);

        verify(usersRepository, times(1)).updateUser(user);

        assertEquals(user, updatedUser);
    }
}
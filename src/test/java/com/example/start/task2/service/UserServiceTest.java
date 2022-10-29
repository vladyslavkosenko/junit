package com.example.start.task2.service;

import com.example.start.task2.dto.User;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {
    private static final User IVAN = User.of(1, "Ivan", "123");
    private static final User PETR = User.of(2, "Petr", "111");

    private UserService userService;

    @BeforeAll
    void init() {
        System.out.println("BeforeAll ");
    }


    @BeforeEach
    void setUp() {
        System.out.println("Before each: " + this);
        userService = new UserService();
    }

    @Test
    void getAllWhenThereIsNoUserThenReturnEmptyList() {
        System.out.println("Test 1: " + this);
        var users = userService.getAll();
        assertTrue(users.isEmpty(), () -> "User list should be empty");
        // input -> [box = func] -> actual output
    }

    @Test
    void userSizeIfUserAdded() {
        System.out.println("test 2: " + this);
        userService.add(IVAN);
        userService.add(PETR);
        var users = userService.getAll();
        assertThat(users).hasSize(2);
        //   assertEquals(2, users.size());

    }

    @Test
    void loginSuccessIfUserExist() {
        userService.add(IVAN);
        var maybeUser = userService.login(IVAN.getUsername(), IVAN.getPassword());
        assertThat(maybeUser).isPresent();
        //assertTrue(maybeUser.isPresent());
        // maybeUser.ifPresent(user -> assertEquals(IVAN, user));
        maybeUser.ifPresent(user -> assertThat(user).isEqualTo(IVAN));
        System.out.println(maybeUser + " is empty?");
    }

    @Test
    void loginFailIIfPasswordIsNotCorrect() {
        userService.add(IVAN);
        var maybeUser = userService.login(IVAN.getUsername(), "dummy");
        assertTrue(maybeUser.isEmpty());

    }

    @Test
    void loginFailIIfUserDoesExist() {
        userService.add(IVAN);
        var maybeUser = userService.login("dummy", IVAN.getPassword());
        assertTrue(maybeUser.isEmpty());
        System.out.println(maybeUser + " is empty?");

    }

    @AfterEach
    void deleteDataFromDatabase() {
        System.out.println("AfterEach" + this);
    }

    @AfterAll
    static void closeConnectionPool() {
        System.out.println("AfterAll ");
    }

}
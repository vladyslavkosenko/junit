package com.example.start.task2.service;

import com.example.start.task2.dto.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {

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
        userService.add(new User());
        userService.add(new User());
        var users = userService.getAll();
        assertEquals(2, users.size());

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
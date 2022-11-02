package com.example.start.task2.service;

import com.example.start.TestBase;
import com.example.start.task2.dao.UserDao;
import com.example.start.task2.dto.User;
import com.example.start.task2.extension.ConditionExtension;
import com.example.start.task2.extension.PostProcessingExtension;
import com.example.start.task2.extension.UserServiceParamResolver;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Tag("fast")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith({
        UserServiceParamResolver.class,
        PostProcessingExtension.class,
        ConditionExtension.class,
//        ThrowableExtension.class // mast hew
//        GlobalExtension.class
})
public class UserServiceTest extends TestBase {
    private static final User IVAN = User.of(1, "Ivan", "123");
    private static final User PETR = User.of(2, "Petr", "111");
    private UserService userService;

    private UserDao userDao;

    UserServiceTest(TestInfo testInfo) {
        System.out.println();
    }

    @BeforeAll
    void init() {
        System.out.println("BeforeAll ");
    }


    @BeforeEach
    void prepare() {
        System.out.println("Before each: " + this);
        // this.userDao = mock(UserDao.class);
        this.userDao = spy(new UserDao());
        this.userService = new UserService(userDao);
    }

    @Test
    void shouldDeleteExistedUser() {
        userService.add(IVAN);
        Mockito.doReturn(true).when(userDao).delete(IVAN.getId());
        //  Mockito.doReturn(true).when(userDao).delete(Mockito.any());
        // Mockito.when(userDao.delete(any())).thenReturn(true);
//        Mockito.when(userDao.delete(IVAN.getId())).thenReturn(true)
//                .thenReturn(false);
        var deleteResult = userService.delete(IVAN.getId());
        System.out.println(userService.delete(IVAN.getId()));
        System.out.println(userService.delete(IVAN.getId()));

        var argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(userDao, Mockito.times(3)).delete(IVAN.getId());
       // Mockito.verifyNoInteractions();
       // assertThat(argumentCaptor.getValue()).isEqualTo(1);
        assertThat(deleteResult).isTrue();
    }

    @Test
    void deleteWhenUserIsDeletedThenReturnTrue() {
        userService.add(IVAN);
        doReturn(true).when(userDao).delete(IVAN.getId());
        var result = userService.delete(IVAN.getId());
        assertThat(result).isTrue();
    }


    @Test
    void getAllWhenThereIsNoUserThenReturnEmptyList() throws IOException {
        if (true) {
            throw new RuntimeException();
        }
        System.out.println("Test 1: " + this);
        var users = userService.getAll();
        //
        MatcherAssert.assertThat(users, IsEmptyCollection.empty());
        //
        assertTrue(users.isEmpty(), "User list should be empty");
        // input -> [box = func] -> actual output
    }

    @Test
    void userSizeIfUserAdded(UserService userService) {
        System.out.println("test 2: " + this);
        userService.add(IVAN);
        userService.add(PETR);
        var users = userService.getAll();
        assertThat(users).hasSize(2);
        //   assertEquals(2, users.size());

    }

    @Test
    @Tag("login")
    void loginSuccessIfUserExist() {
        userService.add(IVAN);
        var maybeUser = userService.login(IVAN.getUsername(), IVAN.getPassword());
        assertThat(maybeUser).isPresent();
        //assertTrue(maybeUser.isPresent());
        // maybeUser.ifPresent(user -> assertEquals(IVAN, user));
        maybeUser.ifPresent(user -> assertThat(user).isEqualTo(IVAN));
        System.out.println(maybeUser + " is empty?");
    }

    //    @Test
//    void trowExceptionIfUsernameOrPasswordIsNull() {
//        try {
//            userService.login(null, "dummy");
//            fail("Login should throw exception");
//        } catch (IllegalArgumentException ex) {
//            assertTrue(true);
//        }
//    }
    @Test
    @Tag("login")
    void trowExceptionIfUsernameOrPasswordIsNull() {
        assertAll(
                () -> {
                    var exception = assertThrows(IllegalArgumentException.class, () -> userService.login(null, "dummy"));
                    assertThat(exception.getMessage()).isEqualTo("username or password is null");
                },
                () -> assertThrows(IllegalArgumentException.class, () -> userService.login("dummy", null))
        );

    }

    @ParameterizedTest(name = "{arguments} test")
//    @ArgumentsSource()
//    @NullSource
//    @EmptySource
//    @NullAndEmptySource
//    @ValueSource(strings = {
//            "Ivan", "Petr"
//    })
    //  @EnumSource
    @MethodSource("com.example.start.task2.service.UserServiceTest#getArgumentsForLoginTest")
//    @CsvFileSource(resources = "/login-test-data.csv", delimiter = ',', numLinesToSkip = 1)
//    @CsvSource({
//            "Ivan,123",
//            "Petr.111"
//    })
    void loginParameterizedTest(String username, String password, Optional<User> user) {
        userService.add(IVAN, PETR);
        var maybeUser = userService.login(username, password);
        assertThat(maybeUser).isEqualTo(user);
    }


    @Test
    void userConvertedToMapId() {
        userService.add(IVAN, PETR);
        Map<Integer, User> users = userService.getAllConvertedById();
        MatcherAssert.assertThat(users, IsMapContaining.hasKey(IVAN.getId()));
        assertAll(
                () -> assertThat(users).containsKeys(IVAN.getId(), PETR.getId()),
                () -> assertThat(users).containsValues(IVAN, PETR)
        );

//        assertThat(users).containsKeys(IVAN.getId(), PETR.getId());
//        assertThat(users).containsValues(IVAN, PETR);
    }

    @Test
    @Tag("login")
    @Order(2)
    void loginFailIIfPasswordIsNotCorrect() {
        userService.add(IVAN);
        var maybeUser = userService.login(IVAN.getUsername(), "dummy");
        assertTrue(maybeUser.isEmpty());

    }


    @AfterEach
    void deleteDataFromDatabase() {
        System.out.println("AfterEach" + this);
    }

    @AfterAll
    static void closeConnectionPool() {
        System.out.println("AfterAll ");
    }

    @Nested
    @Tag("login")
    @DisplayName("test user login functionality")
    class LoginTest {
        //        @Test
        @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
        void loginFailIIfUserDoesExist() {
            userService.add(IVAN);
            var maybeUser = userService.login("dummy", IVAN.getPassword());
            assertTrue(maybeUser.isEmpty());
            System.out.println(maybeUser + " is empty?");
        }

        @Test
        void checkLoginFunctionalityPerformance() {
            var result = assertTimeout(Duration.ofMillis(200L), () -> {
                Thread.sleep(100);
                return userService.login("dummy", IVAN.getPassword());
            });
        }

        @Disabled("flaky, need to see")
        @Test
        @Order(1)
        void loginFailIIfPasswordIsNotCorrect() {
            userService.add(IVAN);
            var maybeUser = userService.login(IVAN.getUsername(), "dummy");
            assertTrue(maybeUser.isEmpty());

        }

    }

    static Stream<Arguments> getArgumentsForLoginTest() {
        return Stream.of(
                Arguments.of("Ivan", "123", Optional.of(IVAN)),
                Arguments.of("Petr", "111", Optional.of(PETR)),
                Arguments.of("Petr", "dummy", Optional.empty()),
                Arguments.of("dummy", "123", Optional.empty())
        );

    }
//    @Test
//    @DisplayName("Should return true when the user is deleted")
//    void deleteWhenUserIsDeletedThenReturnTrue() {
//        userService.add(IVAN);
//        var result = userService.delete(IVAN.getId());
//        assertTrue(result);
//    }

    @Test
    @DisplayName("Should return false when the user is not deleted")
    void deleteWhenUserIsNotDeletedThenReturnFalse() {
        when(userDao.delete(anyInt())).thenReturn(false);
        assertFalse(userService.delete(1));
    }
}
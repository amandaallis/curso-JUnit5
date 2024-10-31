package domain;

import org.example.domain.Account;
import org.example.domain.User;
import org.example.domain.builder.AccountBuilder;
import org.example.domain.builderMaster.UserBuilder;
import org.example.domain.exceptions.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class AccountTest {

    @Test
    public void shouldCreateValidAccount() {
        Account account = AccountBuilder.oneAccount().now();
        User expectedUser = UserBuilder.oneUser().now();
        Assertions.assertAll("Count",
                () -> Assertions.assertEquals(1L, account.getId()),
                () -> Assertions.assertEquals("Conta Corrente", account.getName()),
                () -> Assertions.assertEquals(expectedUser, account.getUser())

        );
    }

    @ParameterizedTest
    @MethodSource(value = "dataProvider") //Vou precisar utilizar o methodSource devido ao objeto User passado.
    public void shouldRejectInvalidAccount(Long id, String name, User user, String message) {
        Exception exception = Assertions.assertThrows(ValidationException.class,
                () -> AccountBuilder.oneAccount().withId(id).withName(name).withUser(user).now()
        );
        Assertions.assertEquals(message, exception.getMessage());
    }

    private static List<Arguments> dataProvider() { //It was Stream, but now I used List and it works.
        return List.of(
                Arguments.of(1L, null, UserBuilder.oneUser().now(), "Name is required"),
                Arguments.of(1L, "Valid Account", null, "User is required")
        );
    }
}

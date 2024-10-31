package domain;

import org.example.domain.User;
import org.example.domain.builderMaster.UserBuilder;
import org.example.domain.exceptions.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.UUID;

public class UserTest {

    @Test
    @DisplayName("Deve criar um usuário válido")
    public void shouldCreateValidUser() {
        User user;
        user = UserBuilder.oneUser().now();

        Assertions.assertAll("User",
                () -> Assertions.assertEquals("Amanda Allis", user.getName()),
                () -> Assertions.assertEquals("123", user.getPassword())
        );
    }

    @Test
    public void shouldRejectedUserWithoutName() {
        ValidationException isException = Assertions.assertThrows(ValidationException.class, () ->
            UserBuilder.oneUser().withName(null).now());
        Assertions.assertEquals("Name is required", isException.getMessage());
    }

    @Test
    public void shouldRejectUserWithoutEmail() {
        ValidationException isException = Assertions.assertThrows(ValidationException.class, () ->
                UserBuilder.oneUser().withEmail(null).now()
        );
        Assertions.assertEquals("Email is required", isException.getMessage());
    }

    @Test
    public void shouldRejectUserWithoutPassword() {
        ValidationException isException = Assertions.assertThrows(ValidationException.class, () ->
                UserBuilder.oneUser().withPassword(null).now()
        );
        Assertions.assertEquals("Password is required", isException.getMessage());
    }

    @ParameterizedTest
    @NullSource
    public void shouldRejectWithItemsNull(String item) {
        ValidationException isException = Assertions.assertThrows(ValidationException.class, () ->
                UserBuilder.oneUser().withEmail(item).now()
        );
        Assertions.assertEquals("Email is required", isException.getMessage());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src\\test\\resources\\RequiredFieldsUser.csv", nullValues = "null")
    public void shouldValidateRequiredFields(String email, String password, UUID id, String messageError) {
        ValidationException isException = Assertions.assertThrows(ValidationException.class, () ->
                UserBuilder.oneUser()
                        .withEmail(email)
                        .withPassword(password)
                        .withId(id)
                        .now()
        );
        Assertions.assertEquals(messageError, isException.getMessage());


    }





}

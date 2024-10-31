package org.example.domain.builderMaster;

import org.example.domain.User;

import java.util.UUID;

public class UserBuilder {
    private UUID id;
    private String name;
    private String email;
    private String password;

    private UserBuilder(){}

    public static UserBuilder oneUser() {
        UserBuilder builder = new UserBuilder();
        initializationData(builder);
        return builder;
    }

    private static void initializationData(UserBuilder builder) {
        builder.id = UUID.fromString("123e4567-e89b-12d3-a456-556642440000");
        builder.name = "Amanda Allis";  // Altere para "Amanda Allis"
        builder.email = "amandaallis70@gmail.com";  // Altere para "amandaallis70@gmail.com"
        builder.password = "123";
    }

    public UserBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public User now() {
        return new User(id, name, email, password);
    }
}

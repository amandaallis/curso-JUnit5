package org.example.domain.builder;

import org.example.domain.User;

import java.util.UUID;

public class UserBuilder {
    private UUID id;
    private String name;
    private String email;
    private String password;

    private UserBuilder() {}

    public static UserBuilder oneUser() {
        UserBuilder userBuilder = new UserBuilder();
        initializationData(userBuilder);
        return userBuilder;
    }

    private static void initializationData(UserBuilder userBuilder) {
        userBuilder.id = UUID.randomUUID();
        userBuilder.email = "amandaallis70@gmail.com";
        userBuilder.name = "Amanda";
        userBuilder.password = "123";
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

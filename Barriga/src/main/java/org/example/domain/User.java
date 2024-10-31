package org.example.domain;

import org.example.domain.exceptions.ValidationException;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;

    public User(UUID id, String name, String email, String password) {
        verifyAllItems(id, name, email, password);

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private void verifyAllItems(UUID id, String name, String email, String password) {
        if (id == null) throw new ValidationException("Id is required");
        if (email == null) throw new ValidationException("Email is required");
        if (password == null) throw new ValidationException("Password is required");
        if(name == null) throw new ValidationException("Name is required");
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password);
    }
}

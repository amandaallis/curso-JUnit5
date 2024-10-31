package org.example.domain;

import org.example.domain.exceptions.ValidationException;

public class Account {
    private Long id;
    private String name;
    private User user;

    public Account(Long id, String name, User user) {
        verifyAllItems(name, user);
        this.id = id;
        this.name = name;
        this.user = user;
    }

    private void verifyAllItems(String name, User user) {
        if(name == null) throw new ValidationException("Name is required");
        if(user == null) throw new ValidationException("User is required");
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

}

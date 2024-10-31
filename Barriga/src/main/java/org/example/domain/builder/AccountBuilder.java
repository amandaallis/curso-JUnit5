package org.example.domain.builder;

import org.example.domain.User;
import org.example.domain.Account;
import org.example.domain.builderMaster.UserBuilder;

import java.util.UUID;

public class AccountBuilder {
    private Long id;
    private String name;
    private User user;

    private AccountBuilder(){}

    public static AccountBuilder oneAccount() {
        AccountBuilder builder = new AccountBuilder();
        initializationData(builder);
        return builder;
    }

    private static void initializationData(AccountBuilder builder) {
        builder.id = 1L;
        builder.name = "Conta Corrente";
        builder.user = UserBuilder.oneUser().now();
    }

    public AccountBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public AccountBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AccountBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public Account now() {
        return new Account(id, name, user);
    }
}
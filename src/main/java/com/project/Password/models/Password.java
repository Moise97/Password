package com.project.Password.models;

import java.util.Objects;
import java.util.StringJoiner;

public class Password {

    private String password;

    String getPassword() {
        return password;
    }

    public Password setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return Objects.equals(password, password1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Password.class.getSimpleName() + "[", "]")
                .add("password='" + password + "'")
                .toString();
    }
}

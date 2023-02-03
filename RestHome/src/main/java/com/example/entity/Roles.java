package com.example.entity;

public enum Roles {
    ADMIN("ADMIN"),
    USER("USER"),
    SUPERVISOR("SUPERVISOR");

    private final String roleName;

    Roles(String roleName) {
        this.roleName = roleName;
    }

}

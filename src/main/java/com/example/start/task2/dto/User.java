package com.example.start.task2.dto;

import lombok.Value;

@Value(staticConstructor = "of")
public class User {
    Integer id;
    String username;
    String password;
}

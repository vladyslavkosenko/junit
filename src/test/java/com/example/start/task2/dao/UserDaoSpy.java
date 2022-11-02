package com.example.start.task2.dao;

import java.util.HashMap;
import java.util.Map;

public class UserDaoSpy extends UserDao {
    private final UserDao userDao;

    public UserDaoSpy(UserDao userDao) {
        this.userDao = userDao;
    }

    private Map<Integer, Boolean> answers = new HashMap<>();

    // private Answer1<Integer, Boolean> answer1;
    @Override
    public boolean delete(Integer userId) {
       // invocation++
        return answers.getOrDefault(userId, userDao.delete(userId));
    }
}

package com.twu.library.domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> users;

    public Users() {
        this.users = new ArrayList<User>();
    }

    public List<User> getUsers() {
        return this.users;
    }

    public List<User> createPredefinedUsers() {
        User firstUser = new User("111-1111", "123456", "User1", "email@test.com", "1111-1111");
        this.users.add(firstUser);
        User secondUser = new User("222-2222", "123456", "User2", "email2@test.com", "2222-2222");
        this.users.add(secondUser);
        User thirdUser = new User("333-3333", "123456", "User3", "email3@test.com", "3333-3333");
        this.users.add(thirdUser);

        return this.users;
    }
}

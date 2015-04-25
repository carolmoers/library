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
        User firstUser = new User("111-1111", "123456", "Steven Universe", "esteven@universe.com", "3218-4675");
        this.users.add(firstUser);
        User secondUser = new User("222-2222", "123456", "Princess Bubblegum", "bubblegum@adventure.com", "3284-6571");
        this.users.add(secondUser);
        User thirdUser = new User("333-3333", "123456", "Finn the Human", "finn3@adventure.com", "3761-4829");
        this.users.add(thirdUser);

        return this.users;
    }
}

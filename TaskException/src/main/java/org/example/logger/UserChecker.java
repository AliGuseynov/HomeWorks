package org.example.logger;

import org.example.exceptions.UserException;

import java.util.HashSet;
import java.util.Set;

public class UserChecker {
    public static Set<String> userSet = new HashSet<>();


    public static void createUser(String name) throws UserException {

        if (userSet.contains(name)){
            throw new UserException("User exists");
        }
        userSet.add(name);
    }

}

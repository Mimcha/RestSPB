package org.example.demo;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private static final Map<String, String> userPasswords = new HashMap<>();
    private static final Map<String, List<Authorities>> userAuthorities = new HashMap<>();

    static {
        userPasswords.put("user1", "password1");
        userPasswords.put("user2", "password2");

        userAuthorities.put("user1", Arrays.asList(Authorities.READ, Authorities.WRITE));
        userAuthorities.put("user2", Arrays.asList(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userPasswords.containsKey(user) && userPasswords.get(user).equals(password)) {
            return userAuthorities.get(user);
        }
        return Collections.emptyList();
    }
}

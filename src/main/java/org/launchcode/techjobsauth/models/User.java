package org.launchcode.techjobsauth.models;

import jakarta.persistence.Entity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends AbstractEntity{
    private String username;

    private String pwhash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.pwhash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password){
        return encoder.matches(password, pwhash);
    }

}

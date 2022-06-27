package com.example.listapp.Auth;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@Component
public class LoggedUser implements HttpSessionBindingListener {
    private String username;

    public LoggedUser() {
    }

    public LoggedUser(String username) {
        this.username = username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        username = ((LoggedUser) event.getValue()).getUsername();
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        if(username == ((LoggedUser) event.getValue()).getUsername()) {
            username = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoggedUser{" +
                "username='" + username + '\'' +
                '}';
    }
}


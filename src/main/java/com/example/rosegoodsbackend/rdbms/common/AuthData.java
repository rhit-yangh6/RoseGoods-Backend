package com.example.rosegoodsbackend.rdbms.common;

import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.Map;

// Taken from senior project RoseQuarry
public class AuthData {


    public enum Group {
        STUDENT,
        INSTRUCTOR,
        OTHER,
        SYSADMIN
    }

    private final String name;
    private final String username;
    private final String provider;
    private final Date issuedAt;
    private final Group group;
    private final Map<String, Object> authData;

    public AuthData(Claims claims) {
        authData = claims.get("d", Map.class);
        issuedAt = claims.getIssuedAt();
        String group = null;
        if (authData.get("group") != null) {
            group = (String) authData.get("group");
        }
        this.username = (String) authData.get("uid");
        this.name = (String) authData.get("name");
        this.provider = (String) authData.get("provider");
        if (group != null) {
            if (group.equalsIgnoreCase("STUDENT")) {
                this.group = Group.STUDENT;
            } else if (group.equalsIgnoreCase("INSTRUCTOR")) {
                this.group = Group.INSTRUCTOR;
            } else if (group.equalsIgnoreCase("SYSADMIN")) {
                this.group = Group.SYSADMIN;
            } else {
                this.group = Group.OTHER;
            }
        } else {
            this.group = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getProvider() {
        return provider;
    }

    public String getEmail() {
        return username + "@rose-hulman.edu";
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public Group getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getAuthPayload() {
        return authData;
    }


}

package com.xing.springDataJpa.dto;

/**
 * 功能描述
 *
 * @since 2020-07-03
 */
public class UserDto {
    private String username;
    private String userage;
    private String userphone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", userage='" + userage + '\'' +
                ", userphone='" + userphone + '\'' +
                '}';
    }
}

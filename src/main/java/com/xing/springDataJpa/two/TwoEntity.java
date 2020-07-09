package com.xing.springDataJpa.two;

import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 功能描述
 *
 * @since 2020-07-06
 */
@Entity
@Table(name = "t_two")
public class TwoEntity {
    private String userid;
    private String username;
    private String userage;
    private String userphone;

    @Id
    @Column(name = "userid")
    @GeneratedValue(generator = "id_sequence")
    @GenericGenerator(name = "id_sequence",strategy = "uuid2")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userage")
    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    @Basic
    @Column(name = "userphone")
    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoEntity that = (TwoEntity) o;
        return Objects.equals(userid, that.userid) &&
                Objects.equals(username, that.username) &&
                Objects.equals(userage, that.userage) &&
                Objects.equals(userphone, that.userphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, userage, userphone);
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", userage='" + userage + '\'' +
                ", userphone='" + userphone + '\'' +
                '}';
    }
}

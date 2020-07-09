package com.xing.springDataJpa.first;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

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
@Table(name = "t_first")
public class FirstEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "id_sequence")
    @GenericGenerator(name = "id_sequence",strategy = "uuid2")
    private String userId;
    private String userName;
    private String userAge;
    private String userPhone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}

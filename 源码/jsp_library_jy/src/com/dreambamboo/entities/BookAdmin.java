package com.dreambamboo.entities;

import java.io.Serializable;

/**
 * @ClassName：BookAdmin
 * @Description：图书馆管理员实体类
 * @Author：dreambamboo
 * @Date：2019/1/6 22:16
 * @version：1.0
 */
public class BookAdmin implements Serializable {
    //编号
    private int id;
    //用户名
    private String username;
    //密码
    private String password;

    public BookAdmin() {
    }

    public BookAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.dreambamboo.entities;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName：BookCase
 * @Description：图书类目实体类
 * @Author：dreambamboo
 * @Date：2019/1/6 22:21
 * @version：1.0
 */
public class BookCase implements Serializable {
    //编号
    private int id;
    //图书类目名
    private String name;


    private List<Book> books;

    public BookCase() {
    }

    public BookCase(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

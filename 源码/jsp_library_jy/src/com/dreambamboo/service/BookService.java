package com.dreambamboo.service;

import com.dreambamboo.entities.Book;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * @ClassName：BookService
 * @Description：图书逻辑控制层
 * @Author：dreambamboo
 * @Date：2019/1/6 22:48
 * @version：1.0
 */
public interface BookService {
    /*
     * @Author com.dreambamboo
     * @Description 查询所有的图书信息
     * @Date 22:49 2019/1/6
     * @Param []
     * @return java.util.List<com.com.dreambamboo.entities.Book>
     */
    List<Book> findAllBooks(int page,int limit);
    int findBookCount();
    Book findBookById(int bookId);
    void addBook(Book book);
    void modifyBook(Book book);
    void deleteBookById(int bookId);
    HSSFWorkbook findWorkBook();
}

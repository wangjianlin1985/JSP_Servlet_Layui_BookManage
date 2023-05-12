package com.dreambamboo.repository;

import com.dreambamboo.entities.Book;

import java.util.List;

/**
 * @ClassName：BookRepository
 * @Description：图书数据访问层
 * @Author：dreambamboo
 * @Date：2019/1/6 22:28
 * @version：1.0
 */
public interface BookRepository {
    /*
     * @Author com.dreambamboo
     * @Description 添加图书信息
     * @Date 22:37 2019/1/6
     * @Param [book]
     * @return void
     */
    void save(Book book);
   /*
    * @Author com.dreambamboo
    * @Description 根据图书编号删除图书信息
    * @Date 22:37 2019/1/6
    * @Param [id]
    * @return void
    */
    void deleteById(int id);
    /*
     * @Author com.dreambamboo
     * @Description 修改图书信息
     * @Date 22:37 2019/1/6
     * @Param
     * @return
     */
    void update(Book book);
    /*
     * @Author com.dreambamboo
     * @Description 根据图书编号查询图书信息
     * @Date 22:38 2019/1/6
     * @Param [id]
     * @return com.com.dreambamboo.entities.Book
     */
    Book selectById(int id);
    /*
     * @Author com.dreambamboo
     * @Description 查询所有的图书信息
     * @Date 22:39 2019/1/6
     * @Param []
     * @return java.util.List<com.com.dreambamboo.entities.Book>
     */
    List<Book> selectAll(int start,int limit);
    /*
     * @Author com.dreambamboo
     * @Description 获取图书的数量
     * @Date 22:53 2019/1/6
     * @Param []
     * @return int
     */
    int selectBooksCount();
    /*
     * @Author:dreambamboo
     * @Description:定义获取所有图书的数量的方法  用于导出数据使用
     * @Date:2019/1/10 14:00
     * @Param:[]
     * @return:java.util.List<com.dreambamboo.entities.Book>
     */
    List<Book> selectAllBooksForPoi();
}

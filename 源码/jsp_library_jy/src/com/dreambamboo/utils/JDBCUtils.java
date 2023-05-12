package com.dreambamboo.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName：JDBCUtils
 * @Description：数据库资源工具类
 * @Author：dreambamboo
 * @Date：2019/1/6 22:04
 * @version：1.0
 */
public class JDBCUtils {
    private static DataSource dataSource = null;
    private static Connection connection = null;
    static {
        dataSource = new ComboPooledDataSource("library-config");
    }
    /**
     * @Author com.dreambamboo
     * @Description 获取数据库连接对象
     * @Date 21:45 2019/1/6
     * @Param []
     * @return java.sql.Connection
     **/

    public static Connection getConnection(){
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * @Author com.dreambamboo
     * @Description 释放数据库连接资源
     * @Date 21:45 2019/1/6
     * @Param [connection, statement, resultSet]
     * @return void
     **/

    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}

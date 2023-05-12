package com.dreambamboo.repository;

import com.dreambamboo.entities.BookAdmin;
import com.dreambamboo.entities.Reader;
/**
 * @Author:dreambamboo
 * @Description:账户数据接口
 * @Date:2019/1/11 11:30
 * @Param:
 * @return:
 */
public interface AccountRepository {
     BookAdmin adminLogin(String username, String password);
     Reader readerLogin(String username, String password);
}

package com.dreambamboo.repository;

import com.dreambamboo.entities.BookCase;
import com.dreambamboo.entities.Borrow;
import com.dreambamboo.entities.ReturnBook;
import com.dreambamboo.vo.BookBarData;
import com.dreambamboo.vo.BookPieData;

import java.util.List;

public interface BookAdminRepository {
    void saveBookCase(BookCase bookCase);
    void deleteBookCaseById(int bookCaseId);
    void updateBookCase(BookCase bookCase);
    BookCase selectBookCaseById(int bookCaseId);
    List<BookCase> selectAllBookCases();
    List<BookCase> selectAllBookCasesByPage(int start,int limit);
    int selectAllCount();


    void updateBorrow(Borrow borrow);



    void saveReturnBook(ReturnBook returnBook);

    List<ReturnBook> selectAllReturns();

    int selectReturnCount();

    ReturnBook selectReturnById(int returnId);

    void updateReturn(ReturnBook returnBook);

    BookBarData selectBookBarData();
    List<BookPieData> selectBookPieData();
}

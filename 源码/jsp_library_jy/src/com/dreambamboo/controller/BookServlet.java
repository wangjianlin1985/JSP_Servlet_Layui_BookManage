package com.dreambamboo.controller;

import com.dreambamboo.entities.Book;
import com.dreambamboo.entities.BookCase;
import com.dreambamboo.service.BookAdminService;
import com.dreambamboo.service.BookService;
import com.dreambamboo.service.impl.BookAdminServiceImpl;
import com.dreambamboo.service.impl.BookServiceImpl;
import com.dreambamboo.vo.BookVO;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName：BookServlet
 * @Description：图书控制层
 * @Author：dreambamboo
 * @Date：2019/1/6 22:23
 * @version：1.0
 */
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        BookService bookService = new BookServiceImpl();
        BookAdminService bookAdminService = new BookAdminServiceImpl();
        Book book;
        String bookIdStr;
        List<BookCase> bookCaseList;
        String name;
        String author;
        String publish;
        String pageStr;
        String priceStr;
        String bookCaseId;
        BookCase bookCase;
        //查询图书
        if (method == null){
            resp.setCharacterEncoding("utf-8");
            pageStr = req.getParameter("page");
            String limitStr = req.getParameter("limit");
            List<Book> bookList = bookService.findAllBooks(Integer.valueOf(pageStr),Integer.valueOf(limitStr));
            BookVO bookVO = new BookVO();
            bookVO.setCode(0);
            bookVO.setMsg(null);
            bookVO.setCount(bookService.findBookCount());
            bookVO.setData(bookList);
            JSONObject jsonObject = JSONObject.fromObject(bookVO);
            resp.getWriter().write(jsonObject.toString());
        } else {
            switch (method) {
                //编辑图书
                case "preEdit":
                    bookIdStr = req.getParameter("bookId");
                    book = bookService.findBookById(Integer.valueOf(bookIdStr));
                    req.setAttribute("book",book);
                    bookCaseList = bookAdminService.findAllBookCase();
                    req.setAttribute("bookCaseList",bookCaseList);
                    req.getRequestDispatcher("/book/book-edit.jsp").forward(req,resp);
                    break;
                case "edit":
                    bookIdStr = req.getParameter("id");
                    name = req.getParameter("name");
                    author = req.getParameter("author");
                    publish = req.getParameter("publish");
                    pageStr = req.getParameter("pages");
                    priceStr = req.getParameter("price");
                    bookCaseId = req.getParameter("bookCaseId");
                    bookCase = bookAdminService.findBookCaseById(Integer.valueOf(bookCaseId));
                    book = new Book();
                    book.setId(Integer.valueOf(bookIdStr));
                    book.setName(name);
                    book.setAuthor(author);
                    book.setPublish(publish);
                    book.setPages(Integer.valueOf(pageStr));
                    book.setPrice(Float.valueOf(priceStr));
                    book.setBookCase(bookCase);
                    book.setAbled(1);
                    bookService.modifyBook(book);
                    resp.sendRedirect(req.getContextPath()+"/book/book-list.jsp");
                    break;
                //添加图书
                case "preAdd":
                    bookCaseList = bookAdminService.findAllBookCase();
                    req.setAttribute("list",bookCaseList);
                    req.getRequestDispatcher("/book/book-add.jsp").forward(req,resp);
                    break;
                case "add":
                    name = req.getParameter("name");
                    author = req.getParameter("author");
                    publish = req.getParameter("publish");
                    pageStr = req.getParameter("pages");
                    priceStr = req.getParameter("price");
                    bookCaseId = req.getParameter("bookCaseId");
                    bookCase = bookAdminService.findBookCaseById(Integer.parseInt(bookCaseId));
                    book = new Book(name,Integer.parseInt(pageStr),Float.parseFloat(priceStr),publish,author,bookCase,1);
                    bookService.addBook(book);
                    resp.sendRedirect(req.getContextPath()+"/book/book-list.jsp");
                    break;
                //删除图书
                case "delete":
                    bookIdStr = req.getParameter("bookId");
                    book = bookService.findBookById(Integer.parseInt(bookIdStr));
                    book.setBookCase(null);
                    bookService.deleteBookById(Integer.parseInt(bookIdStr));
                    resp.sendRedirect(req.getContextPath()+"/book/book-list.jsp");
                    break;

            }
        }
    }
}

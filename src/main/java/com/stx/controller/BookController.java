package com.stx.controller;

import com.stx.pojo.Books;
import com.stx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 层掉service
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍，并返回一个页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    //跳转新增书籍页面
    @RequestMapping("/addBook")
    public String addBook() {
        return "addBook";
    }

    //添加书籍请求
    @RequestMapping("/addBooks")
    public String addBooks(Books books) {
        bookService.addBook(books);
        return "redirect:/book/allBook";//重定向到@RequestMapping("/allBook")
    }

    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String UpdatePaper(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("Qbook", books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println(books);
        int i = bookService.updateBook(books);
        if (i > 0) {
            System.out.println("chenggong" + books);
        }
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }



}

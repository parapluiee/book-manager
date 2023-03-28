package com.csc340sp23.bookmanager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/all")
    public String getAllBooks(Model model){
        model.addAttribute("bookList", service.getAllBooks());
        return "book/list-books.html";
    }

    @GetMapping("/id={id}")
    public String getBook(@PathVariable long id, Model model){
        model.addAttribute("book", service.getBook(id));
        return "book/book-detail";
    }

    @GetMapping("delete/id={id}")
    public String deleteBook(@PathVariable long id, Model model) {
        service.deleteBook(id);
        return "redirect:/book/all";
    }

    @PostMapping("/create")
    public String createBook(Book book){
        service.saveBook(book);
        return "redirect:/book/all";
    }

    @GetMapping("/new-book")
    public String newBookForm(Model model){
        return "book/new-book";
    }

    @GetMapping("/update-book")
    public String updateBookForm(Model model){ return "book/update-book.html"; }

    @GetMapping("/update/id={id}")
    public String updateBookForm(@PathVariable long id, Model model) {
        model.addAttribute("book", service.getBook(id));
        return "book/update-book";
    }

    @PostMapping("/update-book")
    public String updateBook(Job job){
        service.updateBook(book);
        return "redirect:/book/all";
    }
}

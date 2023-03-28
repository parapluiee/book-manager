package com.csc340sp23.bookmanager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookService {
    @Autowired
    BookRepository repo;

    List<Book> getAllBooks(){
        return repo.findAll();
    }

    Object getBook(long id){
        return repo.getBookById(id);
    }

    void deleteBook(long id){
        repo.deleteBookById(id);
    }

    void saveBook(Book book){
        repo.saveBook(book);
    }

    void updateBook(Book book){
        repo.updateBook(book);
    }
}

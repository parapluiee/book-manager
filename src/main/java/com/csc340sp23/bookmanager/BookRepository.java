package com.csc340sp23.bookmanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class BookRepository {
    @Autowired
    NamedParameterJdbcTemplate template;

    List<Book> findAll() {
        String query = "select id, title, author, price, isb from book";
        return template.query(query,
                (result, rowNum)
                -> new Book(result.getLong("id"), result.getString("title"), result.getString("author"), result.getString("isb"), result.getDouble("price")));
    }

    public Book getBookById(long id){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        String query = "select * from book where id=:id";
        return template.queryForObject(query, namedParameters, BeanPropertyRowMapper.newInstance(Book.class));
    }

    public int saveBook(Book book){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", book.getTitle());
        paramMap.put("author", book.getAuthor());
        paramMap.put("isb", book.getIsb());
        paramMap.put("price", book.getPrice());
        String query = "INSERT INTO book(title, author, isb, price) VALUES(:title, :author, :isb, :price)";
        return template.update(query, paramMap);
    }

    void deleteBookById(long id){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        String query = "delete from book where id=:id";
        template.update(query, namedParameters);
    }
    void updateBook(Book book){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", book.getId());
        paramMap.put("title", book.getTitle());
        paramMap.put("author", book.getAuthor());
        paramMap.put("isb", book.getIsb());
        paramMap.put("price", book.getPrice());
        String query = "update book set title=:title, author=:author, isb=:isb, price=:price where id=:id";
        template.update(query, paramMap);
    }
}

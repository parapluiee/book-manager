package com.csc340sp23.bookmanager;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private String isb;
    private double price;

    Book(String title, String author, String isb, double price) {
        this.title = title;
        this.author = author;
        this.isb = isb;
        this.price = price;
    }
    public long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsb(){
        return isb;
    }

    public double getPrice(){
        return price;
    }

}


package com.system.design.entity.dto;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.var;

@Data
public class Book {
    private String title;
    private String author;

    public static Book create() {
        var fakerBook = Faker.instance().book();
        Book book = new Book();
        book.setTitle(fakerBook.title());
        book.setAuthor(fakerBook.author());
        return book;
    }
}

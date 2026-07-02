package com.gautamthapa.javapractice.designpatterns.prototypepattern;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {
    private String shopName;
    List<Book> books = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadData() {
        for (int i = 1; i <= 10; i++) {
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("Book " + i);
            getBooks().add(book);
        }
    }

// This is shallow cloning
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    // This is deep cloning


    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        BookShop bookShop = new BookShop();
        for (Book book : this.getBooks()) {
            bookShop.getBooks().add(book);
        }

        // clone whole object
        // return this;

        return bookShop;
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }
}

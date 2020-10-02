package com.example.retrobookit.model;

public class Book {
    private String bookName;
    private String bookAuthorName;
    private String bookPrice;
    private String bookDescription;
    private int bookImageId;

    public Book(String bookName, String bookAuthorName, String bookPrice, String bookDescription, int bookImageId) {
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
        this.bookPrice = bookPrice;
        this.bookDescription = bookDescription;
        this.bookImageId = bookImageId;
    }
    public Book(String bookName, String bookAuthorName, String bookPrice,  int bookImageId) {
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
        this.bookPrice = bookPrice;
        this.bookImageId = bookImageId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getBookImageId() {
        return bookImageId;
    }

    public void setBookImageId(int bookImageId) {
        this.bookImageId = bookImageId;
    }
}

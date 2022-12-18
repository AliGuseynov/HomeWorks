package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookInstance {
    private int id;
    private Book book;
    private boolean inStock = true;
    private Branch branch;

    public BookInstance(int id, Book book) {
        this.id = id;
        this.book = book;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranches(Branch branches) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "BookInstance{" +
                "id=" + id +
                ", book=" + book +
                ", inStock=" + inStock +
                ", branch=" + branch +
                '}';
    }
}

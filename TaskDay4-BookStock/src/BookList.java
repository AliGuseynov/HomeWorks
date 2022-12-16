<<<<<<< HEAD
public class BookList {
    private String book;
    private String author;
    private String publisher;
    BookInstance bookInstance;
    Store store;
    private String branch;
    private int count;

    public BookList(){}

    public BookList(String book, String author, String publisher, BookInstance bookInstance, Store store, String branch){
        this.book = book;
        this.author = author;
        this.publisher = publisher;
        this.bookInstance = bookInstance;
        this.store = store;
        this.branch = branch;
    }

    public BookList(String book, String author, String publisher, Store store, String branch, int count){
        this.book = book;
        this.author = author;
        this.publisher = publisher;
        this.store = store;
        this.branch = branch;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getBook() {
        return book;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setBookInstance(BookInstance bookInstance) {
        this.bookInstance = bookInstance;
    }

    public String getBookInstance() {
        return bookInstance.getSerialNumber() + " " +bookInstance.getType();
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public String toString(){
        return book + " " + author + ", " + publisher + ". " + getBookInstance() + " " + store + " " + branch;
    }

    public String details(){
        return "Əsər: " + book +
                "\nMüəllif: " + author +
                "\nNəşr: " + publisher +
                "\nSeria nömrəsi: " + bookInstance.getSerialNumber() +
                "\nStatusu: " + bookInstance.type +
                "\nMağaza: " + store +
                "\nDepartament: " + branch;
    }




}
=======
public class BookList {
    private String book;
    private String author;
    private String publisher;
    BookInstance bookInstance;
    Store store;
    private String branch;
    private int count;

    public BookList(){}

    public BookList(String book, String author, String publisher, BookInstance bookInstance, Store store, String branch){
        this.book = book;
        this.author = author;
        this.publisher = publisher;
        this.bookInstance = bookInstance;
        this.store = store;
        this.branch = branch;
    }

    public BookList(String book, String author, String publisher, Store store, String branch, int count){
        this.book = book;
        this.author = author;
        this.publisher = publisher;
        this.store = store;
        this.branch = branch;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getBook() {
        return book;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setBookInstance(BookInstance bookInstance) {
        this.bookInstance = bookInstance;
    }

    public String getBookInstance() {
        return bookInstance.getSerialNumber() + " " +bookInstance.getType();
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public String toString(){
        return book + " " + author + ", " + publisher + ". " + getBookInstance() + " " + store + " " + branch;
    }

    public String details(){
        return "Əsər: " + book +
                "\nMüəllif: " + author +
                "\nNəşr: " + publisher +
                "\nSeria nömrəsi: " + bookInstance.getSerialNumber() +
                "\nStatusu: " + bookInstance.type +
                "\nMağaza: " + store +
                "\nDepartament: " + branch;
    }




}
>>>>>>> 91bcfde6ff088c03f7a39087e1ef5fe01b4e1794

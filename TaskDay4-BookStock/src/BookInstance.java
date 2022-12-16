<<<<<<< HEAD
public class BookInstance {
    private int serialNumber;
    StockType type;
    private String bookName;

    public BookInstance() {
    }

    public BookInstance(String bookName, int serialNumber, StockType type) {
        this.bookName = bookName;
        this.serialNumber = serialNumber;
        this.type = type;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setType(StockType type) {
        this.type = type;
    }

    public StockType getType() {
        return type;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String instanceDetails() {
        return "Əsər: " + bookName +
                "\nSeria nömrəsi: " + getSerialNumber() +
                "\nStatusu: " + type;
    }
=======
public class BookInstance {
    private int serialNumber;
    StockType type;
    private String bookName;

    public BookInstance() {
    }

    public BookInstance(String bookName, int serialNumber, StockType type) {
        this.bookName = bookName;
        this.serialNumber = serialNumber;
        this.type = type;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setType(StockType type) {
        this.type = type;
    }

    public StockType getType() {
        return type;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String instanceDetails() {
        return "Əsər: " + bookName +
                "\nSeria nömrəsi: " + getSerialNumber() +
                "\nStatusu: " + type;
    }
>>>>>>> 91bcfde6ff088c03f7a39087e1ef5fe01b4e1794
}
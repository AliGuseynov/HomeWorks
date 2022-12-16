package Homework3;

public class Library {
     static String name;
    static String authorName;
    static String publishedYear;
    static int pageCount;


    public Library() {
    }

    public Library(String name, String authorName, String publishedYear, int pageCount) {
                this.name = name;
                this.authorName = authorName;
                this.publishedYear = publishedYear;
                setPageCount(pageCount);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String publishedYear() {
        return publishedYear;
    }

    public void publishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if(pageCount>10){
            this.pageCount = pageCount;
        }

    }

    public static String bookCall(String bookName){
        if(bookName == name){
            return "Əsər adı : "+ name+"\n"+
                    "Müəllif : "+authorName+"\n"+
                    "Nəşr ili : " +publishedYear+"\n"+
                    "Səhifə sayı : "+ pageCount;
        }
        return "there is no this kind of book";
    }

    @Override
    public String toString() {
        return   authorName +
                " '" + name + '\'' +" "+
                publishedYear+"\n"
                ;
    }
}

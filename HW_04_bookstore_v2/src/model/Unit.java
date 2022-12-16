package model;

public class Unit {
    private String header;
    private int pageCount;
    private String body;

    public Unit() {
    }

    public Unit(String header, int pageCount, String body) {
        this.header = header;
        this.pageCount = pageCount;
        this.body = body;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getBody() {
        return body;
    }



    public void setBody(String body) {
        this.body = body;
    }

    public String getDetails(){


        return "Unit{" +
                "header='" + header + '\'' +
                ", pageCount=" + pageCount +
                ", body='" + body + '\'' +
                '}' +
                "--------------------------------";
    }

    @Override
    public String toString() {
        return  "\t" +
                "header='" + header + '\'' +
                ", pageCount=" + pageCount +
                ", body='" + body + '\'';
    }
}

package FileTask.Task1;

public class CarNum implements Comparable<CarNum>{
    private int prefix;
    private String seria;
    private int suffix;

    public CarNum() {
    }

    public CarNum(int prefix, String seria, int suffix) {
        this.prefix = prefix;
        this.seria = seria;
        this.suffix = suffix;
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public int getSuffix() {
        return suffix;
    }

    public void setSuffix(int suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return "CarNum{" +
                "prefix=" + prefix +
                ", seria='" + seria + '\'' +
                ", suffix=" + suffix +
                '}';
    }

    @Override
    public int compareTo(CarNum o) {
        if (!o.seria.equals(this.seria)){
            return o.seria.compareTo(this.seria);
        }else if(o.prefix!=this.prefix){
            return o.prefix=this.prefix;
        }else {
            return o.suffix=this.suffix;
        }
    }
}

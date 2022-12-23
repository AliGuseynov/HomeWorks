package az.code.models;

import java.util.regex.Pattern;

public class CarNumber implements Comparable<CarNumber> {
    private int prefix;
    private String seria;
    private int suffix;

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

    public CarNumber(int prefix, String seria, int suffix) {
        this.prefix = prefix;
        this.seria = seria;
        this.suffix = suffix;
    }

    @Override
    public int compareTo(CarNumber o) {
        if(!o.seria.equals(this.seria)){
            return o.seria.compareTo(this.seria);
        }else if(o.prefix != this.prefix ){
            return o.prefix - this.prefix;
        }else{
            return o.suffix - this.suffix;
        }
    }

    @Override
    public String toString() {
        return "CarNumber{" +
                "prefix=" + prefix +
                ", seria='" + seria + '\'' +
                ", suffix=" + suffix +
                '}';
    }

    public static CarNumber createCarNumber(String number){
        Pattern carNumberPattern = Pattern.compile("^\\d{2}[a-zA-Z]{2}\\d{3}$");
        CarNumber result = null;
        if(carNumberPattern.matcher(number).matches()){
            result = new CarNumber(Integer.parseInt(number.substring(0, 2)), number.substring(2, 4), Integer.parseInt(number.substring(4)));
        }
        return result;
    }
}

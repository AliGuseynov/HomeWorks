package az.code.Task1;

import java.util.regex.Pattern;

public class CarNumber implements Comparable<CarNumber>{
    private int prefix;
    private String serialPart;
    private int suffix;

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public String getSerialPart() {
        return serialPart;
    }

    public void setSerialPart(String serialPart) {
        this.serialPart = serialPart;
    }

    public int getSuffix() {
        return suffix;
    }

    public void setSuffix(int suffix) {
        this.suffix = suffix;
    }

    public CarNumber(int prefix, String serialPart, int suffix) {
        this.prefix = prefix;
        this.serialPart = serialPart;
        this.suffix = suffix;
    }

    @Override
    public int compareTo(CarNumber o) {
        if(!o.serialPart.equals(this.serialPart)){
            return o.serialPart.compareTo(this.serialPart);
        }else if(o.prefix != this.prefix ){
            return o.prefix - this.prefix;
        }else{
            return o.suffix - this.suffix;
        }
    }


    @Override
    public java.lang.String toString() {
        return "CarNumber{" +
                "prefix=" + prefix +
                ", serialPart='" + serialPart + '\'' +
                ", suffix=" + suffix +
                '}';
    }


    public static CarNumber createCarNumber(String number) {
        Pattern carNumberPattern = Pattern.compile("^\\d{2}[a-zA-Z]{2}\\d{3}$");
        CarNumber result = null;
        if(carNumberPattern.matcher(number).matches()){
            result = new CarNumber(Integer.parseInt(number.substring(0, 2)), number.substring(2, 4), Integer.parseInt(number.substring(4)));
        }
        return result;
    }
}

package homeworks.homework22.task1;

import java.util.regex.Pattern;

public class CarNumbers implements Comparable<CarNumbers> {
    private int prefix;
    private String seria;
    private int suffix;

    public CarNumbers(int prefix, String seria, int suffix) {
        this.prefix = prefix;
        this.seria = seria;
        this.suffix = suffix;
    }

    public CarNumbers() {
    }


    public static CarNumbers createNumber(String number) {
        Pattern carNumberPattern = Pattern.compile("^\\d{2}[a-zA-Z]{2}\\d{3}$");
        CarNumbers result = null;
        if (carNumberPattern.matcher(number).matches()) {
            result = new CarNumbers(Integer.parseInt(number.substring(0, 2)), number.substring(2, 4), Integer.parseInt(number.substring(4)));
        }
        return result;
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
        return "CarNumbers{" +
                "prefix=" + prefix +
                ", seria='" + seria + '\'' +
                ", suffix=" + suffix +
                '}';
    }

    @Override
    public int compareTo(CarNumbers o) {
        return 0;
    }
}

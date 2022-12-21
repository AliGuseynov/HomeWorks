package Task3;

import java.time.LocalDate;
import java.time.Year;

public class DateCalculate {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(2003, 3, 1);
        int thisYear = Year.now().getValue()+50;//2072 ye kimi
        for (LocalDate date = birthday; date.getYear() <= thisYear; date = date.plusYears(1)){
            System.out.print(date.getYear()+": ");
            System.out.print(date.getDayOfWeek()+"\n");
        }

    }
}

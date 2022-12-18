import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        // Task 01
//        SWITCH operatoru ile yoxla.
//        Verilmiş ədədin 1-ile 12 arasinda olugunu yoxla.(1 ve 12 ozude daxil olmaq sherti ile)

        int input = 15;

        switch (input) {
            case 1:
                System.out.println("Yanvar");
                break;
            case 2:
                System.out.println("Fevral");
                break;
            case 3:
                System.out.println("Mart");
                break;
            case 4:
                System.out.println("Aprel");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("Iyun");
                break;
            case 7:
                System.out.println("Iyul");
                break;
            case 8:
                System.out.println("Avqust");
                break;
            case 9:
                System.out.println("Sentyabr");
                break;
            case 10:
                System.out.println("Oktyabr");
                break;
            case 11:
                System.out.println("Noyabr");
                break;
            case 12:
                System.out.println("Dekabr");
                break;
            default:
                System.out.println("Ilde 12 ay movcuddur");
        }

        // 2. Sinifde etdiyimiz kocurulme komissiyasini BigDecimal ile hell etmek.
        // 0 - 100 0%
        // 101 - 500 5%
        // 501 - 700 7%
        /// 701+ 10%

        input = 1000;
        BigDecimal amount = new BigDecimal(input);
        BigDecimal fee = new BigDecimal(0);

        if(input <= 100) {

            System.out.println("Amount = " + amount);
            System.out.println("Fee = " + fee);
        } else if (input <= 500) {

            amount = amount.subtract(new BigDecimal(100));
            fee = amount.multiply(BigDecimal.valueOf(0.05));

            System.out.println("Amount = " + input);
            System.out.println("Fee = " + fee);
        } else if (input <= 700) {

            fee = new BigDecimal(400 * 0.05);

            amount = amount.subtract(new BigDecimal(500));

            fee = fee.add(
                    amount.multiply(BigDecimal.valueOf(0.07))
            );

            System.out.println("Amount = " + input);
            System.out.println("Fee = " + fee);
        } else {
            fee = new BigDecimal(400 * 0.05);
            fee = fee.add(new BigDecimal(200 * 0.07));

            amount = amount.subtract(new BigDecimal(700));

//            fee = fee.add(
//                    amount.multiply(BigDecimal.valueOf(0.1))
//            );

            System.out.println("Amount = " + input);
            System.out.println("Fee = " + fee);
        }

        // 3. Üç nəfərin yaşını artan qaydada sıralayan bir proqram yazın.
        int asimanAge = 30;
        int hasanAge = 18;
        int shamsAge = 21;
        int min = 0;
        int mid = 0;
        int max = 0;

//        if(asimanAge > hasanAge && asimanAge > shamsAge) {
//            max = asimanAge;
//
//            min = (hasanAge < shamsAge)? hasanAge : shamsAge;
//        } else {
//            max = (hasanAge > shamsAge)? hasanAge : shamsAge;
//            min = (asimanAge < (hasanAge + shamsAge - max))? asimanAge : (hasanAge + shamsAge - max);
//        }

        max = Math.max(asimanAge, hasanAge);
        max = Math.max(max, shamsAge);

        min = Math.min(asimanAge, hasanAge);
        min = Math.min(min, shamsAge);

        mid = asimanAge + hasanAge + shamsAge - max - min;

        System.out.println(max + " " + mid + " " + min);

        // escalator
        boolean isAuto = false;
        boolean isWorking = true;
        boolean isStuck = false;
        int weight = 1000;

        //əgər göndərilən sürət rejimi bu limiti aşırsa, ona çəkiyə uyğun maksimum rejim mənimsədilməlidir.
        int speed = speedMod(weight);

        if(isWorking) {
            if(isAuto) { // auto ON

                // Əgər eskalator avtomatik rejimdə işləyirsə, onun çəkisi yoxlanılır - əgər yük yoxdursa dayanır,
                // əgər yük varsa isə düşür.
                // Lakin yük 1000 kg artıqdırsa və ya eskalatorun sonunda nəsə ilişibsə o mütləq dayanmalıdır.
                isWorking = (weight == 0 || weight > 1000 || isStuck)? false : true;
                if(!isWorking) return;

                // speed mode selection
                speed = speedMod(weight);

                System.out.println("Auto mode ON");
                System.out.println("Speed mode = " + speed);
            } else { // manual ON

                isWorking = (weight > 1000)? false : true;
                if(!isWorking) return;

                System.out.println("Manual mode ON");
                System.out.println("Weight = " + weight);
            }
        } else {
            System.out.println("escalator dont work");
        }

    }

    public static int speedMod(int weight) {

        if(weight <= 300) {
            return  4;
        } else if (weight <= 500) {
            return  3;
        } else if (weight <= 800) {
            return  2;
        } else {
            return  1;
        }
    }
}
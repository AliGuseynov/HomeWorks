public class Main {
    public static void main(String[] args) {
//        Task 1
//        1. 1-1000 qədər ədədlərin içərisindən ələ ədədləri çap et ki:
//        həm rəqəmləri cəmi 5-ə bölünsün, həm də özü 5-ə bölünsün.

        for(int i = 1; i <= 1000; i++) {
            if(i % 5 == 0 && sumOfDigit(i) % 5 == 0)
                System.out.println(i);
        }

        System.out.println();
//        Task 2
//        2. Verilmiş ədədin neçə mərtəbəli olduğunu təyin edin. Məs: İnput: 23456  Output: 5
//        ve teklik, onluq, yuzluk mertebe siniflerinnen hansina aiddirse ekrana onu yazdirin
//        mes: 123 - yuzluk, 12 - onluq, 4 - teklik.
        int number = 23456;
        int tmp = number;
        int numOfDigit = 0;

        while(number > 0) {
            numOfDigit++;
            number /= 10;
        }

        System.out.println("Num: " + tmp);
        System.out.println("numOfDigit: " + numOfDigit);
        System.out.println(tmp % 1000 + " - yuzluk");
        System.out.println(tmp % 100 + " - onluq");
        System.out.println(tmp % 10 + " - teklik");

        System.out.println();
//      Task 3
//      3. Verlmiş ədədin sadə rəqəmlərinin cəmini tapın. Məs: İnput: 123456  Output: 11

        // 1 is not prime number !!

        number = 23456;
        tmp = number;
        int digit = 0;
        int sumOfDigit = 0;

        while(number > 0) {
            digit = number % 10;

            if (isPrime(digit)) {
                sumOfDigit += digit;
            }

            number /= 10;
        }

        System.out.println(tmp);
        System.out.println(sumOfDigit);

        System.out.println();
//        Task 4
//        4. Verlmiş ədədin palindrome olub-olmamasını yoxlayın. Məs: İnput: 123321 Output: true

        number = 1251;
        tmp = number;
        int palindrom = 0;

        while(number > 0) {
            palindrom = (palindrom * 10) + (number % 10);

            number /= 10;
        }

        if (tmp == palindrom)
            System.out.println(tmp + " is palindrome");
        else
            System.out.println(tmp + " is not palindrome");


        System.out.println();
//        Task 5
//        İnteger massivində verilmiş ədədlərin ən böyüyünü tapın. Məs: İnput: [10,23,2,45,7]  Output: 45
        int numbers[] = {10, -5, 254, 1, 2, 999};
        int max = Integer.MIN_VALUE;

        for (int num:numbers) {
            if(num > max)
                max = num;
        }

        System.out.println(max);

//        Task 6
//        Verilmiş ədədin rəqəmlərinin unikal(təkrarlanmayan) olub-olmamasını yoxlayın.
//        Məs: İnput: 53213 Output: false(3 ədədi təkrarlanır)

        number = 53213;
        String nums = Integer.toString(number);
        boolean isRepeat = false;

        for (int i = 0; i < nums.length(); i++) {

            for (int j = i + 1; j < nums.length(); j++) {

                if(nums.charAt(i) == nums.charAt(j)) {

                    isRepeat = true;
                    i = nums.length();
                    break;
                }
            }

        }

        System.out.println(isRepeat);

        System.out.println();
//        Task 7
//        1-1000 qədər ədədlərin içərisindən ələ ədədləri çap et ki:
//        rəqəmləri cəmi 3-ə bölünsün və sonuncu rəqəm 3 olmasın.

        for(int i = 0; i <= 1000; i++) {
//            if(sumOfDigit(i) % 3 == 0 && i % 10 != 3)
//                System.out.println(i);
        }

    }
    public static int sumOfDigit(int number) {
        int sum = 0;

        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static boolean isPrime(int number) {

        // 1 is not prime number !!
        if (number <= 1) return false;

        if (number == 2) return true;

        if (number % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
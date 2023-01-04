package az.code.hanoiTower;

public class Main {
    public static void main(String[] args) {

        String hanoiStep = hanoiTower(5, 1, 3);

        for (String step : hanoiStep.split(" ")) {
            System.out.println(step);
        }
    }


    public static String hanoiTower(int count, int from, int to) {
        if (count == 1) {
            return from + "->" + to + " ";
        } else {
            String sol1, sol2, sol3;
            int help = 6 - from - to;

            sol1 = hanoiTower(count - 1, from, to);
            sol2 = from + "->" + to + " ";
            sol3 = hanoiTower(count - 1, help, to);

            return sol1 + sol2 + sol3;
        }
    }
}

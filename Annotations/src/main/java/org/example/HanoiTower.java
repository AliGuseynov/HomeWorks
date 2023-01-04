package org.example;

public class HanoiTower {

    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
    {
        if (n == 1)
        {
            System.out.println("Disk 1 " +  from_rod + " -> " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Disk " + n + " " +  from_rod + " -> " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }


}

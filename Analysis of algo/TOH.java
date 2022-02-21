import java.util.*;
import java.io.*;
import java.math.*;

class TOH {
    
    static void towerOfHanoi(int n, char from_rod,
            char to_rod, char aux_rod) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " +
                from_rod + " to rod " + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    // Driver code
    public static void main(String args[]) {
        int n = 5; // Number of disks
        System.out.println("63050144\nTower of hanoi 5 plates\nmove from rod A to rod C\n----------");
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }
}
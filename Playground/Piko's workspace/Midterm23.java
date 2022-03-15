import java.util.Random;
import java.util.Arrays;
public class Midterm23 {
    public static void main(String[] args) {
        Random rd = new Random();
        // for example we use 10 data
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++)
            arr[i] = rd.nextInt(100);
        //System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length-1);
        //System.out.println(Arrays.toString(arr));
        closetPair(arr);
    }

    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void closetPair(int[] arr){
        int min = Integer.MAX_VALUE;
        int pa = 0, pb = 0;
        for(int i = 1; i < arr.length; i++){
            if(Math.abs(arr[i] - arr[i-1]) < min){
                pa = arr[i]; pb = arr[i-1]; min = (int)Math.abs(arr[i] - arr[i-1]);
            }
        }
        System.out.println("Closet pair was " + pa + " " + pb);
    }
}

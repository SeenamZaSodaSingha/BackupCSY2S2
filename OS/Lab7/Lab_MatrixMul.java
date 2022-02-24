import java.util.Arrays;

public class Lab_MatrixMul {
    public static void main(String[] args){
        int[][] inputA = {{5, 6, 7}, {4, 8, 9}};
        int[][] inputB = {{6, 4}, {5, 7}, {1, 1}};

        MyData matA = new MyData(inputA);
        MyData matB = new MyData(inputB);
        int matC_r = matA.data.length;
        int matC_c = matB.data[0].length;
        MyData matC = new MyData(matC_r, matC_c);

        for(int i = 0; i < matC_r; i++){
            for(int j = 0; j < matC_c; j++){
                MatrixChild ps = new MatrixChild(i, j, matA, matB, matC);
                Thread tl = new Thread(ps);
                tl.start();
                matC = ps.datC;
            }
        }
        matC.show();
   }
}

class MatrixChild implements Runnable { 
    int processing_row; 
    int processing_col; 
    MyData datA; 
    MyData datB; 
    MyData datC; 
    MatrixChild(int r, int C, MyData a, MyData b, MyData c) {

        processing_row = r;
        processing_col = C;
        datA = a;
        datB = b;
        datC = c;
    } 

    public void run() {
        int sum = 0;
        for (int i = 0; i < datA.data[0].length; i++) {
            sum += datA.data[processing_row][i] * datB.data[i][processing_col];
        }
        datC.data[processing_row][processing_col] = sum;
    } 
}

class MyData { 
    int[][] data;
    
    MyData(int[][] m) { data = m; } 
    
    MyData(int r, int c) { 
        data = new int[r][c]; 
        for (int[] aRow : data) 
            Arrays.fill(aRow, 9); 
            // 9 will be overwritten anyway 
    }
    void show() { 
        System.out.println(Arrays.deepToString(data)); 
    }
}
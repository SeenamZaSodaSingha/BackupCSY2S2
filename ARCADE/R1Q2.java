import java.util.Scanner;

public class R1Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String out = "";

        int num = sc.nextInt();
        // boolean hund = false, tens = false, digit = false;
        String[] wList = {"\u0E28\u0E39\u0E19\u0E22\u0E4C", //0
        "\u0E2B\u0E19\u0E36\u0E48\u0E07", //1
        "\u0E2A\u0E2D\u0E07", //2
        "\u0E2A\u0E32\u0E21", //3
        "\u0E2A\u0E35\u0E48", //4
        "\u0E2B\u0E49\u0E32", //5
        "\u0E2B\u0E01", //6
        "\u0E40\u0E08\u0E47\u0E14", //7
        "\u0E41\u0E1B\u0E14", //8
        "\u0E40\u0E01\u0E49\u0E32", //9
        "\u0E2A\u0E34\u0E1A", //10
        "\u0E40\u0E2D\u0E47\u0E14", //x1, 11
        "\u0E22\u0E35\u0E48", //2x, 12
        "\u0E23\u0E49\u0E2D\u0E22"}; //100, 13

        if(num == 100) System.out.println(wList[1] + wList[13]); //100
        else if(num == 0) System.out.println(wList[0]); //0
        if(num > 9){ //tens
            int tens = num/10, digit = num%10;
            // tens read
            for(int i = 3; i < 10; i++){
                if(tens == 1){
                    out += wList[10];
                    // System.out.println(out);
                    break;
                }else if(tens == 2){
                    out += wList[12] + wList[10];
                    // System.out.println(out);
                    break;
                }else if(tens == i){
                    out += wList[i] + wList[10];
                }
            }
                //digit read
                if(digit == 0) System.out.println(out);
                else if(digit == 1){
                    out += wList[11];
                    System.out.println(out);
                } else {
                    for(int j = 2; j < 10; j++){
                        if(j == digit) {
                            out += wList[j];
                            System.out.println(out);
                            break;
                        }
                    }
            }
        }else{
            if (num == 1) {
                System.out.println(wList[1]);
            } else {
                for (int j = 2; j < 10; j++) {
                    if (j == num) {
                        out += wList[j];
                        System.out.println(out);
                        break;
                    }
                }
            }
        }
    }
}
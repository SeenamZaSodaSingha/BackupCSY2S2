public class Tray implements Runnable{
    int[] data = new int[5];
    int lastBake = 0;

    void cakeCooked(){
        for(int cakeNo = 0; cakeNo < 20; cakeNo++){
            System.out.println("cake number " + cakeNo + " is put on slot number " + lastBake + ".");
            data[lastBake++] = cakeNo;
            if(lastBake == 5) lastBake = 0;
        }
        
    }

    void buy(){
        for(int buyThisPiece = 0; buyThisPiece < 20; buyThisPiece++){
            System.out.println("cake " + data[buyThisPiece] + " is sold. (" + buyThisPiece++ + ")");
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args){
        MovieList ml = new MovieList();
        // ml.displayByRevenue();
        // ml.displayByDirector();
        // ml.displayByYear();
        ml.displayRevenueByDirector();
    }
}
import java.util.Comparator;

public class by_director implements Comparator<Movie>{
    
    @Override
    public int compare(Movie one, Movie two) {

        int min = ((one.directer).length() > (two.directer).length())? (two.directer).length():(one.directer).length();
        String tmp1 = (one.directer);
        String tmp2 = (two.directer);
        if(tmp1.equals(tmp2)){

            if(one.yearRelease < one.yearRelease) return -1;
            else if(one.yearRelease > one.yearRelease) return 1;

        }else{

            for(int i = 0; i < min; i++){

                if(tmp1.charAt(i) < tmp2.charAt(i)) return -1;
                else if(tmp1.charAt(i) > tmp2.charAt(i)) return 1;
    
            }

        }

        return 0;
    }

}

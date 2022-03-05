import java.util.Comparator;

class by_revenue implements Comparator<Movie>{
    
    public int compare(Movie one, Movie two){
        if(one.revenue < two.revenue) return -1;
        else if(one.revenue > two.revenue) return 1;
        else{

            int min = ((one.title).length() > (two.title).length())? (two.title).length():(one.title).length();
            String tmp1 = (one.title);
            String tmp2 = (two.title);
            for(int i = 0; i < min; i++){

                if(tmp1.charAt(i) < tmp2.charAt(i)) return -1;
                else if(tmp1.charAt(i) > tmp2.charAt(i)) return 1;

            }
            return 0;

        }
    }

}

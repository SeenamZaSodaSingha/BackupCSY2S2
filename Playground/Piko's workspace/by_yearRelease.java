import java.util.Comparator;

class by_yearRelease implements Comparator<Movie>{
    
    @Override
    public int compare(Movie one, Movie two) {
        if(one.yearRelease < two.yearRelease) return -1;
        else if(one.yearRelease > two.yearRelease) return 1;
        else{
            if(one.revenue < two.revenue) return -1;
            else if(one.revenue > two.revenue) return 1;
        }
        return 0;
    }

}

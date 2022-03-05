import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class MovieList{

    ArrayList<Movie> movieData = new ArrayList<>();

    MovieList() {
        try {

            Path inFile = Paths.get(".", "Movies.txt");
            Charset charset = Charset.forName("UTF-8");
            BufferedReader s = Files.newBufferedReader(inFile, charset);
            {
                String line;
                boolean check = true;
                while ((line = s.readLine()) != null) {

                    String[] tmpDataLine = line.split("\t");
                    if (tmpDataLine[3].equals("year"))
                        continue;
                    else {
                        for (String x : tmpDataLine) {
                            if (x.equals("0")) {
                                check = false;
                                break;
                            }
                        }
                        if (check)
                            movieData.add(new Movie(tmpDataLine[0], tmpDataLine[7], tmpDataLine[3], tmpDataLine[12]));
                        check = true;
                    }

                }
            }

        } catch (Exception e) {
        }

    }

    void displayRevenueByDirector() {

        HashMap<String, Double> directorCount = new HashMap<>();
        for (Movie tmp : movieData) {

            if (directorCount.containsKey(tmp.directer))
                directorCount.put(tmp.directer, directorCount.get(tmp.directer) + tmp.revenue);
            else
                directorCount.put(tmp.directer, tmp.revenue);

        }

        List<String> director = new ArrayList<>(directorCount.keySet());
        List<Double> revenue = new ArrayList<>(directorCount.values());
        for (int i = 0; i < director.size(); i++) {
            System.out.println("----------------- No. " + (i + 1) + " ------------------");
            System.out.println("Directer : " + director.get(i));
            System.out.println("Revenue  : " + revenue.get(i));
        }
        System.out.println("---------------------------------------------");

    }

    void displayByRevenue() {
        Collections.sort(movieData, new Comparator<Movie>() {
            public int compare(Movie one, Movie two) {
                if (one.revenue < two.revenue)
                    return -1;
                else if (one.revenue > two.revenue)
                    return 1;
                else {

                    int min = ((one.title).length() > (two.title).length()) ? (two.title).length()
                            : (one.title).length();
                    String tmp1 = (one.title);
                    String tmp2 = (two.title);
                    for (int i = 0; i < min; i++) {

                        if (tmp1.charAt(i) < tmp2.charAt(i))
                            return -1;
                        else if (tmp1.charAt(i) > tmp2.charAt(i))
                            return 1;

                    }
                    return 0;

                }
            }
        });
        // Collections.sort(movieData, new by_revenue());
    }

    void displayByDirector() {
        Collections.sort(movieData, new by_director());
    }

    void displayByYear() {
        Collections.sort(movieData, new by_yearRelease());
    }

    @Override
    public String toString() {
        for (Movie i : movieData) {
            System.out.println("Title: " + i.title + " directer: " + i.directer + " yearRelease: " + i.yearRelease
                    + " revenue: " + i.revenue);
        }
        return "";
    }

}
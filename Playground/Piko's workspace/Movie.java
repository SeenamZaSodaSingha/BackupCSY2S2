
class Movie {

    String title;
    String directer;
    int yearRelease;
    double revenue;

    Movie(String title, String directer, String yearRelease, String revenue){

        this.title = title;
        this.directer = directer;
        this.yearRelease = Integer.parseInt(yearRelease);
        this.revenue = Long.parseLong(revenue);

    }
    
}
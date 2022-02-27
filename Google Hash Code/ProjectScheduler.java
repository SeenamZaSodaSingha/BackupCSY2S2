// import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
// import java.util.List;

public class ProjectScheduler {
    public static void main(String[] args) {
        //how to match skill point with the name
        //each person contain theri own skill hash map

        Scanner sc = new Scanner(System.in);
        ArrayList<Contributor> team = new ArrayList<Contributor>();
        ArrayList<Project> work = new ArrayList<Project>();

        int amtContributor = sc.nextInt();
        int amtProject = sc.nextInt();
        String name;

        //set all contributor skill 
        for(int i = 0; i < amtContributor; i++){

            name = sc.next();
            int amountSkill = sc.nextInt();
            team.add(new Contributor(name));

            for(int j = 0; j < amountSkill; j++){  
                team.get(i).setSkill(sc.next(), sc.nextInt());
            }
        }

        //set project
        int dayUse, score, due, contribUse;
        for(int i = 0; i < amtProject; i++){
            name = sc.next(); dayUse = sc.nextInt(); score = sc.nextInt();
            due = sc.nextInt(); contribUse = sc.nextInt();
            work.add(new Project(name, dayUse, score, due, contribUse));
            for(int j = 0; j < contribUse; j++){  
                work.get(i).setProJect(sc.next(), sc.nextInt());
            }
        }
        //end of input part

        //prit project state
        System.out.println("\n-------- CONTRIBUTOR STATE --------");
        for(int i = 0; i < team.size(); i++){
            team.get(i).personState();
        }
        System.out.println("\n---------- PROJECT STATE ----------");
        for(int i = 0; i < work.size(); i++){
            work.get(i).projectState();
        }
        sc.close();
    }
}

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Project {

    HashMap<String, Integer> req = new HashMap<String, Integer>();
    private String projectName;
    private int dayUse, due, score, contribCount, curIdx = 0;
    private List<String> list = new ArrayList<String>();
    
    Project(String name, int dayUse, int score, int due, int contrib){ 

        this.projectName = name;
        this.dayUse = dayUse;
        this.score = score;
        this.due = due;
        this.contribCount = contrib;
    }

    //setter
    void setProJect(String skill, int score){ req.put(skill, score); }
    void skillToList(){
        //convert from set<> to list
        list.addAll(req.keySet());
    }

    //getter
    int getDayUse(){ return dayUse; }
    int getdue(){ return due; }
    int getLevel() { return score; }
    int getContribCnt() { return contribCount; }
    String getSkill(){ return list.get(curIdx++); }

    void projectState(){
        System.out.printf("---- %s's state ----\n", projectName);
        System.out.println("Day use\t" + dayUse);
        System.out.println("Point\t" + score);
        System.out.println("Due\t" + due);
    }
}

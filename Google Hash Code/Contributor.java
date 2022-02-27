import java.util.HashMap;

class Contributor{
    HashMap<String, Integer> skillSets = new HashMap<String, Integer>();
    private String name;

    //skill as key and value = skill point
    Contributor(String name){ this.name = name; }

    // create map
    void setSkill(String skill, int score){ skillSets.put(skill, score); }

    //update phase
    void updateSkillPoint(String updateSkill){
        int score = skillSets.get(updateSkill);
        skillSets.put("updateSkill", score++);
    }

    // get value
    String getName(){ return name; }
    int getSkillPoint(String skill) { return skillSets.get(skill); }

    //get person state
    void personState(){
        System.out.printf("---- %s's state ----\n", name);
        for(String sk : skillSets.keySet()){
            String key = sk;
            int score = skillSets.get(sk);
            System.out.println(key + "\t" + score);
        }
    }
}